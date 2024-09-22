package com.example.vocationcalculator.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceImplTest {
    private CalculateServiceImpl calculateService;
    @BeforeEach
    void setUp() {
        calculateService = new CalculateServiceImpl();
    }

    @Test
    void testGetVocationPay() {
        double averageSalary = 60000.0;
        int vocationDays = 10;

        Double expectedPay = averageSalary / 29.3 * vocationDays;
        Double actualPay = calculateService.getVocationPay(averageSalary, vocationDays);

        assertEquals(expectedPay, actualPay);
    }
    @Test
    void testGetVocationPayNegative() {
        double averageSalary = 60000.0;
        int vocationDays = 10;

        Double expectedPay = 60000.0;
        Double actualPay = calculateService.getVocationPay(averageSalary, vocationDays);

        assertNotEquals(expectedPay, actualPay);
    }

    @Test
    void testGetVacationPayWithHolidays() {
        Double averageSalary = 60000.0;
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 1, 20);

        Integer expectedWorkingDays = 9;

        Double expectedVacationPay = calculateService.getVocationPay(averageSalary, expectedWorkingDays);

        Double actualPay = calculateService.getVacationPayWithHolidays(averageSalary, startDate, endDate);

        assertEquals(expectedVacationPay, actualPay);
    }

    @Test
    void testGetVacationPayWithHolidaysNegative() {
        Double averageSalary = 60000.0;
        LocalDate startDate = LocalDate.of(2024, 1, 3);
        LocalDate endDate = LocalDate.of(2024, 1, 12);

        Integer expectedWorkingDays = 3;

        Double expectedVacationPay = calculateService.getVocationPay(averageSalary, expectedWorkingDays);

        Double actualPay = calculateService.getVacationPayWithHolidays(averageSalary, startDate, endDate);

        assertNotEquals(expectedVacationPay, actualPay);
    }

}