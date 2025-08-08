package com.example.Imanager.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class IncomeDTO {
    
    private Long id;
    private String type;
    private LocalDateTime start;
    private LocalDateTime end;
    private BigDecimal distance;
    private BigDecimal price;
    private Long driverId;
    
    // Default constructor
    public IncomeDTO() {}
    
    // Constructor with all fields
    public IncomeDTO(Long id, String type, LocalDateTime start, LocalDateTime end, 
                     BigDecimal distance, BigDecimal price, Long driverId) {
        this.id = id;
        this.type = type;
        this.start = start;
        this.end = end;
        this.distance = distance;
        this.price = price;
        this.driverId = driverId;
    }
    
    // Constructor without id (for creating new records)
    public IncomeDTO(String type, LocalDateTime start, LocalDateTime end, 
                     BigDecimal distance, BigDecimal price, Long driverId) {
        this.type = type;
        this.start = start;
        this.end = end;
        this.distance = distance;
        this.price = price;
        this.driverId = driverId;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public LocalDateTime getStart() {
        return start;
    }
    
    public void setStart(LocalDateTime start) {
        this.start = start;
    }
    
    public LocalDateTime getEnd() {
        return end;
    }
    
    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
    
    public BigDecimal getDistance() {
        return distance;
    }
    
    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }
    
    public BigDecimal getPrice() {
        return price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public Long getDriverId() {
        return driverId;
    }
    
    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }
    
    @Override
    public String toString() {
        return "IncomeDTO{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", distance=" + distance +
                ", price=" + price +
                ", driverId=" + driverId +
                '}';
    }
}
