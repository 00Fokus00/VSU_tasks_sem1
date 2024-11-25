package ru.vsu.cs.course1.Task10_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task {
    public static class SegmentPair {
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
            } else if(arr[i][1] >= arr[i][0] && arr[i + 1][1] >= arr[i + 1][0]){
                curMax = arr[i + 1][1] - arr[i + 1][0] + arr[i][1] - arr[i][0];
                if (curMax > max){
                    max = curMax;
                    result.clear();
                    result.add(0, new SegmentPair(arr[i][0], arr[i][1]));
                    result.add(1, new SegmentPair(arr[i + 1][0], arr[i + 1][1]));
                }
            }
        }return result;
    }
}
