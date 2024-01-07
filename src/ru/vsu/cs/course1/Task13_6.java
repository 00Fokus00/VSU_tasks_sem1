package ru.vsu.cs.course1;

import java.util.Locale;
import java.util.Scanner;

public class Task13_6 {

    public static double Ideal(double x) {
       return 1 / Math.pow(1 + x, 3);
    }
    private static double function(double x, int n, double e) {
        double sum = 0;
        int num = 1;
        for (int i = 0; i < n; i++) {
            double s = (((1 + i) * (2 + i)) / 2) * Math.pow(x, i);
            if (num % 2 == 0) {
                sum -= (Math.abs(s) > e) ? s : 0;
                num++;
            } else {
                sum += (Math.abs(s) > e) ? s : 0;
                num++;
            }
        } return sum;
    }

    private static double FunctionWithoutE(double x, int n) {
        return function(x, n, 0);
    }
    private static double FunctionWithSmallE(double x, int n, double e) {
        return function(x, n, e/10);
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);

        System.out.print("x = ");
        double x = scanner.nextDouble();
        System.out.print("n = " );
        int n = scanner.nextInt();
        System.out.print("e = ");
        double e = scanner.nextDouble();

        System.out.printf("ideal(x) = %.20f%n", Ideal(x));
        System.out.printf("function only with n(x) = %.20f%n", FunctionWithoutE(x, n));
        System.out.printf("function with e and n(x) = %.20f%n", function(x, n, e));
        System.out.printf("function with e/10 and n(x) = %.20f%n", FunctionWithSmallE(x, n, e));
    }
}