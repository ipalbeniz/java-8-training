package training;

import training.model.Message;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Welcome to the optionals training
 * <p>
 * Please, implement all the methods and pass all the tests
 * <p>
 * More info in spanish: https://experto.dev/java-8-optional/
 * More info in english: https://www.baeldung.com/java-optional
 */
public class Optionals {

    public Optional<String> getAnEmptyOptional() {
        return Optional.empty();
    }

    public Optional<String> getAnOptionalOfANullableMessage(final String message) {
        return Optional.ofNullable(message);
    }

    public boolean checkIfTheMessageProvidedHasValue(final Supplier<Optional<String>> messageSupplier) {
        return messageSupplier.get().isPresent();
    }

    public String getTheMessageProvidedOrNullIfItHasNoValue(final Supplier<Optional<String>> messageSupplier) {
        return messageSupplier.get().orElse(null);
    }

    public void printTheMessageProvidedOnlyIfItHasValue(final Supplier<Optional<String>> messageSupplier) {
        messageSupplier.get().ifPresent(System.out::println);
    }

    public String getTheMessageProvidedOrTheDefaultMessageIfItHasNoValue(final Supplier<Optional<String>> messageSupplier,
                                                                         final Supplier<String> defaultMessageSupplier) {
        return messageSupplier.get().orElseGet(defaultMessageSupplier);
    }

    public String getTheMessageProvidedOrThrowIllegalArgumentExceptionIfItHasNoValue(final Supplier<Optional<String>> messageSupplier) {
        return messageSupplier.get().orElseThrow(IllegalArgumentException::new);
    }

    public Optional<String> getTheMessageProvidedInUpperCase(final Supplier<Optional<String>> messageSupplier) {
        return messageSupplier.get().map(String::toUpperCase);
    }

    public Optional<Integer> getTheNumberProvidedOnlyIfItIsAnEvenNumber(final Supplier<Optional<Integer>> numberSupplier) {
        return numberSupplier.get().filter(integer -> integer % 2 == 0);
    }

    public Optional<String> getTheMessageContentInUpperCase(final Supplier<Optional<Message>> messageSupplier) {

        return messageSupplier.get()
                .flatMap(Message::getContent)
                .map(String::toUpperCase);
    }

    public List<String> getTheMessageContentsThatHaveValue(final Supplier<List<Message>> messagesSupplier) {

        return messagesSupplier.get().stream()
                .map(Message::getContent)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
