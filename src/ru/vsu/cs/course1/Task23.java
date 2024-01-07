package ru.vsu.cs.course1;
import java.util.Locale;
import java.util.Scanner;

public class Task23 {
    public static double first(double r2, double r1){
        double s = (Math.PI * Math.pow(r2,2) - Math.PI * Math.pow(r1,2)) / 2;
        return s;
    }
    public static double second(double r3){
        double s1 = (Math.pow(r3 * 2,2) - Math.PI * Math.pow(r3,2)) / 4;
        return s1;
    }

    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);

        String color = "\u001b[35m";

        System.out.print(color +"Input r1:");
        double r1 =scanner.nextDouble();
        System.out.print(color +"Input r2:");
        double r2 =scanner.nextDouble();
        System.out.print(color +"Input r3:");
        double r3 =scanner.nextDouble();
        double s = first(r2, r1) + second(r3);

        System.out.printf(color +"S=%.02f%n",s);

    }
}
