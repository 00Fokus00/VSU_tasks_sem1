package ru.vsu.cs.course1.Task4_30;

import java.util.Scanner;

public class Task4_30 {

    public static boolean check(int x){
        int countChet = 0;
        int countNeChet = 0;
        while (x > 0){
            if (x % 2 == 0){
                countChet++;
            } else {
                countNeChet++;
            }
            x = x / 10;
        }
        return countChet == countNeChet;
    }

    public static int solve(int a, int b){
        int summ = 0;
        for (int i = a; i <= b; i++) {
            if (check(i)) {
            summ += i;
            }
        }
        return summ;
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число:");
        int a = scanner.nextInt();
        System.out.print("Введите второе число:");
        int b = scanner.nextInt();

        System.out.printf("Сумма равна: %s", solve(a, b));
    }
}
