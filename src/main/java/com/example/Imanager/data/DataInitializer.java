package com.example.Imanager.data;

import com.example.Imanager.entity.Income;
import com.example.Imanager.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private IncomeRepository incomeRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Only initialize data if table is empty
        if (incomeRepository.count() == 0) {
            initializeSampleData();
        }
    }
    
    private void initializeSampleData() {
        // Sample income record 1
        Income income1 = new Income();
        income1.setType("Trip");
        income1.setStart(LocalDateTime.now().minusHours(2));
        income1.setEnd(LocalDateTime.now().minusHours(1));
        income1.setDistance(new BigDecimal("15.5"));
        income1.setPrice(new BigDecimal("25.80"));
        income1.setDriverId(1L);
        
        // Sample income record 2
        Income income2 = new Income();
        income2.setType("Delivery");
        income2.setStart(LocalDateTime.now().minusHours(4));
        income2.setEnd(LocalDateTime.now().minusHours(3));
        income2.setDistance(new BigDecimal("8.2"));
        income2.setPrice(new BigDecimal("18.50"));
        income2.setDriverId(1L);
        
        // Sample income record 3
        Income income3 = new Income();
        income3.setType("Trip");
        income3.setStart(LocalDateTime.now().minusHours(6));
        income3.setEnd(LocalDateTime.now().minusHours(5));
        income3.setDistance(new BigDecimal("22.1"));
        income3.setPrice(new BigDecimal("35.75"));
        income3.setDriverId(2L);
        
        // Save sample data
        //incomeRepository.save(income1);
        //incomeRepository.save(income2);
        //incomeRepository.save(income3);
        
        System.out.println("Sample income data initialized successfully!");
    }
}
