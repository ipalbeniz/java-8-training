package training;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import training.model.Message;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class OptionalsTest {

    private Optionals optionals;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void setup() {
        this.optionals = new Optionals();
    }

    @Test
    public void it_should_get_an_empty_optional() {

        assertThat(optionals.getAnEmptyOptional()).isEmpty();
    }

    @Test
    public void it_should_get_an_optional_of_a_message() {

        assertThat(optionals.getAnOptionalOfANullableMessage("all your base are belong to us").get())
                .isEqualTo("all your base are belong to us");
        assertThat(optionals.getAnOptionalOfANullableMessage(null)).isEmpty();
    }

    @Test
    public void it_should_check_if_the_message_provided_has_value() {

        assertThat(optionals.checkIfTheMessageProvidedHasValue(() -> Optional.of("I love the smell of napalm in the morning")))
                .isTrue();
        assertThat(optionals.checkIfTheMessageProvidedHasValue(Optional::empty))
                .isFalse();
    }

    @Test
    public void it_should_get_the_message_provided_or_null_if_empty() {

        assertThat(optionals.getTheMessageProvidedOrNullIfItHasNoValue(() -> Optional.of("You talking to me?")))
                .isEqualTo("You talking to me?");
        assertThat(optionals.getTheMessageProvidedOrNullIfItHasNoValue(Optional::empty))
                .isNull();
    }

    @Test
    public void it_should_print_the_message_when_it_has_value() {

        optionals.printTheMessageProvidedOnlyIfItHasValue(Optional::empty);

        assertThat(systemOutRule.getLog()).isEmpty();


        optionals.printTheMessageProvidedOnlyIfItHasValue(() -> Optional.of("May the Force be with you"));

        assertThat(systemOutRule.getLog().trim()).isEqualTo("May the Force be with you");
    }

    @Test
    public void it_should_get_the_message_provided_or_the_default_if_empty() {

        assertThat(optionals.getTheMessageProvidedOrTheDefaultMessageIfItHasNoValue(
                () -> Optional.of("Show me the money"),
                () -> "There's no place like home"))
                .isEqualTo("Show me the money");
        assertThat(optionals.getTheMessageProvidedOrTheDefaultMessageIfItHasNoValue(
                Optional::empty,
                () -> "There's no place like home"))
                .isEqualTo("There's no place like home");
    }

    @Test
    public void it_should_get_the_message_provided_when_it_has_value() {

        assertThat(optionals.getTheMessageProvidedOrThrowIllegalArgumentExceptionIfItHasNoValue(() -> Optional.of("I'll be back")))
                .isEqualTo("I'll be back");
    }

    @Test(expected = IllegalArgumentException.class)
    public void it_should_throw_exception_when_the_message_provided_is_empty() {

        optionals.getTheMessageProvidedOrThrowIllegalArgumentExceptionIfItHasNoValue(Optional::empty);
    }

    @Test
    public void it_should_get_the_message_provided_in_uppercase() {

        assertThat(optionals.getTheMessageProvidedInUpperCase(() -> Optional.of("Hasta la vista, baby")))
                .hasValue("HASTA LA VISTA, BABY");
        assertThat(optionals.getTheMessageProvidedInUpperCase(Optional::empty))
                .isEmpty();
    }

    @Test
    public void it_should_get_the_number_when_it_is_an_even_number() {

        assertThat(optionals.getTheNumberProvidedOnlyIfItIsAnEvenNumber(() -> Optional.of(2)))
                .hasValue(2);
        assertThat(optionals.getTheNumberProvidedOnlyIfItIsAnEvenNumber(() -> Optional.of(1)))
                .isEmpty();
    }

    @Test
    public void it_should_get_the_message_content_in_uppercase() {

        final Message message = new Message("My precious");

        assertThat(optionals.getTheMessageContentInUpperCase(() -> Optional.of(message)))
                .hasValue("MY PRECIOUS");


        final Message messageWithoutContent = new Message(null);

        assertThat(optionals.getTheMessageContentInUpperCase(() -> Optional.of(messageWithoutContent)))
                .isEmpty();
    }

    @Test
    public void it_should_get_the_message_contents_that_have_value() {

        final List<Message> messages = asList(
                new Message("Elementary, my dear Watson"),
                new Message(null),
                new Message("Keep your friends close, but your enemies closer"),
                new Message(null),
                new Message("")
        );
        assertThat(optionals.getTheMessageContentsThatHaveValue(() -> messages))
                .containsExactly("Elementary, my dear Watson", "Keep your friends close, but your enemies closer", "");
    }
}