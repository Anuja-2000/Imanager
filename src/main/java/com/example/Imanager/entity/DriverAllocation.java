package com.example.Imanager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "driver_allocation")
public class DriverAllocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "driver_id")
    private int driverId;

    @Column(name = "vehicle_id")
    private int vehicleId;

    @Column(name = "allocation_date")
    private String allocationDate;

    // Default constructor
    public DriverAllocation() {}

    // Constructor with parameters
    public DriverAllocation(int driverId, int vehicleId, String allocationDate) {
        this.driverId = driverId;
        this.vehicleId = vehicleId;
        this.allocationDate = allocationDate;
    }

    // Constructor with all fields
    public DriverAllocation(int id, int driverId, int vehicleId, String allocationDate) {
        this.id = id;
        this.driverId = driverId;
        this.vehicleId = vehicleId;
        this.allocationDate = allocationDate;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getAllocationDate() {
        return allocationDate;
    }

    public void setAllocationDate(String allocationDate) {
        this.allocationDate = allocationDate;
    }

    @Override
    public String toString() {
        return "DriverAllocation{" +
                "id=" + id +
                ", driverId=" + driverId +
                ", vehicleId=" + vehicleId +
                ", allocationDate='" + allocationDate + '\'' +
                '}';
    }
}
