package com.school.school.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "school")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schoolId")
    private Long id;

    @Column(name = "schoolName", nullable = false)
    private String name;

    @Column(name = "schoolAddress", nullable = false)
    private String address;

    @Column(name = "schoolEmail", nullable = false)
    private String email;

    @Column(name = "schoolPhone", nullable = false)
    private String phone;
}
