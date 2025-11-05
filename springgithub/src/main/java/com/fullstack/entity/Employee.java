package com.fullstack.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="EMPLOYEE")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="emp_id")
    private long empId;

    @Column(name="emp_name")
    private String empName;

    @Column(name="emp_email_id")
    private String empEmailId;

    @Column(name="emp_password")
    private String empPassword;

    @Column(name="emp_contact_number")
    private long empContactNumber;

    @Column(name="emp_salary")
    private double empSalary;

    @Column(name="emp_DOB")
    private LocalDate empDOB;

    @Column(name="emp_Address")
    private String empAddress;
}
