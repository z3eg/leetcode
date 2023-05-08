package com.company;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/contest/biweekly-contest-103/problems/make-array-empty/
public class _6404_MakeArrayEmpty {
    public long countOperationsToEmptyArray(int[] nums) {
        int res = 0;
        List<Integer> numList = new LinkedList<>();
        List<Integer> sortedNumList = new LinkedList<>();
        for (int num : nums) {
            numList.add(num);
            sortedNumList.add(num);
        }
        Collections.sort(sortedNumList);
        while (!numList.isEmpty()) {
            res++;
            if (numList.get(0).equals(sortedNumList.get(0))) {
                numList.remove(0);
                sortedNumList.remove(0);

            }
            else {
                numList.add(numList.get(0));
                numList.remove(0);
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(1, countOperationsToEmptyArray(new int[]{0}));
        assertEquals(5, countOperationsToEmptyArray(new int[]{3,4,-1}));
        assertEquals(5, countOperationsToEmptyArray(new int[]{1,2,4,3}));
        assertEquals(3, countOperationsToEmptyArray(new int[]{1,2,3}));
        assertEquals(21, countOperationsToEmptyArray(new int[]{-315,180,-613,-886,-903,336,-463}));
    }
}
