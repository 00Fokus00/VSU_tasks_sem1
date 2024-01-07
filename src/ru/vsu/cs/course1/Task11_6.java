package ru.vsu.cs.course1;

import java.util.Scanner;

public class Task11_6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = inputDouble(scanner, "x = ");
        double e = inputDouble(scanner, "e = ");
        int n = inputInt(scanner, "n = ");


        if (Math.abs(x) > 1) { //R [-1; 1]
            return;
        }
        // n = число слагемых
        // x = аргумент
        // e = эпсилон (рекомендуется 1e-9)

        System.out.printf("arcsin(x)    = %.20f%n", arcsin(n, x));
        System.out.printf("arcsin2(x)   = %.20f%n", arcsin2(x, e));
        System.out.printf("arcsin3(x)   = %.20f%n", arcsin3(x, e));
        System.out.printf("Math.asin(x) = %.20f%n", Math.asin(x));

    }

    // ВЫЧИСЛЕНИЕ ARCSIN(X) ПО КОЛИЧЕСТВУ СЛАГАЕМЫХ
    public static double arcsin (long n, double x) {
        double mult = x; // сумма предыдущих слагаемых
        double num = x;  // последнее слагаемое
        long n1 = (n - 1) * 2; // поскольку шаг цикла = 2
        for (long i = 1; i <= n1; i += 2) {
            num *= (Math.pow(x, 2) * i * i) / ((i + 1) * (i + 2)); // домножаем предыдущее слагаемое
            mult += num; // прибавляем к общей сумме

            //System.out.println(num);
        }
        return mult;
    }

    //ВЫЧИСЛЕНИЕ ARCSIN(X), ПОКА СЛАГАЕМЫЕ > E
    public static double arcsin2 (double x, double e) {
        double mult = x;
        double num = x;
        for (long i = 1; ; i += 2) {

            num *= (Math.pow(x, 2) * i * i) / ((i + 1) * (i + 2));
            if (Math.abs(num) < e) {
                break;
            }
            mult += num;
            //System.out.println(num);

        }
        return mult;
    }

    //ВЫЧИСЛЕНИЕ ARCSIN(X), ПОКА СЛАГАЕМЫЕ > E/10
    public static double arcsin3 (double x, double e) {
        double mult = x;
        double num = x;
        for (long i = 1; ; i += 2) {
            num *= (Math.pow(x, 2) * i * i) / ((i + 1) * (i + 2));
            if (Math.abs(num) < e / 10) {
                break;
            }
            mult += num;
        }
        return mult;
    }

    public static double inputDouble (Scanner scanner, String text) {
        System.out.print(text);
        return scanner.nextDouble();
    }

    public static int inputInt (Scanner scanner, String text) {
        System.out.print(text);
        return scanner.nextInt();
    }
}
