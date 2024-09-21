package com.example.vocationcalculator.service.impl;

import com.example.vocationcalculator.service.CalculateService;
import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService {
    @Override
    public String getVocationPay(Double averageSalary, Integer vocationDays) {
        return String.valueOf(averageSalary / 29.3 * vocationDays);
    }
}
