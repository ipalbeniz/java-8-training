package training;

import training.model.Message;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Welcome to the optionals training
 * <p>
 * Please implement all the methods and pass all the tests
 * <p>
 * More info in Spanish: <a href="https://experto.dev/java-8-optional/">...</a>
 * More info in English: <a href="https://www.baeldung.com/java-optional">...</a>
 */
public class Optionals {

    public Optional<String> getAnEmptyOptional() {
        // TODO
        return null;
    }

    public Optional<String> getAnOptionalOfANullableMessage(final String message) {
        // TODO
        return null;
    }

    public boolean checkIfTheMessageProvidedHasValue(final Supplier<Optional<String>> messageSupplier) {
        // TODO
        return false;
    }

    public String getTheMessageProvidedOrNullIfItHasNoValue(final Supplier<Optional<String>> messageSupplier) {
        // TODO
        return null;
    }

    public void printTheMessageProvidedOnlyIfItHasValue(final Supplier<Optional<String>> messageSupplier) {
        // TODO
    }

    public String getTheMessageProvidedOrTheDefaultMessageIfItHasNoValue(final Supplier<Optional<String>> messageSupplier,
                                                                         final Supplier<String> defaultMessageSupplier) {
        // TODO
        return null;
    }

    public String getTheMessageProvidedOrThrowIllegalArgumentExceptionIfItHasNoValue(final Supplier<Optional<String>> messageSupplier) {
        // TODO
        return null;
    }

    public Optional<String> getTheMessageProvidedInUpperCase(final Supplier<Optional<String>> messageSupplier) {
        // TODO
        return null;
    }

    public Optional<Integer> getTheNumberProvidedOnlyIfItIsAnEvenNumber(final Supplier<Optional<Integer>> numberSupplier) {
        // TODO
        return null;
    }

    public Optional<String> getTheMessageContentInUpperCase(final Supplier<Optional<Message>> messageSupplier) {
        // TODO
        return null;
    }

    public List<String> getTheMessageContentsThatHaveValue(final Supplier<List<Message>> messagesSupplier) {
        // TODO
        return null;
    }
}
