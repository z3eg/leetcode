package com.company;

import org.junit.jupiter.api.Test;
import scala.Int;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/contest/weekly-contest-355/problems/largest-element-in-an-array-after-merge-operations/
//6915. Largest Element in an Array after Merge Operations
public class W_355_2 {

    public long maxArrayValue(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int n : nums) {
            list.add(n);
        }
        boolean merged = true;
        while (merged) {
            merged = false;
            for (int i = list.size()-1; i > 0; i--) {
                if (list.get(i) >= list.get(i-1)) {
                    list.set(i, list.get(i) + list.get(i-1));
                    list.remove(i-1);
                    merged = true;
                    break;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i : list) {
            max = Math.max(max, i);
        }
        return max;
    }

    @Test
    public void test() {
        assertEquals(21, maxArrayValue(new int[]{2,3,7,9,3}));
        assertEquals(11, maxArrayValue(new int[]{5,3,3}));
    }
}
