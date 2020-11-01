package com.example.packagesChallenge;

import com.example.series.Series;

public class Main {

    public static void main(String[] args) {

        for (int i= 0; i <= 10; i++){
            System.out.println(Series.nSum(i));
        }
        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        for (int i= 0; i <= 10; i++){
            System.out.println(Series.factorial(i));
        }
        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        for (int i= 0; i <= 10; i++){
            System.out.println(Series.fibonacci(i));
        }
    }
}
