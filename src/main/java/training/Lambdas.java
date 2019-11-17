package training;

import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Welcome to the lambdas training
 * <p>
 * Please, implement all the methods and pass all the tests
 * <p>
 * More info in spanish: https://www.adictosaltrabajo.com/2015/12/04/expresiones-lambda-con-java-8/
 * More info in english: https://www.baeldung.com/java-8-functional-interfaces
 */
public class Lambdas {

    /*
    Supplier
     */
    public Supplier<Integer> getASupplierThatProvidesTheCurrentYear() {
        return () -> LocalDate.now().getYear();
    }

    public void printCurrentYear() {
        System.out.println(this.getASupplierThatProvidesTheCurrentYear().get());
    }


    /*
    Consumer
     */
    public Consumer<String> getAConsumerThatPrintsAString() {
        return System.out::println;
    }

    public void printValue(final String value) {
        this.getAConsumerThatPrintsAString().accept(value);
    }


    /*
    Function
     */
    public Function<String, Integer> getAFunctionThatCountsTheNumberOfCharactersOfAString() {
        return String::length;
    }

    public void printNumberOfCharacters(final String myString) {
        System.out.println(this.getAFunctionThatCountsTheNumberOfCharactersOfAString().apply(myString));
    }


    /*
    Predicate
     */
    public Predicate<Integer> getAPredicateThatDetectsAnEvenNumber() {
        return number -> number % 2 == 0;
    }

    public void printWhetherANumberIsEvenOrNot(final Integer number) {
        System.out.println(this.getAPredicateThatDetectsAnEvenNumber().test(number));
    }


    /*
    UnaryOperator
     */
    public UnaryOperator<String> getAUnaryOperatorThatTransformsAStringToUpperCase() {
        return String::toUpperCase;
    }

    public void printAStringToUpperCase(final String myString) {
        System.out.println(this.getAUnaryOperatorThatTransformsAStringToUpperCase().apply(myString));
    }


    /*
    Runnable
     */
    public Runnable getARunnableThatPrintsHelloWorld() {
        // TODO
        return null;
    }

    public Thread getAThreadThatPrintsHelloWorld() {
        // TODO
        return null;
    }


    /*
    Custom Functional Interface
     */
    public Calculator getACalculatorThatSumsTwoNumbers() {
        return Integer::sum;
    }

    public Calculator getACalculatorThatMultipliesTwoNumbers() {
        return (x, y) -> x * y;
    }

    @FunctionalInterface
    public interface Calculator {
        int calculate(int x, int y);
    }
}
