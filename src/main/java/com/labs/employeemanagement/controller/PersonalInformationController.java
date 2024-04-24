package com.labs.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labs.employeemanagement.service.PersonalInformationService;
import com.labs.employeemanagement.service.dto.PersonalInformationDTO;

@RestController
@RequestMapping("/api/v1/personal-information")
public class PersonalInformationController {

    @Autowired
    private PersonalInformationService personalInformationService;

    @GetMapping("/search/{id}")
    public PersonalInformationDTO getPersonalInformation(@PathVariable("id") Long id) {
        return personalInformationService.findPersonalInformation(id);
    }
}
