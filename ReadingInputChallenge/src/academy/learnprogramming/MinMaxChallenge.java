package academy.learnprogramming;

import java.util.Scanner;

public class MinMaxChallenge {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean validNum = true;

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int number;

        System.out.println("Please input a number:");
        validNum = scanner.hasNextInt();
        while (validNum) {
            number = scanner.nextInt();
            if (number > maxValue) {
                maxValue = number;
            }
            if (number < minValue) {
                minValue = number;
            }
            scanner.nextLine();
            System.out.println("Please input another number:");
            validNum = scanner.hasNextInt();
        }
        if (minValue == Integer.MAX_VALUE) {
            System.out.println("No valid numbers entered");
        } else {
            System.out.println("Minimum value entered: " + minValue + " and maximum value entered: " + maxValue);
        }
        scanner.close();
    }

}
