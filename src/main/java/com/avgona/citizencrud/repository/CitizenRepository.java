package com.avgona.citizencrud.repository;

import com.avgona.citizencrud.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {

    // add a method to sort by last name
    public List<Citizen> findAllByOrderByLastNameAsc();

    // search by name
    public List<Citizen> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);

}
