package com.labs.employeemanagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyContactDTO {
    private int emergency_contact_id;

    private String first_name;

    private String middle_name;

    private String last_name;

    private String phone_number;

    private String relationship;

    private boolean dependent;

    private boolean main_contact;
}
