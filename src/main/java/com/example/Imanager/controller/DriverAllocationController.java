package com.example.Imanager.controller;

import com.example.Imanager.dto.DriverAllocationDTO;
import com.example.Imanager.service.DriverAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/driver-allocations")
@CrossOrigin(origins = "*")
public class DriverAllocationController {

    @Autowired
    private DriverAllocationService driverAllocationService;

    // GET /api/driver-allocations - Get all driver allocations
    @GetMapping
    public ResponseEntity<List<DriverAllocationDTO>> getAllDriverAllocations() {
        List<DriverAllocationDTO> allocations = driverAllocationService.getAllDriverAllocations();
        return ResponseEntity.ok(allocations);
    }

    // GET /api/driver-allocations/{id} - Get driver allocation by ID
    @GetMapping("/{id}")
    public ResponseEntity<DriverAllocationDTO> getDriverAllocationById(@PathVariable int id) {
        DriverAllocationDTO allocation = driverAllocationService.getDriverAllocationById(id);
        return ResponseEntity.ok(allocation);
    }

    // POST /api/driver-allocations - Create new driver allocation
    @PostMapping
    public ResponseEntity<DriverAllocationDTO> createDriverAllocation(@RequestBody DriverAllocationDTO driverAllocationDTO) {
        DriverAllocationDTO createdAllocation = driverAllocationService.createDriverAllocation(driverAllocationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAllocation);
    }

    // PUT /api/driver-allocations/{id} - Update existing driver allocation
    @PutMapping("/{id}")
    public ResponseEntity<DriverAllocationDTO> updateDriverAllocation(
            @PathVariable int id, 
            @RequestBody DriverAllocationDTO driverAllocationDTO) {
        DriverAllocationDTO updatedAllocation = driverAllocationService.updateDriverAllocation(id, driverAllocationDTO);
        return ResponseEntity.ok(updatedAllocation);
    }

    // DELETE /api/driver-allocations/{id} - Delete driver allocation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriverAllocation(@PathVariable int id) {
        driverAllocationService.deleteDriverAllocation(id);
        return ResponseEntity.noContent().build();
    }

    // GET /api/driver-allocations/driver/{driverId} - Get allocations by driver ID
    @GetMapping("/driver/{driverId}")
    public ResponseEntity<List<DriverAllocationDTO>> getAllocationsByDriverId(@PathVariable int driverId) {
        List<DriverAllocationDTO> allocations = driverAllocationService.getAllocationsByDriverId(driverId);
        return ResponseEntity.ok(allocations);
    }

    // GET /api/driver-allocations/vehicle/{vehicleId} - Get allocations by vehicle ID
    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<List<DriverAllocationDTO>> getAllocationsByVehicleId(@PathVariable int vehicleId) {
        List<DriverAllocationDTO> allocations = driverAllocationService.getAllocationsByVehicleId(vehicleId);
        return ResponseEntity.ok(allocations);
    }

    // GET /api/driver-allocations/date/{date} - Get allocations by date
    @GetMapping("/date/{date}")
    public ResponseEntity<List<DriverAllocationDTO>> getAllocationsByDate(@PathVariable String date) {
        List<DriverAllocationDTO> allocations = driverAllocationService.getAllocationsByDate(date);
        return ResponseEntity.ok(allocations);
    }

    // GET /api/driver-allocations/driver/{driverId}/vehicle/{vehicleId} - Get allocations by driver and vehicle
    @GetMapping("/driver/{driverId}/vehicle/{vehicleId}")
    public ResponseEntity<List<DriverAllocationDTO>> getAllocationsByDriverAndVehicle(
            @PathVariable int driverId, 
            @PathVariable int vehicleId) {
        List<DriverAllocationDTO> allocations = driverAllocationService.getAllocationsByDriverAndVehicle(driverId, vehicleId);
        return ResponseEntity.ok(allocations);
    }
}
