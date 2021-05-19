package com.avgona.citizencrud.repository;

import com.avgona.citizencrud.entity.Ambassador;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AmbassadorRepository extends MongoRepository<Ambassador, String> {
    List<Ambassador> findByEmbassyNumber(int numberOfEmbassy);
    List<Ambassador> findByCountry(String country);
}
