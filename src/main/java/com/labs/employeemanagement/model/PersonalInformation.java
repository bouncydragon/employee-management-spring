package com.labs.employeemanagement.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "personal_info")
public class PersonalInformation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "birth_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Column(name = "age", nullable = false)
    private Double age;

    @Column(name = "permanent_address")
    private String permanentAddress;

    @Column(name = "present_address")
    private String presentAddress;

    // @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private String status;

    @Column(name = "passport_id")
    private String passportId;

    @Column(name = "sss_id")
    private String sssId;

    @Column(name = "pagibig_id")
    private String pagibigId;

    @Column(name = "philhealth_id")
    private String philhealthId;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private Employee employee;
}
