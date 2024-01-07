package ru.vsu.cs.course1.task9;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static List<Integer> solve(List<Integer> list){
        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer c : list){
            int value = counts.get(c) == null ? 0 : counts.get(c);
            counts.put(c, value + 1);
        }
        int maxValue = Collections.max(counts.values());
        /*System.out.println(counts);
        System.out.println(maxValue);*/
        Set<Integer> result = new HashSet<>();
        if (counts.containsValue(maxValue)) {
            for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
                if (entry.getValue() == maxValue){
                    result.add(entry.getKey());
                }
            }
        }List<Integer> resultList = new ArrayList<>(result);
        Collections.sort(resultList);
        return resultList;
    }

    public static void main(String[] args){
        List<Integer> array = new ArrayList<>(Arrays.asList(19, 12, 82, 8, 30, 80, 84, 68));
        System.out.print(solve(array));
    }
}
