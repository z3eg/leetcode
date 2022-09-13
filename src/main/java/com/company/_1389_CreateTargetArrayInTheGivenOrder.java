package com.company;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

//https://leetcode.com/problems/create-target-array-in-the-given-order/
public class _1389_CreateTargetArrayInTheGivenOrder {
    //1ms
    public int[] createTargetArray(int[] nums, int[] index) {
        LinkedList<Integer> integers = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            integers.add(index[i],nums[i]);
        }
        int[] ints = new int[integers.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = integers.get(i);
        }
        return ints;
    }

    //2ms
    /*public int[] createTargetArray(int[] nums, int[] index) {
        LinkedList<Integer> integers = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            integers.add(index[i],nums[i]);
        }
        int[] ints = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = iterator.next();
        }
        return ints;
    }*/

    @Test
    public void test() {
        assertArrayEquals(new int[]{0,4,1,3,2}, createTargetArray(new int[]{0,1,2,3,4}, new int[]{0,1,2,2,1}));
        assertArrayEquals(new int[]{0,1,2,3,4}, createTargetArray(new int[]{1,2,3,4,0}, new int[]{0,1,2,3,0}));
    }
}
