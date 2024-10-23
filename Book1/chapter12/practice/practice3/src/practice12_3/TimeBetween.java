package practice12_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.Period;

public class TimeBetween {

    public static void main(String[] args) {
        // Create a formatter to accept date entries using the USA common standard, e.g., "April 8, 1970"
        String dateFormat = "MMMM d, yyyy";
        LocalDate aDate = null;
        boolean validStr = false;

        // Create a formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Loop to ensure a valid date is entered
        while (!validStr) {
            System.out.print("Enter a date (" + dateFormat + "): ");
            try {
                String dateEntered = br.readLine();

                // Use the parse method with the formatter to create a date
                aDate = LocalDate.parse(dateEntered, formatter);
                validStr = true;  // If parsing is successful, exit the loop
            } catch (IOException | DateTimeParseException ex) {
                System.out.println("Invalid date format. Please try again.");
                validStr = false;  // Remain in the loop until a valid date is entered
            }
        }

        // Print the date entered, in the correct format
        System.out.println("Date entered was: " + aDate.format(formatter));

        // Get the current date
        LocalDate now = LocalDate.now();

        // Calculate the years, months, and days between now and the date entered
        Period between;
        if (aDate.isBefore(now)) {
            between = Period.between(aDate, now);
        } else {
            between = Period.between(now, aDate);
        }

        // Print out the difference in years, months, and days
        int years = between.getYears();
        int months = between.getMonths();
        int days = between.getDays();
        System.out.println("There are " + years + " years, "
                + months + " months, "
                + days + " days between now and the date entered.");
    }
}
