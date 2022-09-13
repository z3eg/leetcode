package com.company;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

//https://leetcode.com/problems/decompress-run-length-encoded-list/
public class _1313_DecompressRunLengthEncodedList {

    //TODO optimize
    public int[] decompressRLElist(int[] nums) {
        LinkedList<Integer> integers = new LinkedList<>();
        for (int i = 0; i < nums.length; i+=2) {
            for (int j = 0; j < nums[i]; j++) {
                integers.add(nums[i+1]);
            }
        }
        int[] array = new int[integers.size()];
        for(int i = 0; i < integers.size(); i++) array[i] = integers.get(i);
        return array;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{2,4,4,4}, decompressRLElist(new int[]{1,2,3,4}));
        assertArrayEquals(new int[]{1,3,3}, decompressRLElist(new int[]{1,1,2,3}));
    }
}
