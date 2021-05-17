package com.avgona.citizencrud.controllers;

import com.avgona.citizencrud.entity.Citizen;
import com.avgona.citizencrud.service.CitizenService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citizen")
public class CitizenRestController {

    private final CitizenService citizenService;

    @Autowired
    public CitizenRestController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @ApiOperation(value = "Find all citizens")
    @GetMapping
    public List<Citizen> findAll() {
        return citizenService.findAll();
    }

    @ApiOperation(value = "Show all details of citizen", notes = "type the id")
    @GetMapping("/details/{id}")
    public Citizen viewDetails(@PathVariable long id){
        return citizenService.findById(id);
    }

    @ApiOperation(value = "Create new citizen")
    @PostMapping("/save")
    public Citizen save(Citizen citizen) {
        return citizen;
    }

    @ApiOperation(value = "Detele a citizen", notes = "type the id")
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        citizenService.deleteById(id);
    }
}
