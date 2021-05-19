package com.avgona.citizencrud.service;

import com.avgona.citizencrud.entity.Ambassador;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public interface AmbassadorService {
    List<Ambassador> findAll();

    Optional<Ambassador> findById(String id);

    Ambassador save(Ambassador ambassador);

    HttpStatus deleteById(String id);

    List<Ambassador> findByEmbassyNumber(int numberOfEmbassy);

    List<Ambassador> findByCountry(String country);
}
