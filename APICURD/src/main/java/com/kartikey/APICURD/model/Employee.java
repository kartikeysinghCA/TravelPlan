package com.kartikey.APICURD.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empid;
    @Column(name="emp_name")
    private String emp_name;
    @Column(name="emp_salary")
    private Float emp_salary;
    @Column(name="emp_age")
    private int emp_age;
    @Column(name="emp_city")
    private String emp_city;
    @Column(name="emp_role")
    private String emp_role;
}
