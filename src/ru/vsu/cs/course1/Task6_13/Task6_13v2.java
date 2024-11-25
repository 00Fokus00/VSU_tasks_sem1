package ru.vsu.cs.course1.Task6_13;

import java.util.Locale;
import java.util.Scanner;

public class Task6_13v2 {
    public static class Task6Result {
        double sn, se, s10;
        int n, ne, n10;
        double funcValue;
    }

    public static Task6Result calc(double x, int n, double e){
        Task6Result r = new Task6Result();
        double a = 1;

        for (int i = 0; i < n || Math.abs(a) > e / 10; i++){
            if (i < n) {
                r.sn += a;
                r.n++;
            }
            if (Math.abs(a) > e) {
                r.se += a;
                r.ne++;
            }
            if (Math.abs(a) > e / 10) {
                r.s10 += a;
                r.n10++;
            }
            a = getNextA(a, x, i);
        }
        r.funcValue = 1 / Math.pow(1 + x, 3);
        return r;
    }
    public static double getNextA(double a, double x, int i) {
        return - a * x / (i + 1) * (i + 3);
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

        Task6Result r = calc(x, n, e);

        System.out.printf("ideal(x) = %.20f%n", r.funcValue);
        System.out.printf("function with n(%d) = %.20f%n", r.n, r.sn);
        System.out.printf("function with e and n(%s) = %.20f%n", r.ne, r.se);
        System.out.printf("function with e/10 and n(%s) = %.20f%n", r.n10, r.s10);
    }
}