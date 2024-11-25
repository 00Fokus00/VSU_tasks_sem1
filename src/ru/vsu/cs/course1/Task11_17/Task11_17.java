package ru.vsu.cs.course1.Task11_17;

import java.util.Scanner;

public class Task11_17 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        StringBuilder buffer = new StringBuilder();
        int charCount = 0;
        int numChar = 0;

        String symbols = str.replaceAll("[a-zA-ZА-Яа-я0-9\\s]", ""); //строка из символов изначального предложения
        String[] words = str.split("\\s+"); //массив отдельных слов
        for (String word: words) {
            if (word.matches("[a-zA-ZА-Яа-я0-9]+")){ //если слово состоит только из нужных символов, то просто добавляем обратную версию к результату
                result.append(new StringBuilder(word).reverse()).append(" ");
            }else{ //иначе проверяем каждый отдельный символ на соответствие, отделяя слово от впомогательных символов
                for (int i = 0; i < word.length(); i++){
                    if ((word.charAt(i) >= 48 && word.charAt(i) <= 57) || (word.charAt(i) >= 65 && word.charAt(i) <= 122) || (word.charAt(i) >= 1040 && word.charAt(i) <= 1103)){
                        charCount++;
                        buffer.append(word.charAt(i));
                    }
                }result.append(buffer.reverse());
                buffer.delete(0, buffer.length());
                for (int j = 0; j < word.length() - charCount; j++){ //возвращаем символы в соответствии с их колличеством
                    result.append(symbols.charAt(numChar));
                    numChar++;
                }charCount = 0;
                result.append(" ");
            }
        }System.out.print(result);
    }
}