package com.example.Imanager.repository;

import com.example.Imanager.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
    
    // Find income records by driver ID
    List<Income> findByDriverId(Long driverId);
    
    // Find income records by type
    List<Income> findByType(String type);
    
    // Find income records within a date range
    @Query("SELECT i FROM Income i WHERE i.start >= :startDate AND i.end <= :endDate")
    List<Income> findByDateRange(@Param("startDate") LocalDateTime startDate, 
                                @Param("endDate") LocalDateTime endDate);
    
    // Find income records by driver and date range
    @Query("SELECT i FROM Income i WHERE i.driverId = :driverId AND i.start >= :startDate AND i.end <= :endDate")
    List<Income> findByDriverIdAndDateRange(@Param("driverId") Long driverId,
                                           @Param("startDate") LocalDateTime startDate,
                                           @Param("endDate") LocalDateTime endDate);
    
    // Find income records with price greater than specified amount
    List<Income> findByPriceGreaterThan(BigDecimal price);
    
    // Find income records with distance greater than specified amount
    List<Income> findByDistanceGreaterThan(BigDecimal distance);
    
    // Get total income for a driver
    @Query("SELECT SUM(i.price) FROM Income i WHERE i.driverId = :driverId")
    BigDecimal getTotalIncomeByDriverId(@Param("driverId") Long driverId);
    
    // Get average income per trip
    @Query("SELECT AVG(i.price) FROM Income i")
    BigDecimal getAverageIncomePerTrip();
}
