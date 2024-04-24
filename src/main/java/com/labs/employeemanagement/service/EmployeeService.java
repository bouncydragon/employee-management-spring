package com.labs.employeemanagement.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.labs.employeemanagement.helpers.CalculateLengthOfService;
import com.labs.employeemanagement.model.Employee;
import com.labs.employeemanagement.model.PersonalInformation;
import com.labs.employeemanagement.model.Position;
import com.labs.employeemanagement.repository.EmployeeRepository;
import com.labs.employeemanagement.repository.PersonalInformationRepository;
import com.labs.employeemanagement.repository.PositionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Transactional
    public Employee createEmployee(Employee reqBody) {
        if (reqBody.getPersonalInformation() == null) {
            throw new IllegalArgumentException("Employee must have personal information.");
        }
        if (reqBody.getPositions() == null) {
            throw new IllegalArgumentException("Employee must have position assigned.");
        }

        double age = CalculateLengthOfService.calculateServiceComputation(reqBody.getPersonalInformation().getBirthDate());
        reqBody.getPersonalInformation().setAge(age);

        PersonalInformation savedInfo = personalInformationRepository.save(reqBody.getPersonalInformation());
        reqBody.setPersonalInformation(savedInfo);

        List<Position> positions = new ArrayList<>();
        for (Position position : reqBody.getPositions()) {
            Position existingPosition = positionRepository.findById(position.getId()).orElseThrow(() -> new RuntimeException("Position not found"));
            positions.add(existingPosition);
        }
        double lengthOfService = CalculateLengthOfService.calculateServiceComputation(reqBody.getEmploymentDate());
        reqBody.setLengthOfService(lengthOfService);
        reqBody.setPositions(positions);

        return employeeRepository.save(reqBody);
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee id " + id + " does not exist."));
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional
    public Employee updateEmployeeById(Long id, Map<String, Object> payload) {
        Employee existingEmployee = employeeRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Employee id " + id + " does not exist."));

            payload.keySet().removeIf(key -> "id".equals(key));
        
            try {
                for (Map.Entry<String, Object> entry : payload.entrySet()) {
                    String fieldName = entry.getKey();
                    Field field = Employee.class.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    field.set(existingEmployee, entry.getValue());
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new IllegalArgumentException("Invalid field or error updating field: " + e.getMessage());
            }
        return employeeRepository.save(existingEmployee);
    }

    @Transactional
    public void deleteEmployeeById(Long id) {
        employeeRepository.findById(id)
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee id " + id + " does not exist!"));
        employeeRepository.deleteById(id);
    }

    /*
     * Custom Search By Employee Code
     */
    public Employee findEmployeeByCode(String empCode) {
        return employeeRepository.findByEmpCode(empCode)
                    .orElseThrow(() -> new EntityNotFoundException("Employee code " + empCode + " does not exist."));
    }
}
