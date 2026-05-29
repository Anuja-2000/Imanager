package com.example.Imanager.dto;

import com.example.Imanager.entity.Trip;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class TripDTO {
    
    private int id;
    private String startTime;
    private String endTime;
    private Double distance;
    private String type;
    private Double amount;
    private String duration;
    private String amountType;
    private String date;
    private int driverId;
    private int vehicleId;


    public TripDTO(Trip trip) {
        this.id = trip.getId();
        this.startTime = trip.getStartTime();
        this.endTime = trip.getEndTime();
        this.distance = trip.getDistance();
        this.type = trip.getType();
        this.amount = trip.getAmount();
        this.duration = trip.getDuration();
        this.amountType = trip.getAmountType();
        this.date = trip.getDate();
        this.driverId = trip.getDriverId();
        this.vehicleId = trip.getVehicleId();

    }
    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAmountType() {
        return amountType;
    }

    public void setAmountType(String amountType) {
        this.amountType = amountType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public Trip getEntity() {
        Trip trip = new Trip();
        trip.setId(this.id);
        trip.setStartTime(this.startTime);
        trip.setEndTime(this.endTime);
        trip.setDistance(this.distance);
        trip.setType(this.type);
        trip.setAmount(this.amount);
        trip.setDuration(this.duration);
        trip.setAmountType(this.amountType);
        trip.setDate(this.date);
        trip.setDriverId(this.driverId);
        trip.setVehicleId(this.vehicleId);
        return trip;
    }

}
