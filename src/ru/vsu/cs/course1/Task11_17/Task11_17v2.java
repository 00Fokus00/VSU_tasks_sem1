package ru.vsu.cs.course1.Task11_17;

import java.util.Scanner;

import static java.lang.Character.*;

public class Task11_17v2 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String inputText = scanner.nextLine();
            String result = reverseWords(inputText);
            System.out.println(result);
        }

        private static String reverseWords(String input) {
            StringBuilder result = new StringBuilder();
            StringBuilder currentWord = new StringBuilder();

            for (char c : input.toCharArray()) {
                if (isLetterOrDigit(c)) {
                    currentWord.append(c);
                } else {
                    result.append(reverseString(currentWord.toString())).append(c); //обрабатываем текущее слово и добавляем символ
                    currentWord.delete(0, currentWord.length());
                }
            }
            result.append(reverseString(currentWord.toString())); // обработка последнего слова
            return result.toString();
        }

        private static String reverseString(String s) {
            StringBuilder sb = new StringBuilder(s);
            return sb.reverse().toString();
        }
}
