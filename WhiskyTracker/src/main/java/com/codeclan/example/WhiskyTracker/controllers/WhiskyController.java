package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
public class WhiskyController {
    @Autowired
    WhiskyRepository whiskyRepository;



    @GetMapping(value = "/whiskys")
    public ResponseEntity<List<Whisky>> findWhiskysByYear(@RequestParam(name="year",required = false)Integer year){
        if(year != null){
            return new ResponseEntity<>(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping(value = "/whiskys/region")
    public ResponseEntity<List<Whisky>> findWhiskysByRegion(@RequestParam(name="region",required = false)String region){
        return new ResponseEntity<>(whiskyRepository.findByDistilleryRegionIgnoreCase(region),HttpStatus.OK);
    }

    @GetMapping(value = "/whiskys/distilleries")
    public ResponseEntity<List<Whisky>> findWhiskysByYear(@RequestParam(name="name",required = false)String name,@RequestParam(name="age") int age){
        return new ResponseEntity<>(whiskyRepository.findByDistilleryNameAndAge(name,age),HttpStatus.OK);
    }



}
