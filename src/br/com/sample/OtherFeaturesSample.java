package br.com.sample;

import java.util.Scanner;
import java.util.concurrent.Callable;

public class OtherFeaturesSample {

    public static void main (final String... args) throws Exception {
        // Enhanced Try With Resources
        enhancedTryWithResources(new Scanner(System.in));

        // Inferência de tipos em classes anônimas
        final Callable<String> callable = new Callable<>() {

            @Override
            public String call () throws Exception {
                return "Teste";
            }
        };
        System.out.println(callable.call());

        // Métodos privados em interfaces
        final Test test = OtherFeaturesSample::showMessage;
        test.printGreetings();
        test.printHello();
        test.showMessage();
    }

    public static void enhancedTryWithResources (final Scanner scanner) {
        // Variaveis efetivamente finais agora podem ser utilizadas no try with resources
        try (scanner) {
            System.out.println(scanner);
        }
    }

    private static void showMessage () {
        System.out.println("Teste");
    }

}

interface Test {

    default void printGreetings () {
        this.printMessage("Greetings!");
    }

    default void printHello () {
        this.printMessage("Hello!");
    }

    void showMessage ();

    /**
     * Interfaces agora podem possuir métodos privados
     *
     * @param message
     */
    private void printMessage (final String message) {
        System.out.println(message);
    }
}
