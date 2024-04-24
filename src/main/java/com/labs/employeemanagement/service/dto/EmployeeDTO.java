package com.labs.employeemanagement.service.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private int emp_id;

    private String emp_code;

    private String emp_email;

    private String hmo_card_no;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate employment_date;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate trainee_date;

    private String payroll_account;

    private String length_of_service;
}
