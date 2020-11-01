package com.example.series;

public class Series {

    public static int nSum(int n) {
        int sum = 0;
        for (int i = 0; i <= n; ++i) {
            sum += i;
        }

        return sum;
    }

    public static int factorial(int n) {

        if (n==0) return n;
        int factorial = 1;

        for (int i = 1; i <= n; ++i) {
            factorial *= i;
        }

        return factorial;
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else {
            int fibonacci1 = 0;
            int fibonacci2 = 1;

            for (int i = 0; i < n; ++i) {
                int sum = fibonacci2 + fibonacci1;
                fibonacci1 = fibonacci2;
                fibonacci2 = sum;
            }

            return fibonacci1;
        }
    }
}

