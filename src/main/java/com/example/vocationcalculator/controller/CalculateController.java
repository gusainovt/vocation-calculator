package com.example.vocationcalculator.controller;

import com.example.vocationcalculator.service.CalculateService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/calculate")
public class CalculateController {

    public final CalculateService calculateService;
    public CalculateController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @GetMapping
    public ResponseEntity<Double> getVocationPay(@RequestParam Double averageSalary,
                                                 @RequestParam Integer vocationDays,
                                                 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        if (startDate != null && endDate != null) {
            return ResponseEntity.ok(calculateService.getVacationPayWithHolidays(averageSalary, startDate, endDate));
        }
        return ResponseEntity.ok(calculateService.getVocationPay(averageSalary, vocationDays));
    }
}
