package com.labs.employeemanagement.service.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInformationDTO {
    private int personal_info_id;

    private String first_name;

    private String middle_name;

    private String last_name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth_date;

    private byte age;

    private String permanent_address;

    private String present_address;

    private String status;

    private String passport_id;

    private String sss_id;

    private String pagibig_id;

    private String philhealth_id;

    private List<EmergencyContactDTO> emergency_contact;
}
