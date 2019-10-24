package training;

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
        // TODO
        return null;
    }

    public void printCurrentYear() {
        // TODO
    }


    /*
    Consumer
     */
    public Consumer<String> getAConsumerThatPrintsAString() {
        // TODO
        return null;
    }

    public void printValue(final String value) {
        // TODO
    }


    /*
    Function
     */
    public Function<String, Integer> getAFunctionThatCountsTheNumberOfCharactersOfAString() {
        // TODO
        return null;
    }

    public void printNumberOfCharacters(final String myString) {
        // TODO
    }


    /*
    Predicate
     */
    public Predicate<Integer> getAPredicateThatDetectsAnEvenNumber() {
        // TODO
        return null;
    }

    public void printWhetherANumberIsEvenOrNot(final Integer number) {
        // TODO
    }


    /*
    UnaryOperator
     */
    public UnaryOperator<String> getAUnaryOperatorThatTransformsAStringToUpperCase() {
        // TODO
        return null;
    }

    public void printAStringToUpperCase(final String myString) {
        // TODO
    }
}
