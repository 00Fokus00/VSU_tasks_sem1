package ru.vsu.cs.course1.Task3_55;

import java.util.Locale;
import java.util.Scanner;

import static ru.vsu.cs.course1.Task3_55.Picture.printColorForPoint;
import static ru.vsu.cs.course1.Task3_55.Test.printingTestPoints;

public class Main {

    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);

        printingTestPoints();

        System.out.print("Input х:");
        double x = readNumber();

        System.out.print("Input y:");
        double y = readNumber();

        printColorForPoint(x, y);
    }
    public static double readNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
}
