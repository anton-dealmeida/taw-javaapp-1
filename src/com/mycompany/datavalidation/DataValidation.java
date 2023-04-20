package com.mycompany.datavalidation;

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

    public static boolean validateDate(String date) {
        // Check if the date string is not empty
        return date != null && !date.trim().isEmpty();
    }
}
