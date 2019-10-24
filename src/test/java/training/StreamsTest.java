package training;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class StreamsTest {

    private Streams streams;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void setup() {
        this.streams = new Streams();
    }

    @Test
    public void it_should_get_a_stream_of_names_in_an_array() {

        assertThat(streams.getAStreamOfNames(new String[]{"Iñaki", "John Carmack"}))
                .containsExactly("Iñaki", "John Carmack");
    }

    @Test
    public void it_should_get_a_stream_of_names_in_a_list() {

        assertThat(streams.getAStreamOfNames(asList("Woody", "Buzz Lightyear")))
                .containsExactly("Woody", "Buzz Lightyear");
    }

    @Test
    public void it_should_get_a_stream_of_two_names() {

        assertThat(streams.getAStreamOfTwoNames("Goku", "Bulma"))
                .containsExactly("Goku", "Bulma");
    }

    @Test
    public void it_should_get_a_list_of_names() {

        assertThat(streams.getAListOfNames(Stream.of("Sarah Connor", "Terminator")))
                .containsExactly("Sarah Connor", "Terminator");
    }

    @Test
    public void it_should_get_the_numbers_from_zero_to_ten() {

        assertThat(streams.getAStreamOfIntegersFromZeroToTen())
                .containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @Test
    public void it_should_print_the_messages() {

        streams.printTheMessages(asList("Hello World!", "All your base are belong to us"));

        assertThat(systemOutRule.getLog()).contains("Hello World!", "All your base are belong to us");
    }

    @Test
    public void it_should_convert_the_numbers_to_strings() {

        assertThat(streams.convertTheNumbersToStrings(asList(1, 2, 3))).containsExactly("1", "2", "3");
    }

    @Test
    public void it_should_get_the_even_numbers() {

        assertThat(streams.getOnlyTheEvenNumbers(asList(1, 2, 3, 4))).containsExactly(2, 4);
    }

    @Test
    public void it_should_get_the_first_even_number() {

        assertThat(streams.getTheFirstEvenNumberOrNullIfNotFound(asList(1, 3, 7, 4, 9, 2))).isEqualTo(4);
    }

    @Test
    public void it_should_sum_the_even_numbers() {

        assertThat(streams.sumTheEvenNumbers(asList(1, 3, 7, 4, 9, 2))).isEqualTo(6);
    }

    @Test
    public void it_should_check_if_all_the_numbers_are_even() {

        assertThat(streams.checkIfAllTheNumbersAreEven(asList(2, 6, 4))).isTrue();
        assertThat(streams.checkIfAllTheNumbersAreEven(asList(2, 3, 6, 4))).isFalse();
    }

    @Test
    public void it_should_get_the_distinct_names() {

        assertThat(streams.getTheDistinctNames(asList("Mia", "Vincent", "Jules", "Vincent", "Mia")))
                .contains("Mia", "Vincent", "Jules");
    }

    @Test
    public void it_should_get_first_three_names() {

        assertThat(streams.getTheFirstThreeNames(asList("Neo", "Morpheus", "Trinity", "Agent Smith")))
                .containsExactly("Neo", "Morpheus", "Trinity");
    }

    @Test
    public void it_should_sort_the_names() {

        assertThat(streams.sortTheNames(asList("Luke", "Darth Vader", "Han Solo", "Chewbacca", "Leia")))
                .containsExactly("Chewbacca", "Darth Vader", "Han Solo", "Leia", "Luke");
    }

    @Test
    public void it_should_count_the_names_that_start_with_the_letter_D() {

        assertThat(streams.countTheNamesThatStartWithTheLetterD(asList("Dave", "HAL 9000"))).isEqualTo(1);
    }
}