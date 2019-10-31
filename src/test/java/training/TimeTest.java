package training;

import org.junit.Before;
import org.junit.Test;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import static java.time.temporal.ChronoUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class TimeTest {

    private static final String MOSCOW_TIMEZONE = "Europe/Moscow";

    private Time time;

    @Before
    public void setup() {
        this.time = new Time();
    }

    @Test
    public void it_should_get_the_current_date() {

        assertThat(this.time.getCurrentDate()).isEqualTo(LocalDate.now());
    }

    @Test
    public void it_should_get_the_current_date_plus_3_days() {

        assertThat(this.time.getCurrentDatePlus3Days()).isEqualTo(LocalDate.now().plusDays(3));
    }

    @Test
    public void it_should_get_the_current_year() {

        assertThat(this.time.getCurrentYear()).isEqualTo(LocalDate.now().getYear());
    }

    @Test
    public void it_should_get_the_current_date_using_a_clock() {

        final Clock clock = Clock.fixed(Instant.parse("2025-01-01T12:00:00.00Z"), ZoneOffset.UTC);

        assertThat(this.time.getCurrentDateUsingAClock(clock)).isEqualTo("2025-01-01");
    }

    @Test
    public void it_should_get_the_tetris_release_date() {

        assertThat(this.time.getTetrisReleaseDate()).isEqualTo("1984-06-06");
    }

    @Test
    public void it_should_parse_an_iso_date() {

        assertThat(this.time.parseIsoDate("1990-11-24")).isEqualTo("1990-11-24");
    }

    @Test
    public void it_should_get_the_current_time() {

        assertThat(this.time.getCurrentTime())
                .isCloseTo(LocalTime.now(), within(1, SECONDS));
    }

    @Test
    public void it_should_parse_an_iso_time() {

        assertThat(this.time.parseIsoTime("15:43:31")).isEqualTo("15:43:31");
    }

    @Test
    public void it_should_get_the_current_date_time() {

        assertThat(this.time.getCurrentDateTime()).isCloseTo(LocalDateTime.now(), within(1, SECONDS));
    }

    @Test
    public void it_should_parse_an_iso_date_time() {

        assertThat(this.time.parseIsoDateTime("1990-11-24T10:15:30")).isEqualTo("1990-11-24T10:15:30");
    }

    @Test
    public void it_should_format_an_iso_date_time() {

        assertThat(this.time.formatInIsoLocalDateTime(LocalDateTime.parse("1990-11-24T10:15:30")))
                .isEqualTo("1990-11-24T10:15:30");
    }

    @Test
    public void it_should_get_the_current_zoned_date_time_in_system_timezone() {

        final ZonedDateTime currentZonedDateTime = this.time.getCurrentZonedDateTimeInSystemTimezone();

        assertThat(currentZonedDateTime.toLocalDateTime())
                .isCloseTo(ZonedDateTime.now().toLocalDateTime(), within(1, SECONDS));
    }

    @Test
    public void it_should_get_the_current_zoned_date_time_in_utc() {

        final ZonedDateTime currentZonedDateTime = this.time.getCurrentZonedDateTimeInUTC();

        assertThat(currentZonedDateTime.toLocalDateTime())
                .isCloseTo(ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime(), within(1, SECONDS));
    }

    @Test
    public void it_should_get_the_current_zoned_date_time_in_moscow() {

        final ZonedDateTime currentZonedDateTime = this.time.getCurrentZonedDateTimeInMoscow();

        assertThat(currentZonedDateTime.toLocalDateTime())
                .isCloseTo(this.getLocalDateTimeInMoscow(), within(1, SECONDS));
    }

    @Test
    public void it_should_get_the_current_date_time_in_moscow() {

        assertThat(this.time.getCurrentLocalDateTimeInMoscow())
                .isCloseTo(this.getLocalDateTimeInMoscow(), within(1, SECONDS));
    }

    @Test
    public void it_should_convert_to_zoned_date_time_in_new_york() {

        final ZonedDateTime zonedDateTimeInMoscow = ZonedDateTime.of(LocalDateTime.parse("2019-10-01T15:30:00"),
                ZoneId.of(MOSCOW_TIMEZONE));

        assertThat(this.time.convertToZonedDateTimeInNewYork(zonedDateTimeInMoscow).toLocalDateTime())
                .isEqualTo("2019-10-01T08:30:00");
    }

    @Test
    public void it_should_get_the_seconds_between_the_epoch_time_and_a_date_time() {

        final ZonedDateTime zonedDateTime = LocalDateTime.parse("2019-10-31T10:00:00").atZone(ZoneOffset.UTC);

        assertThat(this.time.getSecondsBetweenTheEpochTimeAndADateTime(zonedDateTime)).isEqualTo(1572516000L);
    }

    @Test
    public void it_should_get_all_the_available_zone_ids_from_europe() {

        assertThat(this.time.getAllTheAvailableZoneIdsFromEurope()).allMatch(zoneId -> zoneId.startsWith("Europe/"));
    }

    @Test
    public void it_should_get_the_current_instant() {

        assertThat(this.time.getCurrentInstant()).isCloseTo(Instant.now(), within(1, SECONDS));
    }

    @Test
    public void it_should_convert_seconds_from_epoch_time_to_instant() {

        assertThat(this.time.convertSecondsFromEpochTimeToAnInstant(1569931200L)).isEqualTo("2019-10-01T12:00:00.00Z");
    }

    @Test
    public void it_should_convert_an_instant_to_zoned_date_time_in_moscow() {

        final Instant instant = Instant.parse("2019-11-15T12:00:00.00Z");

        assertThat(this.time.convertInstantToZonedDateTimeInMoscow(instant))
                .isEqualTo(LocalDateTime.parse("2019-11-15T15:00").atZone(ZoneId.of("Europe/Moscow")));
    }

    @Test
    public void it_should_get_the_seconds_between_the_epoch_time_and_an_instant() {

        final Instant instant = Instant.parse("2019-12-01T12:00:00.00Z");

        assertThat(this.time.getSecondsBetweenTheEpochTimeAndAnInstant(instant)).isEqualTo(1575201600L);
    }

    @Test
    public void it_should_get_a_period_of_months_and_days() {

        assertThat(this.time.getPeriodOfMonthsAndDays(2, 5)).isEqualTo(Period.parse("P2M5D"));
    }

    @Test
    public void it_should_get_the_days_between_two_dates() {

        final LocalDate firstDate = LocalDate.parse("2019-10-01");
        final LocalDate secondDate = LocalDate.parse("2019-10-04");

        assertThat(this.time.getDaysBetweenTwoLocalDates(firstDate, secondDate)).isEqualTo(3);
    }

    @Test
    public void it_should_add_a_period_to_a_date() {

        final Period periodToAdd = Period.of(1, 2, 3);
        final LocalDateTime dateTime = LocalDateTime.parse("2017-10-01T08:00:00");

        assertThat(this.time.getADateTimePlusSomePeriod(dateTime, periodToAdd))
                .isEqualTo("2018-12-04T08:00:00");
    }

    @Test
    public void it_should_get_a_duration_of_hours_and_minutes() {

        assertThat(this.time.getDurationOfHoursAndMinutes(5, 23))
                .isEqualTo(Duration.parse("PT5H23M"));
    }

    @Test
    public void it_should_get_the_hours_between_two_datetimes() {

        final LocalDateTime firstDateTime = LocalDateTime.parse("2019-01-01T15:00:00");
        final LocalDateTime secondDateTime = LocalDateTime.parse("2019-01-01T10:00:00");

        assertThat(this.time.getHoursBetweenTwoLocalDateTimes(firstDateTime, secondDateTime)).isEqualTo(-5L);
    }

    private LocalDateTime getLocalDateTimeInMoscow() {
        return ZonedDateTime.now(ZoneId.of(MOSCOW_TIMEZONE)).toLocalDateTime();
    }
}