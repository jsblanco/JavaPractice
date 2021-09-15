package exceptions;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        try {
        int result = divide();
        System.out.println(result);
        } catch(ArithmeticException | NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("Unable to perform division, automatically shutting down.");
        }
    }

    private static int divide() {
        int x, y;
        try {
            x = getInt();
            y = getInt();
            System.out.println("X is " + x + " and Y is " + y);
            return x / y;
        } catch (NoSuchElementException e) {
            // Lanzando estos errores personalizados nos aseguramos de limitar el stack trace a nuestro código
            // y no seguir la cascada de extensiones de clases del codigo interno de Java
            throw new NoSuchElementException("No suitable input");
        } catch (ArithmeticException e) {
            // Con varios Catches Java los sigue en orden y se queda en el primer Catch apropiado, ignorando el resto.
            throw new ArithmeticException("Attempt to divide by zero");
        }
    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Kindly type an integer:");
        try {
            return s.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input was not an integer.");
            return getInt();
        }
    }
}
