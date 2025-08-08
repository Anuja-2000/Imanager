package com.example.Imanager.service;

import com.example.Imanager.dao.IncomeDAO;
import com.example.Imanager.dto.IncomeDTO;
import com.example.Imanager.entity.Income;
import com.example.Imanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncomeService {
    
    @Autowired
    private IncomeDAO incomeDAO;
    
    // Create new income record
    public IncomeDTO createIncome(IncomeDTO incomeDTO) {
        Income income = convertToEntity(incomeDTO);
        Income savedIncome = incomeDAO.save(income);
        return convertToDTO(savedIncome);
    }
    
    // Get income by ID
    public IncomeDTO getIncomeById(Long id) {
        Income income = incomeDAO.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Income record not found with id: " + id));
        return convertToDTO(income);
    }
    
    // Get all income records
    public List<IncomeDTO> getAllIncomes() {
        List<Income> incomes = incomeDAO.findAll();
        return incomes.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    // Update income record
    public IncomeDTO updateIncome(Long id, IncomeDTO incomeDTO) {
        Income existingIncome = incomeDAO.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Income record not found with id: " + id));
        
        // Update fields
        existingIncome.setType(incomeDTO.getType());
        existingIncome.setStart(incomeDTO.getStart());
        existingIncome.setEnd(incomeDTO.getEnd());
        existingIncome.setDistance(incomeDTO.getDistance());
        existingIncome.setPrice(incomeDTO.getPrice());
        existingIncome.setDriverId(incomeDTO.getDriverId());
        
        Income updatedIncome = incomeDAO.save(existingIncome);
        return convertToDTO(updatedIncome);
    }
    
    // Delete income record
    public void deleteIncome(Long id) {
        if (!incomeDAO.existsById(id)) {
            throw new ResourceNotFoundException("Income record not found with id: " + id);
        }
        incomeDAO.deleteById(id);
    }
    
    // Get income records by driver ID
    public List<IncomeDTO> getIncomeByDriverId(Long driverId) {
        List<Income> incomes = incomeDAO.findByDriverId(driverId);
        return incomes.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    // Get income records by type
    public List<IncomeDTO> getIncomeByType(String type) {
        List<Income> incomes = incomeDAO.findByType(type);
        return incomes.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    // Get income records by date range
    public List<IncomeDTO> getIncomeByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        List<Income> incomes = incomeDAO.findByDateRange(startDate, endDate);
        return incomes.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    // Get total income by driver ID
    public BigDecimal getTotalIncomeByDriverId(Long driverId) {
        return incomeDAO.getTotalIncomeByDriverId(driverId);
    }
    
    // Get average income per trip
    public BigDecimal getAverageIncomePerTrip() {
        return incomeDAO.getAverageIncomePerTrip();
    }
    
    // Convert Entity to DTO
    private IncomeDTO convertToDTO(Income income) {
        return new IncomeDTO(
                income.getId(),
                income.getType(),
                income.getStart(),
                income.getEnd(),
                income.getDistance(),
                income.getPrice(),
                income.getDriverId()
        );
    }
    
    // Convert DTO to Entity
    private Income convertToEntity(IncomeDTO incomeDTO) {
        Income income = new Income();
        income.setId(incomeDTO.getId());
        income.setType(incomeDTO.getType());
        income.setStart(incomeDTO.getStart());
        income.setEnd(incomeDTO.getEnd());
        income.setDistance(incomeDTO.getDistance());
        income.setPrice(incomeDTO.getPrice());
        income.setDriverId(incomeDTO.getDriverId());
        return income;
    }
}
