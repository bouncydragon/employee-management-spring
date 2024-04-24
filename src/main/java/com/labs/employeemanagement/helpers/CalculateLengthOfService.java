package com.labs.employeemanagement.helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class CalculateLengthOfService {
    public static Double calculateServiceComputation(LocalDate date) {
        String dateToString = date.toString();
        LocalDate parseDate = LocalDate.parse(dateToString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Calculate the length of service in months
        long monthsBetween = ChronoUnit.MONTHS.between(parseDate, currentDate);

        // Calculate the length of service in years with decimal points
        return Math.round(monthsBetween / 12.0 * 10) / 10.0;
    }
}
