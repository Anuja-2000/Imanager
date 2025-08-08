package com.example.Imanager.controller;

import com.example.Imanager.dto.IncomeDTO;
import com.example.Imanager.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/incomes")
@CrossOrigin(origins = "*")
public class IncomeController {
    
    @Autowired
    private IncomeService incomeService;
    
    // Create a new income record
    @PostMapping
    public ResponseEntity<IncomeDTO> createIncome(@RequestBody IncomeDTO incomeDTO) {
        IncomeDTO createdIncome = incomeService.createIncome(incomeDTO);
        return new ResponseEntity<>(createdIncome, HttpStatus.CREATED);
    }
    
    // Get all income records
    @GetMapping
    public ResponseEntity<List<IncomeDTO>> getAllIncomes() {
        List<IncomeDTO> incomes = incomeService.getAllIncomes();
        return new ResponseEntity<>(incomes, HttpStatus.OK);
    }
    
    // Get income record by ID
    @GetMapping("/{id}")
    public ResponseEntity<IncomeDTO> getIncomeById(@PathVariable Long id) {
        IncomeDTO income = incomeService.getIncomeById(id);
        return new ResponseEntity<>(income, HttpStatus.OK);
    }
    
    // Update income record
    @PutMapping("/{id}")
    public ResponseEntity<IncomeDTO> updateIncome(@PathVariable Long id, @RequestBody IncomeDTO incomeDTO) {
        IncomeDTO updatedIncome = incomeService.updateIncome(id, incomeDTO);
        return new ResponseEntity<>(updatedIncome, HttpStatus.OK);
    }
    
    // Delete income record
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncome(@PathVariable Long id) {
        incomeService.deleteIncome(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    // Get income records by driver ID
    @GetMapping("/driver/{driverId}")
    public ResponseEntity<List<IncomeDTO>> getIncomeByDriverId(@PathVariable Long driverId) {
        List<IncomeDTO> incomes = incomeService.getIncomeByDriverId(driverId);
        return new ResponseEntity<>(incomes, HttpStatus.OK);
    }
    
    // Get income records by type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<IncomeDTO>> getIncomeByType(@PathVariable String type) {
        List<IncomeDTO> incomes = incomeService.getIncomeByType(type);
        return new ResponseEntity<>(incomes, HttpStatus.OK);
    }
    
    // Get income records by date range
    @GetMapping("/date-range")
    public ResponseEntity<List<IncomeDTO>> getIncomeByDateRange(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        LocalDateTime start = LocalDateTime.parse(startDate);
        LocalDateTime end = LocalDateTime.parse(endDate);
        List<IncomeDTO> incomes = incomeService.getIncomeByDateRange(start, end);
        return new ResponseEntity<>(incomes, HttpStatus.OK);
    }
    
    // Get total income by driver ID
    @GetMapping("/total/driver/{driverId}")
    public ResponseEntity<BigDecimal> getTotalIncomeByDriverId(@PathVariable Long driverId) {
        BigDecimal totalIncome = incomeService.getTotalIncomeByDriverId(driverId);
        return new ResponseEntity<>(totalIncome, HttpStatus.OK);
    }
    
    // Get average income per trip
    @GetMapping("/average")
    public ResponseEntity<BigDecimal> getAverageIncomePerTrip() {
        BigDecimal averageIncome = incomeService.getAverageIncomePerTrip();
        return new ResponseEntity<>(averageIncome, HttpStatus.OK);
    }
}
