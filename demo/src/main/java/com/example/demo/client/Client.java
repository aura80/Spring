package com.example.demo.client;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
@Data
public class Client {

    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private Long id;
    private String name;
    @Transient
    private Integer age;
    private String email;
    private LocalDate dob;

    public Client() {
    }

    public Client(String name, String email, LocalDate dob) {
        this.name = name;
//        this.age = age;
        this.email = email;
        this.dob = dob;
    }

    public Client(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
//        this.age = age;
        this.email = email;
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }
}
