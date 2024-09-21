package com.example.vocationcalculator.service.constants;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;

public class PublicHolidays {
    public static final Map<Month, List<Integer>> HOLIDAYS = Map.of(
            Month.JANUARY, List.of(1, 2, 3, 4, 5, 6, 7, 8),
            Month.FEBRUARY, List.of(23),
            Month.MARCH, List.of(8),
            Month.MAY, List.of(1, 9),
            Month.JUNE, List.of(12),
            Month.NOVEMBER, List.of(4));

}
