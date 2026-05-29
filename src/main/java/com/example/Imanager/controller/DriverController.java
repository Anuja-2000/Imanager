package com.example.Imanager.controller;

import com.example.Imanager.dto.DriverDTO;
import com.example.Imanager.service.DriverService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/drivers")
@CrossOrigin(origins = "*")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping("/{id}")
    public DriverDTO getDriverById(@PathVariable int id) {
        return driverService.getDriverById(id);
    }

    @GetMapping("")
    public List<DriverDTO> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @GetMapping("name")
    public DriverDTO getDriverByName(@RequestParam String name) {
        return driverService.findByName(name);
    }
    
    
}
