package training;

import training.model.Movie;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

/**
 * Welcome to the steams training
 * <p>
 * Please, implement all the methods and pass all the tests
 * <p>
 * More info in spanish: https://www.belikesoftware.com/java-8-streams/
 * More info in english: https://www.baeldung.com/java-8-streams
 */
public class Streams {

    public Stream<String> getAStreamOfNames(final String[] names) {
        return Arrays.stream(names);
    }

    public Stream<String> getAStreamOfNames(final List<String> names) {
        return names.stream();
    }

    public Stream<String> getAStreamOfTwoNames(final String firstName, final String secondName) {
        return Stream.of(firstName, secondName);
    }

    public List<String> getAListOfNames(final Stream<String> streamOfNames) {
        return streamOfNames.collect(toList());
    }

    public Stream<Integer> getAStreamOfIntegersFromZeroToTen() {
        return IntStream.rangeClosed(0, 10).boxed();
    }

    public void printTheMessages(final List<String> messages) {
        messages.forEach(System.out::println);
    }

    public List<String> convertTheNumbersToStrings(final List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(toList());
    }

    public List<Integer> getOnlyTheEvenNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .collect(toList());
    }

    public Integer getTheFirstEvenNumberOrNullIfNotFound(final List<Integer> numbers) {
        return numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .findFirst()
                .orElse(null);
    }

    public int sumTheEvenNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public boolean checkIfAllTheNumbersAreEven(final List<Integer> numbers) {
        return numbers.stream()
                .allMatch(integer -> integer % 2 == 0);
    }

    public List<String> getTheNamesInUpperCase(final List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .collect(toList());
    }

    public List<String> getTheDistinctNames(final List<String> names) {
        return names.stream()
                .distinct()
                .collect(toList());
    }

    public List<String> getTheFirstThreeNames(final List<String> names) {
        return names.stream()
                .limit(3)
                .collect(toList());
    }

    public List<String> sortTheNames(final List<String> disorderedNames) {
        return disorderedNames.stream()
                .sorted()
                .collect(toList());
    }

    public long countTheNamesThatStartWithTheLetterD(final List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .filter(nameInUpperCase -> nameInUpperCase.startsWith("D"))
                .count();
    }

    public Optional<Movie> getTheOldestMovie(final List<Movie> movies) {
        return movies.stream()
                .min(comparingInt(Movie::getYear));
    }

    public Set<String> getAllTheCharactersFromTheMovies(final List<Movie> movies) {
        return movies.stream()
                .flatMap(movie -> movie.getCharacters().stream())
                .collect(toSet());
    }

    public List<Movie> getTheMoviesFromTheSeventiesOrderedByYearInDescendingOrderAndNameInAscendingOrder(final List<Movie> movies) {
        return movies.stream()
                .filter(this::isFromTheSeventies)
                .sorted(this.byYearInDescendingOrder()
                        .thenComparing(Movie::getName))
                .collect(toList());
    }

    private boolean isFromTheSeventies(final Movie movie) {
        return movie.getYear() >= 1970 && movie.getYear() <= 1979;
    }

    private Comparator<Movie> byYearInDescendingOrder() {
        return comparing(Movie::getYear, reverseOrder());
    }

    public Map<Integer, String> getTheMovieNamesById(final List<Movie> movies) {
        return movies.stream()
                .collect(toMap(Movie::getId, Movie::getName));
    }

    public Map<String, List<Movie>> getTheMoviesOfEachDirector(final List<Movie> movies) {
        return movies.stream()
                .collect(groupingBy(Movie::getDirector));
    }

    public Map<String, Movie> getTheMovieOfEachCharacter(final List<Movie> movies) {
        return movies.stream()
                .flatMap(this::aStreamOfCharacterAndMovie)
                .collect(toMap(CharacterAndMovie::getCharacter, CharacterAndMovie::getMovie));
    }

    private Stream<CharacterAndMovie> aStreamOfCharacterAndMovie(final Movie movie) {
        return movie.getCharacters().stream()
                .map(character -> new CharacterAndMovie(character, movie));
    }

    private static class CharacterAndMovie {

        private final String character;
        private final Movie movie;

        CharacterAndMovie(final String character, final Movie movie) {
            this.character = character;
            this.movie = movie;
        }

        String getCharacter() {
            return character;
        }

        Movie getMovie() {
            return movie;
        }
    }

    public Integer getTheYearWithMoreMovies(final List<Movie> movies) {
        return movies.stream()
                .collect(groupingBy(Movie::getYear, counting()))
                .entrySet().stream()
                .max(comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
