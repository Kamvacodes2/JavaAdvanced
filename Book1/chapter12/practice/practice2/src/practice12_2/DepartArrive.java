package practice12_2;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class DepartArrive {

    public static void main(String[] args) {
        // Time zones for the airports
        ZoneId bostonZone = ZoneId.of("America/New_York");
        ZoneId sanFranciscoZone = ZoneId.of("America/Los_Angeles");
        ZoneId bangaloreZone = ZoneId.of("Asia/Calcutta");

        // Flight 123, San Francisco to Boston
        LocalDateTime departureSF = LocalDateTime.of(2014, 6, 13, 22, 30);
        ZonedDateTime departureSFO = departureSF.atZone(sanFranciscoZone);
        Duration flightDurationSFtoBoston = Duration.ofHours(5).plusMinutes(30);

        // What is the local time in Boston when the flight takes off?
        ZonedDateTime departureInBostonTime = departureSFO.withZoneSameInstant(bostonZone);
        System.out.println("Flight 123 takes off at " + departureInBostonTime + " Boston time.");

        // What is the local time at Boston Logan airport when the flight arrives?
        ZonedDateTime arrivalBoston = departureSFO.plus(flightDurationSFtoBoston).withZoneSameInstant(bostonZone);
        System.out.println("Flight 123 arrives at " + arrivalBoston + " Boston time.");

        // What is the local time in San Francisco when the flight arrives?
        ZonedDateTime arrivalSFTime = arrivalBoston.withZoneSameInstant(sanFranciscoZone);
        System.out.println("Flight 123 arrives at " + arrivalSFTime + " San Francisco time.");


        // Flight 456, San Francisco to Bangalore, India
        LocalDateTime departureSFtoBLR = LocalDateTime.of(2014, 6, 28, 22, 30);  // Saturday
        ZonedDateTime departureSFOtoBLR = departureSFtoBLR.atZone(sanFranciscoZone);
        Duration flightDurationSFtoBLR = Duration.ofHours(22);

        // Will the traveler make a meeting in Bangalore Monday at 9 AM local time?
        ZonedDateTime arrivalBLR = departureSFOtoBLR.plus(flightDurationSFtoBLR).withZoneSameInstant(bangaloreZone);
        System.out.println("Flight 456 arrives at " + arrivalBLR + " Bangalore time.");
        ZonedDateTime meetingTime = LocalDateTime.of(2014, 6, 30, 9, 0).atZone(bangaloreZone);  // Monday, 9 AM
        boolean canMakeMeeting = !arrivalBLR.isAfter(meetingTime);
        System.out.println("Will the traveler make the Monday 9 AM meeting? " + canMakeMeeting);

        // Can the traveler call her husband at a reasonable time when she arrives?
        ZonedDateTime reasonableTimeForCall = arrivalBLR.withZoneSameInstant(sanFranciscoZone);
        System.out.println("Traveler arrives at " + reasonableTimeForCall + " in San Francisco.");
        boolean reasonableTimeToCall = reasonableTimeForCall.getHour() >= 7 && reasonableTimeForCall.getHour() <= 21;
        System.out.println("Is it a reasonable time to call home? " + reasonableTimeToCall);


        // Flight 123, San Francisco to Boston, leaves SFO at 10:30 PM Saturday, November 1st, 2014
        LocalDateTime novemberDeparture = LocalDateTime.of(2014, 11, 1, 22, 30);
        ZonedDateTime novemberDepartureSFO = novemberDeparture.atZone(sanFranciscoZone);
        Duration novemberFlightDuration = Duration.ofHours(5).plusMinutes(30);

        // What day and time does the flight arrive in Boston?
        ZonedDateTime novemberArrivalBoston = novemberDepartureSFO.plus(novemberFlightDuration).withZoneSameInstant(bostonZone);
        System.out.println("Flight 123 arrives at " + novemberArrivalBoston + " Boston time.");

        // What happened?
        System.out.println("The flight crosses into Daylight Savings Time. Boston switches from EDT to EST, gaining an extra hour.");
    }
}
