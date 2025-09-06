package com.example.Imanager.dao;

import com.example.Imanager.entity.Driver;
import com.example.Imanager.repository.DriverRepository;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DriverDAO {

    @Autowired
    private DriverRepository driverRepository;

    public Driver findById(int id) {
        return driverRepository.findById(id).orElse(null);
    }

    public List<Driver> findByName(String name) {
        return driverRepository.findByName(name);
    }

    public Driver findByLicenseNumber(String licenseNumber) {
        return driverRepository.findByLicenseNumber(licenseNumber);
    }

    public Driver findByNic(String nic) {
        return driverRepository.findByNic(nic);
    }

    public Driver findByContactNumber(String contactNumber) {
        return driverRepository.findByContactNumber(contactNumber);
    }

    public Driver findByBankAccountNumber(String bankAccountNumber) {
        return driverRepository.findByBankAccountNumber(bankAccountNumber);
    }

    public Driver findByCommissionPercentage(String commissionPercentage) {
        return driverRepository.findByCommissionPercentage(commissionPercentage);
    }
}
