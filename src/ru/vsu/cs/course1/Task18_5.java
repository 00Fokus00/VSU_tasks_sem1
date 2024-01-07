package ru.vsu.cs.course1;

import java.util.Scanner;

public class Task18_5 {
    private static void draw(char start, char end, char LeftChar, char RightChar, int left, int right) {
        System.out.print(start);
        for (int i = 1; i <= left; i++) {
            System.out.print(LeftChar);
        }
        for (int i = 1; i <= right; i++) {
            System.out.print(RightChar);
        }
        System.out.println(end);
    }

    public static void drawing(int w, int h) {
        int left = (w - 2) / 2;
        int right = w - left - 2;

        draw('+', '+', '-', '-', left, right);
        int repeat = 1;
        int row = 0;
        outer:
        for (;;) {
            for (int k = 0; k < repeat; k++) {
                if (row == h - 2) {
                    break outer;
                }
                draw('|', '|', '*', ' ', left, right);
                row++;
            }
            for (int k = 0; k < repeat; k++) {
                if (row == h - 2) {
                    break outer;
                }
                draw('|', '|', ' ', '*', left, right);
                row++;
            }
            repeat++;
        }
        draw('*', '*', '-', '-', left, right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ширину:");
        int a = scanner.nextInt();
        System.out.print("Введите высоту:");
        int b = scanner.nextInt();

        drawing(a,b);
    }
}
