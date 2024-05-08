package com.company;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/*1710. Maximum Units on a Truck
        https://leetcode.com/problems/maximum-units-on-a-truck/*/
public class _1710 {
    /*57ms
    Beats 5.08%of users with Java*/
    /*public int maximumUnits(int[][] boxTypes, int truckSize) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < boxTypes.length - 1; i++) {
                if (boxTypes[i][1] < boxTypes[i+1][1]) {
                    int[] tmp = boxTypes[i];
                    boxTypes[i] = boxTypes[i+1];
                    boxTypes[i+1] = tmp;
                    sorted = false;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (truckSize >= boxTypes[i][0]) {
                res+=boxTypes[i][0]*boxTypes[i][1];
                truckSize-=boxTypes[i][0];
            }
            else {
                res+=boxTypes[i][1]*truckSize;
                break;
            }
        }
        return res;
    }*/

    /*15ms
    Beats 18.52%of users with Java*/
    /*public int maximumUnits(int[][] boxTypes, int truckSize) {
        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (int[] type : boxTypes) {
            Integer val = map.get(type[1]);
            if (val==null)
                val = 0;
            val+=type[0];
            map.put(type[1], val);
        }
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        int res = 0;
        while (it.hasNext()) {
            if (truckSize == 0)
                return res;
            Map.Entry<Integer, Integer> next = it.next();
            if (truckSize >= next.getValue()) {
                res+=next.getKey()*next.getValue();
                truckSize-=next.getValue();
            }
            else {
                res+=next.getKey()*truckSize;
                truckSize = 0;
            }
        }
        return res;
    }*/

    /*16ms
    Beats 17.90%of users with Java*/
    /*public int maximumUnits(int[][] boxTypes, int truckSize) {
        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (int[] type : boxTypes) {
            Integer val = map.get(type[1]);
            if (val==null)
                val = 0;
            val+=type[0];
            map.put(type[1], val);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> next : map.entrySet()) {
            if (truckSize == 0)
                return res;
            if (truckSize >= next.getValue()) {
                res+=next.getKey()*next.getValue();
                truckSize-=next.getValue();
            }
            else {
                res+=next.getKey()*truckSize;
                truckSize = 0;
            }
        }
        return res;
    }*/

    /*2ms
    Beats 98.01%of users with Java*/
//    had to look this one up :(
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int res = 0;
        int[] capNums = new int[1001];
        for (int[] type : boxTypes) {
            capNums[type[1]]+=type[0];
        }
        for (int i = capNums.length-1; i >= 0; i--) {
            if (truckSize >= capNums[i]) {
                res+=capNums[i]*i;
                truckSize-=capNums[i];
            }
            else {
                res+=truckSize*i;
                return res;
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(91, maximumUnits(new int[][]{{5,10},{2,5},{4,7},{3,9}}, 10));
        assertEquals(8, maximumUnits(new int[][]{{1,3},{2,2},{3,1}}, 4));
        assertEquals(8, maximumUnits(new int[][]{{1,3},{2,2},{3,1}}, 4));
        assertEquals(20, maximumUnits(new int[][]{{5,10},{2,5},{4,7},{3,9}}, 2));
        assertEquals(18, maximumUnits(new int[][]{{2,5},{4,7},{3,9}}, 2));
        assertEquals(10, maximumUnits(new int[][]{{2,5}}, 5));
        assertEquals(5, maximumUnits(new int[][]{{2,5}}, 1));
    }
}
