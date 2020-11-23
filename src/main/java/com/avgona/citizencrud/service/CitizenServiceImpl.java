package com.avgona.citizencrud.service;

import com.avgona.citizencrud.entity.Citizen;
import com.avgona.citizencrud.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitizenServiceImpl implements CitizenService{

    @Autowired
    private CitizenRepository citizenRepository;

    @Override
    public List<Citizen> findAll() {
        return citizenRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Citizen findById(int id) {
        Optional<Citizen> citizen = citizenRepository.findById(id);

        Citizen newCitizen;

        if(citizen.isPresent())
            newCitizen = citizen.get();
        else
            throw new RuntimeException("We didn't find any citizen with the id: " + id);

        return newCitizen;
    }

    @Override
    public void save(Citizen citizen) {
        citizenRepository.save(citizen);
    }

    @Override
    public void deleteById(int id) {
        citizenRepository.deleteById(id);
    }

    @Override
    public List<Citizen> searchBy(String name){
        List<Citizen> result;

        if((name != null) && (name.trim().length()> 0))
            result = citizenRepository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(name, name);
        // if input is empty, we send all citizens
        else
            result = findAll();

        return result;
    }
}
