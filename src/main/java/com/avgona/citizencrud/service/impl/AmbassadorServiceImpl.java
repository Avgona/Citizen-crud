package com.avgona.citizencrud.service.impl;

import com.avgona.citizencrud.entity.Ambassador;
import com.avgona.citizencrud.repository.AmbassadorRepository;
import com.avgona.citizencrud.service.AmbassadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AmbassadorServiceImpl implements AmbassadorService {

    private final AmbassadorRepository ambassadorRepository;

    @Autowired
    public AmbassadorServiceImpl(AmbassadorRepository ambassadorRepository) {
        this.ambassadorRepository = ambassadorRepository;
    }

    @Override
    public List<Ambassador> findAll() {
        return ambassadorRepository.findAll();
    }

    @Override
    public Optional<Ambassador> findById(String id) {
        return ambassadorRepository.findById(id);
    }

    @Override
    public Ambassador save(Ambassador ambassador) {
        return ambassadorRepository.save(ambassador);
    }

    @Override
    public HttpStatus deleteById(String id) {
        try {
            ambassadorRepository.deleteById(id);
            return HttpStatus.NO_CONTENT;
        }
        catch (Exception e){
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @Override
    public List<Ambassador> findByCountry(String country) {
        return ambassadorRepository.findByCountry(country);
    }
    @Override
    public List<Ambassador> findByEmbassyNumber(int numberOfEmbassy) {
        return ambassadorRepository.findByEmbassyNumber(numberOfEmbassy);
    }
}
