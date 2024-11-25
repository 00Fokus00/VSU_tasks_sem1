package ru.vsu.cs.course1.Task10_4;

import java.util.*;

public class Test {
    static class SegmentPair {
        int x,y;
        SegmentPair(int xx, int yy){
            this.x = xx;
            this.y = yy;
        }
    }
    public static List<SegmentPair> solve(int[][] arr){
        int n = arr.length * arr[0].length;
        int max = 0;
        int curMax = 0;
        List<SegmentPair> result = new ArrayList<>(1);


        Arrays.sort(arr, Comparator.comparingInt(e -> e[0]));
        for (int i = 0; i < (n / 2) - 1; i++){
            if (arr[i][1] > arr[i + 1][0]){
                curMax = arr[i + 1][1] - arr[i][0];
                if (curMax > max){
                    max = curMax;
                    result.clear();
                    result.add(0, new SegmentPair(arr[i][0], arr[i + 1][1]));
                }
            } else {
                curMax = arr[i + 1][1] - arr[i + 1][0] + arr[i][1] - arr[i][0];
                if (curMax > max){
                    max = curMax;
                    result.clear();
                    result.add(0, new SegmentPair(arr[i][0], arr[i][1]));
                    result.add(1, new SegmentPair(arr[i + 1][0], arr[i + 1][1]));
                }
            }
        }System.out.println(max);
        return result;
    }

    public static void main (String[] args) {
        int [][] arr = new int[][]{
                /*{13,22},
                {7,13},
                {22,23},
                {12,99}*/
                {1,2},
                {12,15},
                {14,16},
                {10,9}
        };
        List<Task.SegmentPair> result = Task.solve(arr);
        int[][] array = new int[Task.solve(arr).size()][2];
        for (int i = 0; i < Task.solve(arr).size(); i++) {
            array[i][0] = result.get(i).x;
            array[i][1] = result.get(i).y;
        }
        System.out.println(Arrays.deepToString(array));
    }
}
