package ru.vsu.cs.course1.Task2_23;

import java.util.Locale;
import java.util.Scanner;

public class Task2_23 {
    public static  int year(int y){
        if (((y % 4) == 0) && ((y % 100) != 0)){
            return 366;
        } else if (y % 400 == 0) {
            return 366;
        } else {
            return 365;
        }
    }
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите год:");
        int y = scanner.nextInt();

        int day = year(y);

        System.out.print("Дней всего: " + day);
    }
}
