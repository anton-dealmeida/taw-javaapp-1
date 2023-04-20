package com.mycompany.datavalidation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DataValidation {

    public static boolean validateEmail(String email) {
        // A basic email validation regex pattern
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }

    public static boolean validatePassword(String password, String confirmPassword) {
        // Check if the password and confirm password match and if the password has at least 8 characters
        return password != null && password.equals(confirmPassword) && password.length() >= 8;
    }

    public static boolean validateDate(String dateString) {
        try {
            // Check if the date is within 150 years of the current date and not after today
            LocalDate currentDate = LocalDate.now();
            LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
            return date.isBefore(currentDate) && date.isAfter(currentDate.minusYears(150));
        } catch (DateTimeParseException e) {
            // Invalid date format
            return false;
        }
    }
}
