package com.example.Imanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.Imanager.dto.TripDTO;
import com.example.Imanager.service.TripService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@RequestMapping("/trips")
@CrossOrigin(origins = "*")
public class TripController {

    @Autowired
    private TripService tripService;

    private static final Logger log = LoggerFactory.getLogger(TripController.class);

    @PostMapping("/create")
    public ResponseEntity<TripDTO> createTrip(@RequestBody TripDTO tripDetails) {
        
        TripDTO createdTrip = tripService.createTrip(tripDetails);
        log.info("Trip created successfully: {}", createdTrip);
        return ResponseEntity.ok(createdTrip);
    }
    
}
