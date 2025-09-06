package com.example.Imanager.dao;

import com.example.Imanager.entity.DriverAllocation;
import com.example.Imanager.repository.DriverAllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DriverAllocationDAO {

    @Autowired
    private DriverAllocationRepository driverAllocationRepository;

    public DriverAllocation findById(int id) {
        return driverAllocationRepository.findById(id).orElse(null);
    }

    public List<DriverAllocation> findAll() {
        return driverAllocationRepository.findAll();
    }

    public DriverAllocation save(DriverAllocation driverAllocation) {
        return driverAllocationRepository.save(driverAllocation);
    }

    public void deleteById(int id) {
        driverAllocationRepository.deleteById(id);
    }

    public List<DriverAllocation> findByDriverId(int driverId) {
        return driverAllocationRepository.findByDriverId(driverId);
    }

    public List<DriverAllocation> findByVehicleId(int vehicleId) {
        return driverAllocationRepository.findByVehicleId(vehicleId);
    }

    public List<DriverAllocation> findByAllocationDate(String allocationDate) {
        return driverAllocationRepository.findByAllocationDate(allocationDate);
    }

    public List<DriverAllocation> findByDriverIdAndVehicleId(int driverId, int vehicleId) {
        return driverAllocationRepository.findByDriverIdAndVehicleId(driverId, vehicleId);
    }

    public boolean existsById(int id) {
        return driverAllocationRepository.existsById(id);
    }
}
