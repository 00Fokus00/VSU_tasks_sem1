package ru.vsu.cs.course1;

import java.util.Locale;
import java.util.Scanner;

public class Task13_2 {
    public static double getT(double Q, double t0, double m1) {
        double c = 4200;
        double t = Q / (c * m1) + t0;
        return t;
    }
    public static double getM(double Q, double m1) {
        double L = 2300000;
        double m2 = Q / L;
        double m = m1 - m2;
        return m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(Locale.ROOT);
        String blue = "\u001B[34m";
        System.out.println(blue + "Все значения представлены в системе СИ");
        System.out.println(blue + "Введите значение Q= ");
        double Q = scanner.nextDouble();
        System.out.println(blue + "Введите значение t0= ");
        double t0 = scanner.nextDouble();
        System.out.println(blue + "Введите значение m1= ");
        double m1 = scanner.nextDouble();

        double t = getT(Q, t0, m1);
        double m = getM(Q, m1);

        System.out.println(blue + "Ответ: ");
        if (t < 100) {
            System.out.println(blue + "Конечная температура менее 100°C");
            System.out.println(blue + "Температура t = " + t);
        } else if ((t == 100) && (m != 0)) {
            System.out.println(blue + "Конечная температура равна 100°C и оставшаяся масса воды= " + m);
        } else if ((t == 100) && (m1 == 0)) {
            System.out.println(blue + "Конечная температура равна 100°C и вся вода испарилась");
        }
    }
}


