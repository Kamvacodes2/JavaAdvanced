package practice12_1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Duration;
import java.time.Period;
import static java.time.Month.*;  // Months
import static java.time.DayOfWeek.*; // Days of the week
import static java.time.temporal.ChronoUnit.*;  // DAYS, HOURS, etc
import java.time.temporal.TemporalAdjusters;

public class LocalDatesAndTimes {

        public static void main(String[] args) {
            // Abe Lincoln's Birthday: February 12, 1809, died April 15, 1855
            LocalDate birthAbe = LocalDate.of(1809, FEBRUARY, 12);
            LocalDate deathAbe = LocalDate.of(1855, APRIL, 15);

            // How old when he died?
            Period ageAbe = Period.between(birthAbe, deathAbe);
            System.out.println("Abe Lincoln was " + ageAbe.getYears() + " years and " + ageAbe.getMonths() + " months old when he died.");

            // How many days did he live?
            long daysAbeLived = DAYS.between(birthAbe, deathAbe);
            System.out.println("Abe Lincoln lived for " + daysAbeLived + " days.");


            // Benedict Cumberbatch: July 19, 1976
            LocalDate birthBenedict = LocalDate.of(1976, JULY, 19);

            // Born in a leap year?
            boolean leapYear = birthBenedict.isLeapYear();
            System.out.println("Benedict born in a leap year: " + leapYear);

            // How many days in the year he was born?
            int daysInYear = birthBenedict.lengthOfYear();
            System.out.println("Days in the year he was born: " + daysInYear);

            // How many decades old is he?
            LocalDate today = LocalDate.now();
            long decadesOld = YEARS.between(birthBenedict, today) / 10;
            System.out.println("Benedict is " + decadesOld + " decades old.");

            // What was the day of the week on his 21st birthday?
            LocalDate birthday21 = birthBenedict.plusYears(21);
            System.out.println("Benedict's 21st birthday was on a " + birthday21.getDayOfWeek());


            // Train departs Boston at 1:45 PM and arrives New York 7:25 PM
            LocalTime departTrain = LocalTime.of(13, 45);
            LocalTime arriveTrain = LocalTime.of(19, 25);

            // How many minutes long is the train ride?
            long trainRideMinutes = MINUTES.between(departTrain, arriveTrain);
            System.out.println("The train ride is " + trainRideMinutes + " minutes long.");

            // If the train was delayed 1 hour 19 minutes, what is the actual arrival time?
            LocalTime delayedArrival = arriveTrain.plusHours(1).plusMinutes(19);
            System.out.println("The actual arrival time is " + delayedArrival);


            // Flight: Boston to Miami, leaves March 24th 9:15PM. Flight time is 4 hours 15 minutes
            LocalDateTime flightDepart = LocalDateTime.of(2024, MARCH, 24, 21, 15);
            LocalDateTime flightArrival = flightDepart.plusHours(4).plusMinutes(15);
            System.out.println("Flight arrives in Miami at " + flightArrival);

            // When does it arrive if the flight is delayed 4 hours 27 minutes?
            LocalDateTime delayedFlightArrival = flightArrival.plusHours(4).plusMinutes(27);
            System.out.println("Delayed flight arrives in Miami at " + delayedFlightArrival);


            // School semester starts the second Tuesday of September of this year
            LocalDate semesterStart = LocalDate.of(today.getYear(), SEPTEMBER, 1)
                    .with(TemporalAdjusters.dayOfWeekInMonth(2, TUESDAY));
            System.out.println("School semester starts on: " + semesterStart);

            // School summer vacation starts June 25th
            LocalDate vacationStart = LocalDate.of(today.getYear(), JUNE, 25);

            // Assuming 2 weeks off in December and 2 other vacation weeks
            LocalDate winterBreakStart = LocalDate.of(today.getYear(), DECEMBER, 22); // Approximation
            LocalDate winterBreakEnd = winterBreakStart.plusWeeks(2);

            long totalSchoolDays = 0;
            LocalDate current = semesterStart;
            while (current.isBefore(vacationStart)) {
                if (current.getDayOfWeek() != SATURDAY && current.getDayOfWeek() != SUNDAY &&
                        !(current.isAfter(winterBreakStart) && current.isBefore(winterBreakEnd))) {
                    totalSchoolDays++;
                }
                current = current.plusDays(1);
            }
            System.out.println("Total number of school days: " + totalSchoolDays);


            // A meeting is scheduled for 1:30 PM next Tuesday. If today is Tuesday, assume it is today.
            LocalDateTime meeting = LocalDateTime.now().with(TemporalAdjusters.nextOrSame(TUESDAY)).with(LocalTime.of(13, 30));
            System.out.println("The next meeting is scheduled for: " + meeting);

        }
}
