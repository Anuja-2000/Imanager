package com.example.Imanager.service;

import com.example.Imanager.dao.DriverDAO;
import com.example.Imanager.dto.DriverDTO;
import com.example.Imanager.entity.Driver;

import com.example.Imanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
    
    @Autowired
    private DriverDAO driverDAO;

    public DriverDTO getDriverById(int id) {
        Driver driver = driverDAO.findById(id);
        if (driver == null) {
            throw new ResourceNotFoundException("Driver not found");
        }
        return convertToDTO(driver);
    }

    public java.util.List<DriverDTO> getAllDrivers() {
        java.util.List<Driver> drivers = driverDAO.findAll();
        return drivers.stream()
                .map(this::convertToDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    private DriverDTO convertToDTO(Driver driver) {
        return new DriverDTO(driver.getId(), driver.getName(), driver.getLicenseNumber(),
                driver.getNic(), driver.getContactNumber(), driver.getBankAccountNumber(),
                driver.getCommissionPercentage());
    }
}
