package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//https://leetcode.com/problems/arithmetic-subarrays/
public class _1630_ArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        LinkedList<Boolean> res = new LinkedList<>();
        for (int i = 0; i < l.length; i++) {
            res.add(canBeArithmeticArray(Arrays.copyOfRange(nums, l[i], r[i]+1)));
        }
        return res;
    }

    private boolean canBeArithmeticArray(int[] arr) {
        int maxVal = Integer.MIN_VALUE;
        int maxValPos = 0;
        for (int i = 0; i < arr.length; i++) {
            if (maxVal < arr[i]) {
                maxVal = arr[i];
                maxValPos = i;
            }
        }
        Set<Integer> set = new TreeSet<>();
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (i == maxValPos)
                continue;
            int diff = maxVal - arr[i];
            set.add(diff);
            minDiff = Math.min(minDiff, diff);
        }
        if (minDiff==0) {
            return set.size() == 1;
        }
        if (set.size()!=arr.length-1)
            return false;
        int index = 0;
        for (int cur : set) {
            index++;
            if (cur != minDiff * index)
                return false;
        }
        return true;
    }

    /*Runtime
19 ms
            Beats
86.13%
*/
    /*private boolean canBeArithmeticArray(int[] arr) {
        Arrays.sort(arr);
        int firstDiff = arr[1]-arr[0];
        for (int i = 1; i < arr.length-1; i++) {
            if (arr[i+1]-arr[i]!=firstDiff)
                return false;
        }
        return true;
    }*/

    @Test
    public void test() {
        assertFalse(canBeArithmeticArray(new int[]{10,20,15,-2}));
        assertFalse(canBeArithmeticArray(new int[]{-6,-3,0,0}));
        assertTrue(canBeArithmeticArray(new int[]{5,9,3,7}));
        checkArithmeticSubarrays(new int[]{4,6,5,9,3,7}, new int[]{0,0,2}, new int[]{2,3,5});
        assertFalse(canBeArithmeticArray(new int[]{4,6,5,9}));
        assertTrue(canBeArithmeticArray(new int[]{0,0,0,0}));
        assertTrue(canBeArithmeticArray(new int[]{4,6,5}));
        assertFalse(canBeArithmeticArray(new int[]{4,6,5,9}));
    }

    /*@Test
    public void test() {
        assertArrayEquals(new boolean[]{true,false,true}, checkArithmeticSubarrays(new LinkedList))
    }*/

}
