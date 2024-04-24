package com.labs.employeemanagement.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
@Table(name = "employee")
@JsonInclude(Include.NON_NULL)
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "emp_code", nullable = false, unique = true)
    private String empCode;

    @Column(name = "emp_email", nullable = false, unique = true)
    private String empEmail;

    @Column(name = "hmo_card_no")
    private String hmoCardNo;

    @Column(name = "employment_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate employmentDate;

    @Column(name = "trainee_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate traineeDate;

    @Column(name = "payroll_account")
    private String payrollAccount;

    @Column(name = "length_of_service")
    private Double lengthOfService;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employee")
    @PrimaryKeyJoinColumn
    @JsonManagedReference
    private PersonalInformation personalInformation;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
    CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "employee_position",
        joinColumns = @JoinColumn(name = "employee_id"),
        inverseJoinColumns = @JoinColumn(name = "position_id")
    )
    @JsonIgnoreProperties("employees")
    private List<Position> positions;

    public void assignPosition(Position position) {
        positions.add(position);
    }
}
