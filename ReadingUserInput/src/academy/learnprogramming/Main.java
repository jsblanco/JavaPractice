package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your birth year:");

        boolean hasNextInt = scanner.hasNextInt();

        int year = scanner.nextInt();
        scanner.nextLine(); //al poner un nextInt, tenemos que usar esta linea porque sino interpreta el "enter" como del siguiente nextLine



        if (year >2020 || year < 1900 || !hasNextInt){
            System.out.println("Please enter a valid year: ");
            year = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        int age = (2020- year);


        System.out.println("Your name is "+name.substring(0,1).toUpperCase()+name.substring(1).toLowerCase()
                +" and you were born on "+year+", so you are between "+(age-1)+" and "+age+" years old.");
        scanner.close();
    }
}
