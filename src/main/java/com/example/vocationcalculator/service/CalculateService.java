package com.example.vocationcalculator.service;

import java.time.LocalDate;

public interface CalculateService {
    Double getVocationPay(Double averageSalary, Integer vocationDays);

    Double getVacationPayWithHolidays(Double averageSalary, LocalDate startDate, LocalDate endDate);
}
