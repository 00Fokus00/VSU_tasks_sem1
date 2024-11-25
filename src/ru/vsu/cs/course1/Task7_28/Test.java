package ru.vsu.cs.course1.Task7_28;

import static ru.vsu.cs.course1.Task7_28.Task7_28.PrintResult;

public class Test {
    public static void PrintTest(){

        int [][] arr = new  int [][]{
            {1, 2, 3, 4, 0, 1, 0, 5, 6, 0, 1, 0, 1},
            {4, 6, 1, 2, 1, 2, 3, 2, 3, 5, 4, 7, 4, 1, 5, 1, 5, 1, 6},
            {0, 0, 0, 0, 1, 0, 1, 0, 1, 0},
            {1, 2, 1, 2},
            {1},
            {5,6,5,6,0,1,6,7,6,7},
            {-9, -10, -9, -1, 2, 3},
            {1, 2, 1, 6, 7, 6},
            {1, 2, 1, 2, 1, 2, 1, 2},
            {1, 2, 1, 2, 4, 5, 4, 5, 7, 8, 7, 8, 7, 8, 7, 8, 7, 8, 7},
            {1, 2, 1, 2, 0, 8, 0, 8, 0, 8}
        };

        for (int i = 0; i < arr.length; i++){
            PrintResult(arr[i]);
        }
    }
}
