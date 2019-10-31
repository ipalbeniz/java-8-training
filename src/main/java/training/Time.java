package training;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * Welcome to the time api training
 * <p>
 * Please, implement all the methods and pass all the tests
 * <p>
 * More info in spanish: https://blog.eddumelendez.me/2016/07/conociendo-la-nueva-date-api-en-java-8-parte-i/
 * More info in english: https://www.baeldung.com/java-8-date-time-intro
 */
public class Time {

    /*
    LocalDate
     */
    public LocalDate getCurrentDate() {
        // TODO
        return null;
    }

    public LocalDate getCurrentDatePlus3Days() {
        // TODO
        return null;
    }

    public int getCurrentYear() {
        // TODO
        return 0;
    }

    public LocalDate getTetrisReleaseDate() {
        // TODO
        return null;
    }

    public LocalDate parseIsoDate(final String isoDate) {
        // TODO
        return null;
    }

    public LocalDate getCurrentDateUsingAClock(final Clock clock) {
        // TODO
        return null;
    }

    /*
    LocalTime
     */
    public LocalTime getCurrentTime() {
        // TODO
        return null;
    }

    public LocalTime parseIsoTime(final String isoTime) {
        // TODO
        return null;
    }

    /*
    LocalDateTime
     */
    public LocalDateTime getCurrentDateTime() {
        // TODO
        return null;
    }

    public LocalDateTime parseIsoDateTime(final String isoDateTime) {
        // TODO
        return null;
    }

    public String formatInIsoLocalDateTime(final LocalDateTime localDateTime) {
        // TODO
        return null;
    }

    /*
    Before you continue with ZonedDateTime, I encourage you to watch this video: https://www.youtube.com/watch?v=-5wpm-gesOY
     */
    public ZonedDateTime getCurrentZonedDateTimeInSystemTimezone() {
        // TODO
        return null;
    }

    public ZonedDateTime getCurrentZonedDateTimeInUTC() {
        // TODO
        return null;
    }

    public ZonedDateTime getCurrentZonedDateTimeInMoscow() {
        // TODO
        return null;
    }

    public LocalDateTime getCurrentLocalDateTimeInMoscow() {
        // TODO
        return null;
    }

    public ZonedDateTime convertToZonedDateTimeInNewYork(final ZonedDateTime dateTimeInMoscow) {
        // TODO
        return null;
    }

    public long getSecondsBetweenTheEpochTimeAndADateTime(final ZonedDateTime dateTime) {
        // TODO
        return 0;
    }

    public Set<String> getAllTheAvailableZoneIdsFromEurope() {
        // TODO
        return null;
    }

    /*
    Instant
     */
    public Instant getCurrentInstant() {
        // TODO
        return null;
    }

    public Instant convertSecondsFromEpochTimeToAnInstant(final long secondsFromEpochTime) {
        // TODO
        return null;
    }

    public ZonedDateTime convertInstantToZonedDateTimeInMoscow(final Instant instant) {
        // TODO
        return null;
    }

    public long getSecondsBetweenTheEpochTimeAndAnInstant(final Instant instant) {
        // TODO
        return 0;
    }

    /*
    Period
     */
    public Period getPeriodOfMonthsAndDays(final int months, final long days) {
        // TODO
        return null;
    }

    public int getDaysBetweenTwoLocalDates(final LocalDate firstDate, final LocalDate lastDate) {
        // TODO
        return 0;
    }

    public LocalDateTime getADateTimePlusSomePeriod(final LocalDateTime dateTime, final Period periodToAdd) {
        // TODO
        return null;
    }

    /*
    Duration
     */
    public Duration getDurationOfHoursAndMinutes(final long hours, final long minutes) {
        // TODO
        return null;
    }

    public long getHoursBetweenTwoLocalDateTimes(final LocalDateTime firstDateTime, final LocalDateTime lastDateTime) {
        // TODO
        return 0;
    }
}
