package com.example.vocationcalculator.controller;

import com.example.vocationcalculator.service.CalculateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculateController {

    public final CalculateService calculateService;
    public CalculateController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @GetMapping
    public String getVocationPay(@RequestParam Double averageSalary, @RequestParam Integer vocationDays) {
        return calculateService.getVocationPay(averageSalary, vocationDays);
    }


}
