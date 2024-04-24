package com.labs.employeemanagement.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "emergency_contact")
public class EmergencyContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    @Nullable
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "relationship")
    private String relationship;

    @Column(name = "is_dependent", nullable = false)
    private boolean dependent;

    @Column(name = "is_main_contact", nullable = false)
    private boolean mainContact;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_info_id", nullable = false)
    private PersonalInformation personalInformation;
}
