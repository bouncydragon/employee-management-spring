package com.labs.employeemanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labs.employeemanagement.model.EmergencyContact;
import com.labs.employeemanagement.model.PersonalInformation;
import com.labs.employeemanagement.repository.PersonalInformationRepository;
import com.labs.employeemanagement.service.dto.EmergencyContactDTO;
import com.labs.employeemanagement.service.dto.PersonalInformationDTO;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PersonalInformationService {

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    public PersonalInformationDTO findPersonalInformation(Long id) {
        // PersonalInformation personalInfo = personalInformationRepository.findById(id)
        //                                     .orElseThrow(() -> new EntityNotFoundException("Personal information with id " + id + " does not exist!"));
        // List<EmergencyContact> emergencyContacts = personalInfo.getEmergencyContacts();
        // List<EmergencyContactDTO> emergencyContactDTOs = new ArrayList<>();
        // for (EmergencyContact emergencyContact : emergencyContacts) {
        //     EmergencyContactDTO emergencyContactDTO = new EmergencyContactDTO(emergencyContact.getEmergencyContactId(), 
        //     emergencyContact.getFirstName(), emergencyContact.getMiddleName(), emergencyContact.getLastName(), 
        //     emergencyContact.getPhoneNumber(), emergencyContact.getRelationship(), emergencyContact.isDependent(), 
        //     emergencyContact.isMainContact());
        //     emergencyContactDTOs.add(emergencyContactDTO);
        // }
        // PersonalInformationDTO piData = new PersonalInformationDTO(
        //     personalInfo.getPersonalInfoId(), personalInfo.getFirstName(), personalInfo.getMiddleName(),
        //     personalInfo.getLastName(), personalInfo.getBirthDate(), personalInfo.getAge(), personalInfo.getPermanentAddress(),
        //     personalInfo.getPresentAddress(), personalInfo.getStatus(), personalInfo.getPassportId(), personalInfo.getSssId(),
        //     personalInfo.getPagibigId(), personalInfo.getPhilhealthId(), emergencyContactDTOs
        //     );
        return null;
    }
}
