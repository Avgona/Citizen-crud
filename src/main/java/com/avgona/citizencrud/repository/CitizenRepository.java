package com.avgona.citizencrud.repository;

import com.avgona.citizencrud.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {
    List<Citizen> findAllByOrderByLastNameAsc();
    List<Citizen> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);
}
