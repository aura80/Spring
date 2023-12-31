package com.techpro.techpro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "players")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // id is autogenerated
    @Column(name = "player_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "league", length = 30, nullable = false)
    private LeagueEnum league;

    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "country", length = 30, nullable = false)
    private CountryEnum country;

    @OneToMany(mappedBy = "player")
    private List<Files> filesList;
}
