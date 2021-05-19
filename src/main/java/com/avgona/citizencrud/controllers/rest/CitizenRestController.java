package com.avgona.citizencrud.controllers.rest;

import com.avgona.citizencrud.entity.Citizen;
import com.avgona.citizencrud.service.CitizenService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CitizenRestController {

    private final CitizenService citizenService;

    @Autowired
    public CitizenRestController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @ApiOperation("Find all citizens")
    @GetMapping("/citizens")
    public List<Citizen> findAll() {
        return citizenService.findAll();
    }

    @ApiOperation("Show all details of citizen")
    @GetMapping("/citizens/details/{id}")
    public Citizen viewDetails(@PathVariable long id){
        return citizenService.findById(id);
    }

    @ApiOperation("Create new citizen")
    @PostMapping("/citizens/save")
    public Citizen save(Citizen citizen) {
        return citizen;
    }

    @ApiOperation("Detele a citizen")
    @GetMapping("/citizens/delete/{id}")
    public void delete(@PathVariable long id) {
        citizenService.deleteById(id);
    }
}
