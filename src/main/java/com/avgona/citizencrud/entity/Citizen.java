package com.avgona.citizencrud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "citizen")
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "passport_number")
    private String passportNumber;

    @Enumerated(EnumType.STRING)
    private Career career;

    @Embedded
    private Address address;

    @ElementCollection
    @CollectionTable(name = "foreign_citizenship", joinColumns = @JoinColumn(name = "citizen_id"))
    @OrderColumn(name = "citizen_order")
    @Column(name = "citizenship")
    private List<String> foreignCitizenship = new ArrayList<>();
}
