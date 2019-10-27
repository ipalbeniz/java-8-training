package training;

import training.model.Movie;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

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
        return streamOfNames.collect(Collectors.toList());
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
                .collect(Collectors.toList());
    }

    public List<Integer> getOnlyTheEvenNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.toList());
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
        // TODO
        return null;
    }

    public List<String> getTheDistinctNames(final List<String> names) {
        return names.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public List<String> getTheFirstThreeNames(final List<String> names) {
        return names.stream()
                .limit(3)
                .collect(Collectors.toList());
    }

    public List<String> sortTheNames(final List<String> disorderedNames) {
        return disorderedNames.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public long countTheNamesThatStartWithTheLetterD(final List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .filter(nameInUpperCase -> nameInUpperCase.startsWith("D"))
                .count();
    }

    public Set<String> getAllTheCharactersFromTheMovies(final List<Movie> movies) {
        // TODO
        return null;
    }

    public Map<Integer, String> getTheMovieNamesById(final List<Movie> movies) {
        // TODO
        return null;
    }

    public Map<String, List<Movie>> getTheMoviesOfEachDirector(final List<Movie> movies) {
        // TODO
        return null;
    }

    public Map<String, Movie> getTheMovieOfEachCharacter(final List<Movie> movies) {
        // TODO
        return null;
    }

    public Integer getTheYearWithMoreMovies(final List<Movie> movies) {
        // TODO
        return null;
    }
}
