package com.example.Imanager.repository;

import com.example.Imanager.entity.DriverAllocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverAllocationRepository extends JpaRepository<DriverAllocation, Integer> {

    List<DriverAllocation> findByDriverId(int driverId);

    List<DriverAllocation> findByVehicleId(int vehicleId);

    List<DriverAllocation> findByAllocationDate(String allocationDate);

    List<DriverAllocation> findByDriverIdAndVehicleId(int driverId, int vehicleId);
}
