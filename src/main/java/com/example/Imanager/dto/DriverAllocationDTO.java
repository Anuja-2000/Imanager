package com.example.Imanager.dto;

public class DriverAllocationDTO {
    
    private int id;
    private int driverId;
    private int vehicleId;
    private String allocationDate;

    // Default constructor
    public DriverAllocationDTO() {}

    // Constructor with all fields
    public DriverAllocationDTO(int id, int driverId, int vehicleId, String allocationDate) {
        this.id = id;
        this.driverId = driverId;
        this.vehicleId = vehicleId;
        this.allocationDate = allocationDate;
    }

    // Constructor without id (for creating new records)
    public DriverAllocationDTO(int driverId, int vehicleId, String allocationDate) {
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
        return "DriverAllocationDTO{" +
                "id=" + id +
                ", driverId=" + driverId +
                ", vehicleId=" + vehicleId +
                ", allocationDate='" + allocationDate + '\'' +
                '}';
    }
}
