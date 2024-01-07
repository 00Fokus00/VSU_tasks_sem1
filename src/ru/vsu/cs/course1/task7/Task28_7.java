package ru.vsu.cs.course1.task7;

import java.util.Arrays;
import java.util.Locale;
import static ru.vsu.cs.course1.task7.Test.PrintTest;

public class Task28_7 {

    public static class SubSequence {
        int first, length;
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        PrintTest();

        int[] arr = ru.vsu.cs.util.ArrayUtils.readIntArrayFromConsole();
        PrintResult(arr);
    }

    public static SubSequence solution(int[] array){
        SubSequence r = new SubSequence();
        int curLength = 0;
        r.length = 0;
        int sfrLength = 0; //Second From Right Length
        int sfrindex = 0; //Second From Right Index

        for (int i = 2; i <= array.length; i++) {
            int value = i < array.length ? array[i] : array[i - 2] - 1;
            if (value == array[i - 2]) {
                curLength++;
            } else {
                curLength += 2;
                if (curLength >= r.length) {
                    sfrLength = r.length;
                    sfrindex = r.first;
                    r.length = curLength;
                    r.first = i - curLength + 1;
                }
                curLength = 0;
            }
        }
        if (sfrLength == r.length){
            r.first = sfrindex;
        }
        return r;
    }
    public static void PrintResult(int[] array) {
        SubSequence r = new SubSequence();
        System.out.println(Arrays.toString(array));
        r = solution(array);
        System.out.printf("Номер первого элемента: %s%n", r.first);
        System.out.printf("Кол-во элементов: %s%n", r.length);
        System.out.println("---------------------------------------------");
    }
}