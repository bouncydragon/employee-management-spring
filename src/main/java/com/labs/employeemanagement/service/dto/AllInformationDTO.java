package com.labs.employeemanagement.service.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllInformationDTO {
    
    private EmployeeDTO employee_information;
    private PersonalInformationDTO personal_information;
    private Set<PositionDTO> positions;
}

