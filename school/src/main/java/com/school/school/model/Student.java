package com.school.school.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private Long id;

    @Column(name = "studentName", nullable = false)
    private String name;

    @Column(name = "studentSurname", nullable = false)
    private String surname;

    @Column(name = "studentAge", nullable = false)
    private int age;
}
