package com.example.vocationcalculator.service.impl;

import com.example.vocationcalculator.service.CalculateService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.example.vocationcalculator.service.constants.PublicHolidays.HOLIDAYS;

@Service
public class CalculateServiceImpl implements CalculateService {
    @Override
    public Double getVocationPay(Double averageSalary, Integer vocationDays) {
        return averageSalary / 29.3 * vocationDays;
    }
    @Override
    public Double getVacationPayWithHolidays(Double averageSalary, LocalDate startDate, LocalDate endDate) {
        Integer workingDays = calculateWorkingDays(startDate, endDate);
        return getVocationPay(averageSalary, workingDays);
    }

    private Integer calculateWorkingDays(LocalDate startDate, LocalDate endDate) {
        Integer workingDays = 0;
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            if (!(date.getDayOfWeek().getValue() == 6 || date.getDayOfWeek().getValue() == 7 ||
                    (HOLIDAYS.containsKey(date.getMonth())&& HOLIDAYS.get(date.getMonth()).contains(date.getDayOfMonth())))) {
                workingDays++;
            }
        }
        return workingDays;
    }
}
