package com.example.Imanager.dao;

import com.example.Imanager.entity.Income;
import com.example.Imanager.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class IncomeDAO {
    
    @Autowired
    private IncomeRepository incomeRepository;
    
    // Create or update income record
    public Income save(Income income) {
        return incomeRepository.save(income);
    }
    
    // Find income by ID
    public Optional<Income> findById(Long id) {
        return incomeRepository.findById(id);
    }
    
    // Find all income records
    public List<Income> findAll() {
        return incomeRepository.findAll();
    }
    
    // Delete income by ID
    public void deleteById(Long id) {
        incomeRepository.deleteById(id);
    }
    
    // Delete income record
    public void delete(Income income) {
        incomeRepository.delete(income);
    }
    
    // Check if income record exists
    public boolean existsById(Long id) {
        return incomeRepository.existsById(id);
    }
    
    // Count total income records
    public long count() {
        return incomeRepository.count();
    }
    
    // Custom query methods
    public List<Income> findByDriverId(Long driverId) {
        return incomeRepository.findByDriverId(driverId);
    }
    
    public List<Income> findByType(String type) {
        return incomeRepository.findByType(type);
    }
    
    public List<Income> findByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return incomeRepository.findByDateRange(startDate, endDate);
    }
    
    public List<Income> findByDriverIdAndDateRange(Long driverId, LocalDateTime startDate, LocalDateTime endDate) {
        return incomeRepository.findByDriverIdAndDateRange(driverId, startDate, endDate);
    }
    
    public List<Income> findByPriceGreaterThan(BigDecimal price) {
        return incomeRepository.findByPriceGreaterThan(price);
    }
    
    public List<Income> findByDistanceGreaterThan(BigDecimal distance) {
        return incomeRepository.findByDistanceGreaterThan(distance);
    }
    
    public BigDecimal getTotalIncomeByDriverId(Long driverId) {
        return incomeRepository.getTotalIncomeByDriverId(driverId);
    }
    
    public BigDecimal getAverageIncomePerTrip() {
        return incomeRepository.getAverageIncomePerTrip();
    }
}
