package training;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class LambdasTest {

    private Lambdas lambdas;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void setup() {
        this.lambdas = new Lambdas();
    }

    @Test
    public void it_should_get_a_current_year_supplier() {

        assertEquals(LocalDate.now().getYear(), (long) lambdas.getASupplierThatProvidesTheCurrentYear().get());
    }

    @Test
    public void it_should_print_the_current_year() {

        lambdas.printCurrentYear();

        assertEquals(String.valueOf(LocalDate.now().getYear()), systemOutRule.getLog().trim());
    }

    @Test
    public void it_should_get_a_value_printer() {

        lambdas.getAConsumerThatPrintsAString().accept("MyValue");

        assertEquals("MyValue", systemOutRule.getLog().trim());
    }

    @Test
    public void it_should_print_a_value() {

        lambdas.printValue("Value");

        assertEquals("Value", systemOutRule.getLog().trim());
    }

    @Test
    public void it_should_get_a_function_that_counts_a_string_number_of_characters() {

        assertEquals(37, (int) lambdas.getAFunctionThatCountsTheNumberOfCharactersOfAString()
                .apply("This string should have 37 characters"));
    }

    @Test
    public void it_should_print_the_number_of_characters() {

        lambdas.printNumberOfCharacters("Hello world!");

        assertEquals("12", systemOutRule.getLog().trim());
    }

    @Test
    public void it_should_get_an_even_number_detector() {

        assertFalse(lambdas.getAPredicateThatDetectsAnEvenNumber().test(1));
        assertTrue(lambdas.getAPredicateThatDetectsAnEvenNumber().test(2));
    }

    @Test
    public void it_should_print_whether_a_number_is_even() {

        lambdas.printWhetherANumberIsEvenOrNot(1);
        assertEquals("false", systemOutRule.getLog().trim());

        systemOutRule.clearLog();

        lambdas.printWhetherANumberIsEvenOrNot(2);
        assertEquals("true", systemOutRule.getLog().trim());
    }

    @Test
    public void it_should_get_an_uppercase_transformer() {

        assertEquals("HELLO WORLD!", lambdas.getAUnaryOperatorThatTransformsAStringToUpperCase().apply("Hello World!"));
    }

    @Test
    public void it_should_print_an_uppercase_version_of_a_string() {

        lambdas.printAStringToUpperCase("Hello world!");

        assertEquals("HELLO WORLD!", systemOutRule.getLog().trim());
    }

    @Test
    public void it_should_get_a_calculator_that_sums_two_numbers() {

        assertEquals(10, lambdas.getACalculatorThatSumsTwoNumbers().calculate(3, 7));
    }

    @Test
    public void it_should_get_a_calculator_that_multiplies_two_numbers() {

        assertEquals(21, lambdas.getACalculatorThatMultipliesTwoNumbers().calculate(3, 7));
    }
}