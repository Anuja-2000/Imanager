package com.example.Imanager.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "income")
public class Income {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "type")
    private String type;
    
    @Column(name = "start")
    private LocalDateTime start;
    
    @Column(name = "end")
    private LocalDateTime end;
    
    @Column(name = "distance")
    private BigDecimal distance;
    
    @Column(name = "price")
    private BigDecimal price;
    
    @Column(name = "driver_id")
    private Long driverId;
    
    // Default constructor
    public Income() {}
    
    // Constructor with parameters
    public Income(String type, LocalDateTime start, LocalDateTime end, 
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
        return "Income{" +
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
