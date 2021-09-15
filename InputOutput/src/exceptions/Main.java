package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        testExceptionHandlingMethods();

        int x = getIntEAFP();
        System.out.println("X is " + x);
    }

    private static void testExceptionHandlingMethods() {
        int x = 98;
        int y = 0;
        System.out.println("Look before you leap method: " + divideLookBeforeYouLeap(x, y));
        System.out.println("Better ask for forgiveness method:" + divideAskForForgivenessNotPermission(x, y));
        System.out.println("YOLO with no methods: " + divideYOLO(x, y));
    }

    private static int getInt() {
        System.out.println("Please enter a number on your console:");
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    private static int getIntEAFP() {
        System.out.println("Please enter a number on your console:");
        Scanner s = new Scanner(System.in);
        try {
            return s.nextInt();
        } catch (InputMismatchException e) {
            return 0;
        }
    }

    private static int getIntLBYL() {
        System.out.println("Please enter a number on your console:");
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        String input = s.next();
        for (int i = 0; i < input.length(); i++)
            if (!Character.isDigit(input.charAt(i))) {
                isValid = false;
                break;
            }
        if (isValid) return Integer.parseInt(input);
        return 0;

    }

    private static int divideLookBeforeYouLeap(int x, int y) {
        if (y == 0) return 0;
        return x / y;
    }

    private static int divideAskForForgivenessNotPermission(int x, int y) {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            return 0;
        }
    }

    private static int divideYOLO(int x, int y) {
        return x / y;
    }
}
