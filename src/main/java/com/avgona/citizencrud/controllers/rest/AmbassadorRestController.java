package com.avgona.citizencrud.controllers.rest;

import com.avgona.citizencrud.entity.Ambassador;
import com.avgona.citizencrud.service.AmbassadorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AmbassadorRestController {

    private final AmbassadorService ambassadorService;

    @Autowired
    public AmbassadorRestController(AmbassadorService ambassadorService) {
        this.ambassadorService = ambassadorService;
    }

    @ApiOperation("Find all ambassadors")
    @GetMapping("/ambassadors")
    public ResponseEntity<List<Ambassador>> getAll(){
        try {
            List<Ambassador> ambassadors = ambassadorService.findAll();

            if (ambassadors.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(ambassadors, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation("Find an ambassador by id")
    @GetMapping("/ambassadors/{id}")
    public ResponseEntity<Ambassador> getById(@PathVariable("id") String id){
        return ambassadorService.findById(id)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @ApiOperation("Create a new ambassador")
    @PostMapping("/ambassadors")
    public ResponseEntity<Ambassador> create(@RequestBody Ambassador ambassador1){
        try {
            Ambassador ambassador = ambassadorService.save(new Ambassador(ambassador1.getFirstName(), ambassador1.getLastName(), ambassador1.getCountry(), ambassador1.getEmbassyNumber()));
            return new ResponseEntity<>(ambassador, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation("Change ambassador's information")
    @PutMapping("/ambassadors/{id}")
    public ResponseEntity<Ambassador> updateAmbassador(@PathVariable("id") String id, @RequestBody Ambassador ambassador1){
        Optional<Ambassador> ambassadorOptional = ambassadorService.findById(id);

        if (ambassadorOptional.isPresent()){
            Ambassador ambassador = ambassadorOptional.get();
            ambassador.setFirstName(ambassador1.getFirstName());
            ambassador.setLastName(ambassador1.getLastName());
            ambassador.setCountry(ambassador1.getCountry());
            ambassador.setEmbassyNumber(ambassador1.getEmbassyNumber());
            return new ResponseEntity<>(ambassadorService.save(ambassador), HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation("Delete an ambassador by id")
    @DeleteMapping("/ambassadors/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") String id){
        return new ResponseEntity<>(ambassadorService.deleteById(id));
    }

    @ApiOperation("Find all ambassadors in specified country")
    @GetMapping("/ambassadors/country/{country}")
    public ResponseEntity<List<Ambassador>> findByCountry(@PathVariable("country") String country){
        try {
            List<Ambassador> ambassadors = ambassadorService.findByCountry(country);

            if (ambassadors.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(ambassadors, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation("Find all ambassadors by specified embassy id")
    @GetMapping("/ambassadors/embassy/{id}")
    public ResponseEntity<List<Ambassador>> findByEmbassyNumber(@PathVariable("id") int embassyNumber){
        try {
            List<Ambassador> ambassadors = ambassadorService.findByEmbassyNumber(embassyNumber);

            if (ambassadors.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(ambassadors, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
