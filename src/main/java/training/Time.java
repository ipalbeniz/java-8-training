package training;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.stream.Collectors;

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
        return LocalDate.now();
    }

    public LocalDate getCurrentDatePlus3Days() {
        return LocalDate.now().plusDays(3);
    }

    public int getCurrentYear() {
        return LocalDate.now().getYear();
    }

    public LocalDate getTetrisReleaseDate() {
        return LocalDate.of(1984, Month.JUNE, 6);
    }

    public LocalDate parseIsoDate(final String isoDate) {
        return LocalDate.parse(isoDate);
    }

    public LocalDate getCurrentDateUsingAClock(final Clock clock) {
        return LocalDate.now(clock);
    }

    /*
    LocalTime
     */
    public LocalTime getCurrentTime() {
        return LocalTime.now();
    }

    public LocalTime parseIsoTime(final String isoTime) {
        return LocalTime.parse(isoTime);
    }

    /*
    LocalDateTime
     */
    public LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    public LocalDateTime parseIsoDateTime(final String isoDateTime) {
        return LocalDateTime.parse(isoDateTime);
    }

    public String formatInIsoLocalDateTime(final LocalDateTime localDateTime) {
        return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localDateTime);
    }

    /*
    Before you continue with ZonedDateTime, I encourage you to watch this video: https://www.youtube.com/watch?v=-5wpm-gesOY
     */
    public ZonedDateTime getCurrentZonedDateTimeInSystemTimezone() {
        return ZonedDateTime.now();
    }

    public ZonedDateTime getCurrentZonedDateTimeInUTC() {
        return ZonedDateTime.now(ZoneOffset.UTC);
    }

    public ZonedDateTime getCurrentZonedDateTimeInMoscow() {
        return ZonedDateTime.now(ZoneId.of("Europe/Moscow"));
    }

    public LocalDateTime getCurrentLocalDateTimeInMoscow() {
        return this.getCurrentZonedDateTimeInMoscow().toLocalDateTime();
    }

    public ZonedDateTime convertToZonedDateTimeInNewYork(final ZonedDateTime dateTimeInMoscow) {
        return dateTimeInMoscow.withZoneSameInstant(ZoneId.of("America/New_York"));
    }

    public long getSecondsBetweenTheEpochTimeAndADateTime(final ZonedDateTime dateTime) {
        return dateTime.toEpochSecond();
    }

    public Set<String> getAllTheAvailableZoneIdsFromEurope() {
        return ZoneId.getAvailableZoneIds().stream()
                .filter(zoneId -> zoneId.startsWith("Europe/"))
                .collect(Collectors.toSet());
    }

    /*
    Instant
     */
    public Instant getCurrentInstant() {
        return Instant.now();
    }

    public Instant convertSecondsFromEpochTimeToAnInstant(long secondsFromEpochTime) {
        return Instant.ofEpochSecond(secondsFromEpochTime);
    }

    public ZonedDateTime convertInstantToZonedDateTimeInMoscow(Instant instant) {
        return instant.atZone(ZoneId.of("Europe/Moscow"));
    }

    public long getSecondsBetweenTheEpochTimeAndAnInstant(final Instant instant) {
        return instant.getEpochSecond();
    }

    /*
    Period
     */
    public Period getPeriodOfMonthsAndDays(int months, long days) {
        return Period.ofMonths(months).plusDays(days);
    }

    public int getDaysBetweenTwoLocalDates(final LocalDate firstDate, final LocalDate lastDate) {
        return Period.between(firstDate, lastDate).getDays();
    }

    public LocalDateTime getADateTimePlusSomePeriod(LocalDateTime dateTime, Period periodToAdd) {
        return dateTime.plus(periodToAdd);
    }

    /*
    Duration
     */
    public Duration getDurationOfHoursAndMinutes(long hours, long minutes) {
        return Duration.ofHours(hours).plusMinutes(minutes);
    }

    public long getHoursBetweenTwoLocalDateTimes(final LocalDateTime firstDateTime, final LocalDateTime lastDateTime) {
        return Duration.between(firstDateTime, lastDateTime).toHours();
    }
}
