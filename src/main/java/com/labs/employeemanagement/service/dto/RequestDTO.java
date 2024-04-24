package com.labs.employeemanagement.service.dto;

import java.util.List;

import com.labs.employeemanagement.model.Employee;
import com.labs.employeemanagement.model.PersonalInformation;
import com.labs.employeemanagement.model.Position;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDTO {
    private Employee employeeInformation;
    private PersonalInformation personalInformation;
    private List<Position> positions;
}
