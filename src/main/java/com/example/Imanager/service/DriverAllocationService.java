package com.example.Imanager.service;

import com.example.Imanager.dao.DriverAllocationDAO;
import com.example.Imanager.dto.DriverAllocationDTO;
import com.example.Imanager.entity.DriverAllocation;
import com.example.Imanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverAllocationService {
    
    @Autowired
    private DriverAllocationDAO driverAllocationDAO;

    // Get all driver allocations
    public List<DriverAllocationDTO> getAllDriverAllocations() {
        List<DriverAllocation> allocations = driverAllocationDAO.findAll();
        return allocations.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get driver allocation by ID
    public DriverAllocationDTO getDriverAllocationById(int id) {
        DriverAllocation allocation = driverAllocationDAO.findById(id);
        if (allocation == null) {
            throw new ResourceNotFoundException("Driver allocation not found with id: " + id);
        }
        return convertToDTO(allocation);
    }

    // Create new driver allocation
    public DriverAllocationDTO createDriverAllocation(DriverAllocationDTO driverAllocationDTO) {
        DriverAllocation allocation = convertToEntity(driverAllocationDTO);
        allocation.setAllocationDate(new java.util.Date().toString());
        DriverAllocation savedAllocation = driverAllocationDAO.save(allocation);
        return convertToDTO(savedAllocation);
    }

    // Update existing driver allocation
    public DriverAllocationDTO updateDriverAllocation(int id, DriverAllocationDTO driverAllocationDTO) {
        if (!driverAllocationDAO.existsById(id)) {
            throw new ResourceNotFoundException("Driver allocation not found with id: " + id);
        }
        
        DriverAllocation allocation = convertToEntity(driverAllocationDTO);
        allocation.setId(id);
        DriverAllocation updatedAllocation = driverAllocationDAO.save(allocation);
        return convertToDTO(updatedAllocation);
    }

    // Delete driver allocation
    public void deleteDriverAllocation(int id) {
        if (!driverAllocationDAO.existsById(id)) {
            throw new ResourceNotFoundException("Driver allocation not found with id: " + id);
        }
        driverAllocationDAO.deleteById(id);
    }

    // Get allocations by driver ID
    public List<DriverAllocationDTO> getAllocationsByDriverId(int driverId) {
        List<DriverAllocation> allocations = driverAllocationDAO.findByDriverId(driverId);
        return allocations.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get allocations by vehicle ID
    public List<DriverAllocationDTO> getAllocationsByVehicleId(int vehicleId) {
        List<DriverAllocation> allocations = driverAllocationDAO.findByVehicleId(vehicleId);
        return allocations.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get allocations by allocation date
    public List<DriverAllocationDTO> getAllocationsByDate(String allocationDate) {
        List<DriverAllocation> allocations = driverAllocationDAO.findByAllocationDate(allocationDate);
        return allocations.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get allocations by driver and vehicle
    public List<DriverAllocationDTO> getAllocationsByDriverAndVehicle(int driverId, int vehicleId) {
        List<DriverAllocation> allocations = driverAllocationDAO.findByDriverIdAndVehicleId(driverId, vehicleId);
        return allocations.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Convert Entity to DTO
    private DriverAllocationDTO convertToDTO(DriverAllocation allocation) {
        return new DriverAllocationDTO(
                allocation.getId(),
                allocation.getDriverId(),
                allocation.getVehicleId(),
                allocation.getAllocationDate()
        );
    }

    // Convert DTO to Entity
    private DriverAllocation convertToEntity(DriverAllocationDTO dto) {
        return new DriverAllocation(
                dto.getDriverId(),
                dto.getVehicleId(),
                dto.getAllocationDate()
        );
    }
}
