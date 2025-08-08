package com.example.Imanager.controller;

import com.example.Imanager.dto.IncomeDTO;
import com.example.Imanager.service.IncomeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(IncomeController.class)
public class IncomeControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockitoBean
    private IncomeService incomeService;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    public void testGetAllIncomes() throws Exception {
        // Given
        IncomeDTO income1 = new IncomeDTO(1L, "Trip", LocalDateTime.now(), LocalDateTime.now(), 
                new BigDecimal("15.5"), new BigDecimal("25.80"), 1L);
        IncomeDTO income2 = new IncomeDTO(2L, "Delivery", LocalDateTime.now(), LocalDateTime.now(), 
                new BigDecimal("8.2"), new BigDecimal("18.50"), 1L);
        List<IncomeDTO> incomes = Arrays.asList(income1, income2);
        
        when(incomeService.getAllIncomes()).thenReturn(incomes);
        
        // When & Then
        mockMvc.perform(get("/api/incomes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].type").value("Trip"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].type").value("Delivery"));
    }
    
    @Test
    public void testGetIncomeById() throws Exception {
        // Given
        IncomeDTO income = new IncomeDTO(1L, "Trip", LocalDateTime.now(), LocalDateTime.now(), 
                new BigDecimal("15.5"), new BigDecimal("25.80"), 1L);
        
        when(incomeService.getIncomeById(1L)).thenReturn(income);
        
        // When & Then
        mockMvc.perform(get("/api/incomes/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.type").value("Trip"));
    }
    
    @Test
    public void testCreateIncome() throws Exception {
        // Given
        IncomeDTO incomeDTO = new IncomeDTO("Trip", LocalDateTime.now(), LocalDateTime.now(), 
                new BigDecimal("15.5"), new BigDecimal("25.80"), 1L);
        IncomeDTO savedIncomeDTO = new IncomeDTO(1L, "Trip", LocalDateTime.now(), LocalDateTime.now(), 
                new BigDecimal("15.5"), new BigDecimal("25.80"), 1L);
        
        when(incomeService.createIncome(any(IncomeDTO.class))).thenReturn(savedIncomeDTO);
        
        // When & Then
        mockMvc.perform(post("/api/incomes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(incomeDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.type").value("Trip"));
    }
    
    @Test
    public void testUpdateIncome() throws Exception {
        // Given
        IncomeDTO incomeDTO = new IncomeDTO("Updated Trip", LocalDateTime.now(), LocalDateTime.now(), 
                new BigDecimal("20.0"), new BigDecimal("30.00"), 1L);
        IncomeDTO updatedIncomeDTO = new IncomeDTO(1L, "Updated Trip", LocalDateTime.now(), LocalDateTime.now(), 
                new BigDecimal("20.0"), new BigDecimal("30.00"), 1L);
        
        when(incomeService.updateIncome(anyLong(), any(IncomeDTO.class))).thenReturn(updatedIncomeDTO);
        
        // When & Then
        mockMvc.perform(put("/api/incomes/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(incomeDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.type").value("Updated Trip"));
    }
    
    @Test
    public void testDeleteIncome() throws Exception {
        // When & Then
        mockMvc.perform(delete("/api/incomes/1"))
                .andExpect(status().isNoContent());
    }
}
