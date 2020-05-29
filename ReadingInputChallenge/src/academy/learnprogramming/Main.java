package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int counter = 0;
        boolean isInt = true;

        /*for (int i = 1; i < 11; i++) {
            System.out.println("Enter number #" + i);
            isInt = scanner.hasNextInt();
            if (!isInt) {
                System.out.println("Invalid number");
                i = 99;
            } else {
                sum += scanner.nextInt();
            }
            if (i == 10) System.out.println(sum);
        }*/

        while (true) {

            System.out.println("Enter number #" + (counter + 1));
            isInt = scanner.hasNextInt();

            if (!isInt) {
                System.out.println("Invalid number");
            } else {
                int number = scanner.nextInt();
                sum += number;
                counter++;
                if (counter == 10) {
                    System.out.println("Final sum: "+sum);
                    break;
                }
            }

            scanner.nextLine();
        }


        scanner.close();
    }
}
