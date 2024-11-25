package ru.vsu.cs.course1.Task9_20;

import java.util.*;

public class Task {
    public static List<Integer> createNewList(List<Integer> list){
        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer c : list){
            int value = counts.get(c) == null ? 0 : counts.get(c);
            counts.put(c, value + 1);
        }
        int maxValue = Collections.max(counts.values());
        Set<Integer> result = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == maxValue){
                result.add(entry.getKey());
            }
        }
        List<Integer> resultList = new ArrayList<>(result);
        Collections.sort(resultList);
        return resultList;
    }
}
