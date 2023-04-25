package com.company;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/sort-the-people/
public class _2418_SortThePeople {

    /*public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        int nameLen = names.length;
        for (int i = 0; i < nameLen; i++) {
            map.put(heights[i], names[i]);
        }
        map.values().stream().toList().t
        return names;
    }

    @Test
    public void test() {
        sortPeople(new String[]{"Mary","John","Emma"}, new int[]{180,165,170});
    }
*/
    /*public String[] sortPeople(String[] names, int[] heights) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < heights.length-1; i++) {
                if (heights[i] < heights[i+1]) {
                    String name = names[i];
                    names[i] = names[i+1];
                    names[i+1] = name;
                    int height = heights[i];
                    heights[i] = heights[i+1];
                    heights[i+1] = height;
                    sorted=false;
                }
            }
        }
        return names;
    }*/
}
