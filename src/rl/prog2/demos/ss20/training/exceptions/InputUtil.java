package rl.prog2.ss20.training.exceptions;

import java.io.IOException;

public class InputUtil {

    public static void doSomethingDifficult() {
        System.out.println("starting...");
        int i = 1 / 0;
        if (true) { // disaster has happened...
            // throw new RuntimeException("XY went wrong!");
            throw new InputException();
        }
        System.out.println("finished...");
    }

    public static void callSomething() {
        try {
            doSomethingDifficult();
        } catch (RuntimeException ex) {
            throw new InputException("Tief unten ist Unsinn passiert.", ex);
        }
    }


    public static void main(String[] args) {
        try {
            callSomething();
            System.out.println("Doing something else...");
        } catch (InputException ex) {
            System.out.println("Catching exception "
                    + ex.getClass().getSimpleName() + ": " + ex.getMessage());
            System.out.println("Cause: " + ex.getCause());
            // ex.printStackTrace();
        } catch (Exception ex) {
                System.out.println("Gefangen...");
        } finally {
            System.out.println("huch!");
        }
        System.out.println("Programmende...");
    }


    public static class InputException extends RuntimeException {
        public InputException() {
        }

        public InputException(String message) {
            super(message);
        }

        public InputException(String message, Throwable cause) {
            super(message, cause);
        }

    }

}
