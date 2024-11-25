package ru.vsu.cs.course1.Task1_28;
import java.util.Locale;
import java.util.Scanner;

public class Task28 {
    public static double clock(double h1, double m1, double s1, double h2, double m2, double s2){
        double time = ((h2 + 24 - h1) * 3600) % 86400 + (m2 - m1) * 60 + (s2 - s1);
        return time;
    }

    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input h1:");
        double h1 = scanner.nextDouble();
        System.out.print("Input m1:");
        double m1 = scanner.nextDouble();
        System.out.print("Input s1:");
        double s1 = scanner.nextDouble();
        System.out.print("Input h2:");
        double h2 = scanner.nextDouble();
        System.out.print("Input m2:");
        double m2 = scanner.nextDouble();
        System.out.print("Input s2:");
        double s2 = scanner.nextDouble();

        double time = clock(h1, m1, s1, h2, m2, s2);

        System.out.printf("Seconds have passed:%.02f%n", time);
    }
}
