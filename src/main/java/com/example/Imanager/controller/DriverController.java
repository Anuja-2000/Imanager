package com.example.Imanager.controller;

import com.example.Imanager.dto.DriverDTO;
import com.example.Imanager.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/drivers")
@CrossOrigin(origins = "*")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping("/{id}")
    public DriverDTO getDriverById(@PathVariable int id) {
        return driverService.getDriverById(id);
    }
}
