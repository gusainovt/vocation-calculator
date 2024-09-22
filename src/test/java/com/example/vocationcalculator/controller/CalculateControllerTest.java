package com.example.vocationcalculator.controller;

import com.example.vocationcalculator.service.CalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CalculateController.class)
@AutoConfigureMockMvc
class CalculateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculateService calculateService;
    @Test
    void getVocationPay() throws Exception {
            Double averageSalary = 60000.0;
            Integer vocationDays = 10;
            Double expectedPay = 2040.0;
            when(calculateService.getVocationPay(anyDouble(), anyInt())).thenReturn(expectedPay);
            mockMvc.perform(MockMvcRequestBuilders.get("/calculate")
                            .param("averageSalary", String.valueOf(averageSalary))
                            .param("vocationDays", String.valueOf(vocationDays)))
                    .andExpect(status().isOk())
                    .andExpect(content().string(String.valueOf(expectedPay)));
        }

    @Test
    void testGetVocationPayWithHolidays() throws Exception {
        Double averageSalary = 60000.0;
        Integer vocationDays = 0;
        LocalDate startDate = LocalDate.of(2024, 6, 1);
        LocalDate endDate = LocalDate.of(2024, 6, 10);
        Double expectedPay = 1800.0;

        when(calculateService.getVacationPayWithHolidays(anyDouble(), eq(startDate), eq(endDate))).thenReturn(expectedPay);

        mockMvc.perform(MockMvcRequestBuilders.get("/calculate")
                        .param("averageSalary", String.valueOf(averageSalary))
                        .param("vocationDays", String.valueOf(vocationDays))
                        .param("startDate", startDate.toString())
                        .param("endDate", endDate.toString()))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(expectedPay)));
    }

    }
