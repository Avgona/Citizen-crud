package com.avgona.citizencrud.service;

import com.avgona.citizencrud.entity.Citizen;

import java.util.List;

public interface CitizenService {
    List<Citizen> findAll();

    Citizen findById(long id);

    void save(Citizen citizen);

    void deleteById(long id);

    List<Citizen> searchBy(String name);

}
