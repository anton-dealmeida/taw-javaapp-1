import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class DataValidation {

    public static boolean validateEmail(String email) {
        // Use regular expression to validate email format
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        return emailPattern.matcher(email).find();
    }

    public static boolean validatePassword(String password, String confirmPassword) {
        // Compare password and confirm password fields and check if password has at least 8 characters
        return password.equals(confirmPassword) && password.length() >= 8;
    }

    public static boolean validateDate(String dateString) {
        try {
            // Check if date is within 70 years of the current date
            LocalDate currentDate = LocalDate.now();
            LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
            return date.isBefore(currentDate) && date.isAfter(currentDate.minusYears(70));
        } catch (DateTimeParseException e) {
            // Invalid date format
            return false;
        }
    }

    public static void main(String[] args) {
        // Example usage:
        String email = "test@example.com";
        String password = "password";
        String confirmPassword = "password";
        String date = "2000-01-01";
        boolean keepSignedIn = true;

        // Validate email, password, confirm password, and date
        boolean isValidEmail = validateEmail(email);
        boolean isValidPassword = validatePassword(password, confirmPassword);
        boolean isValidDate = validateDate(date);

        // Check if all fields are valid
        if (isValidEmail && isValidPassword && isValidDate) {
            System.out.println("All fields are valid.");
            // Check if "Keep me signed in" checkbox is selected
            if (keepSignedIn) {
                System.out.println("User selected 'Keep me signed in'.");
            }
        } else {
            System.out.println("One or more fields are invalid.");
        }
    }
}
