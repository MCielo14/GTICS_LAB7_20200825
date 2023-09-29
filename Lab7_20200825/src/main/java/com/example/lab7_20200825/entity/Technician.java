package com.example.lab7_20200825.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "technician", schema = "lab7gtics")
public class Technician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TechnicianID", nullable = false)
    private int id;

    @Size(min = 3,max = 100,message = "Entre 3 y 100 caracteres")
    @NotNull
    @Column(name = "FirstName", nullable = false, length = 100)
    private String firstName;

    @Size(min = 3,max = 100,message = "Entre 3 y 100 caracteres")
    @NotNull
    @Column(name = "LastName", nullable = false, length = 100)
    private String lastName;

    @Digits(integer = 8,fraction = 0)
    @NotNull
    @Column(name = "Dni", nullable = false, length = 8)
    private String dni;

    @Positive
    @Digits(integer = 9,fraction = 0)
    @NotNull
    @Column(name = "Phone", nullable = false, length = 9)
    private String phone;
    @Positive
    @Digits(integer = 3,fraction = 0)
    @NotNull
    @Column(name = "Age", nullable = false)
    private Integer age;


}