package training;

import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import training.model.Movie;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static training.MovieMother.theGodfather;
import static training.MovieMother.closeEncountersOfTheThirdKind;
import static training.MovieMother.etTheExtraTerrestrial;
import static training.MovieMother.pulpFiction;
import static training.MovieMother.starWars;

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
        assertThat(streams.getTheFirstEvenNumberOrNullIfNotFound(asList(1, 3, 7, 5, 9))).isEqualTo(null);
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
    public void it_should_get_the_names_in_uppercase() {

        assertThat(streams.getTheNamesInUpperCase(asList("Vito Corleone", "Michael Corleone", "Sonny Corleone")))
                .containsExactly("VITO CORLEONE", "MICHAEL CORLEONE", "SONNY CORLEONE");
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

    @Test
    public void it_should_get_all_the_characters_from_the_movies() {

        final List<Movie> movies = asList(starWars(), pulpFiction());

        assertThat(streams.getAllTheCharactersFromTheMovies(movies))
                .containsExactlyInAnyOrder("Luke Skywalker", "Leia", "Han Solo", "Mia", "Vincent", "Jules");
    }

    @Test
    public void it_should_get_the_movie_names_by_id() {

        final List<Movie> movies = asList(starWars(), theGodfather(), pulpFiction());

        assertThat(streams.getTheMovieNamesById(movies))
                .containsExactlyInAnyOrderEntriesOf(ImmutableMap.of(
                        1, "Star Wars",
                        2, "Pulp Fiction",
                        3, "The Godfather"
                ));
    }

    @Test
    public void it_should_get_the_movies_of_each_director() {

        final List<Movie> movies = asList(starWars(), theGodfather(), etTheExtraTerrestrial(), closeEncountersOfTheThirdKind());

        assertThat(streams.getTheMoviesOfEachDirector(movies))
                .containsExactlyInAnyOrderEntriesOf(ImmutableMap.of(
                        "George Lucas", singletonList(starWars()),
                        "Steven Spielberg", asList(etTheExtraTerrestrial(), closeEncountersOfTheThirdKind()),
                        "Francis Ford Coppola", singletonList(theGodfather())
                ));
    }

    @Test
    public void it_should_get_the_movie_of_each_character() {

        final List<Movie> movies = asList(pulpFiction(), etTheExtraTerrestrial());

        assertThat(streams.getTheMovieOfEachCharacter(movies))
                .containsExactlyInAnyOrderEntriesOf(ImmutableMap.<String, Movie>builder()
                        .put("Mia", pulpFiction())
                        .put("Vincent", pulpFiction())
                        .put("Jules", pulpFiction())
                        .put("Elliott", etTheExtraTerrestrial())
                        .put("Gertie", etTheExtraTerrestrial())
                        .put("E.T.", etTheExtraTerrestrial())
                        .build());
    }

    @Test
    public void it_should_get_the_year_with_more_movies() {

        final List<Movie> movies = asList(starWars(), pulpFiction(), theGodfather(), closeEncountersOfTheThirdKind(), etTheExtraTerrestrial());

        assertThat(streams.getTheYearWithMoreMovies(movies)).isEqualTo(1977);
    }
}