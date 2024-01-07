package ru.vsu.cs.course1.Task8;

public class Task {

    // Используем 4 маркера, которые будут означать границы для обхода массива
    // top = 0, down = rows - 1, left = 0, right = columns - 1
    // Еще заведем флаг dir(direction), который будет отвечать за направление движения
    // dir = 0 - движение вправо, dir = 1 - движение вниз, dir = 2 - движение влево, dir = 3 - движение вверх
    // В переменной cur(current) записывается каждый новый элемент, это необходимо для связи между разными обходами массива
    public static boolean spiralArray(int[][] arr) {
        int rows = arr.length;
        int columns = arr[0].length;

        int x = 0;
        int y = 0;
        int borderX = rows;
        int borderY = columns;
        int dir = 0;

        boolean inc = true;
        boolean dec = true;

        int[][] dirs = new int[][]{
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1},
        };
        int [][] border = new int[][]{
                {1,0,0,0},
                {0,1,0,0},
                {0,0,-1,0},
                {0,0,0,-1},
        };

        for (int i = 0; i < rows * columns - 1; i++) {
            int cur = arr[y][x];
            if (x == borderX){
                borderX += border[dir][0];
                dir = (dir + 1) % 4;
            }
            if (y == borderY){
                borderY += border[dir][1];
                dir = (dir + 1) % 4;
            }
            x += dirs[dir][0];
            y += dirs[dir][1];
            if (!(cur < arr[y][x]) && inc) {
                inc = false;
            }
            if (!(cur > arr[y][x]) && dec) {
                dec = false;
            }

        } return inc || dec;
    }
}