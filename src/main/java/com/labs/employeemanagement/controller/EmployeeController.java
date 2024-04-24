package com.labs.employeemanagement.controller;

import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.labs.employeemanagement.model.Employee;
import com.labs.employeemanagement.service.EmployeeService;
import com.labs.employeemanagement.service.dto.AllInformationDTO;
import com.labs.employeemanagement.service.dto.RequestDTO;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    @CacheEvict(value = "employees", allEntries = true)
    ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee payload) {
        Employee savedEmployee = employeeService.createEmployee(payload);
        return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping()
    @Cacheable("employees")
    List<Employee> getEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/search/{id}")
    @Cacheable("employee")
    ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee retrievedEmployee = employeeService.findById(id);
        return new ResponseEntity<Employee>(retrievedEmployee, HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateEmployeeById(@PathVariable("id") Long id, @RequestBody Map<String, Object> fields) {
        Employee updatedEmployee = employeeService.updateEmployeeById(id, fields);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok("Employee id " + id + " has been deleted!");
    }

}
