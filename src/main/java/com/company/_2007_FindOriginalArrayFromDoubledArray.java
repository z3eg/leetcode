package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/find-original-array-from-doubled-array/
public class _2007_FindOriginalArrayFromDoubledArray {

    public int[] findOriginalArray(int[] changed) {
        int length = changed.length;
        if (length % 2 != 0) {
            return new int[]{};
        }
        int halfLen = length / 2;
        int[] original = new int[halfLen];
        int index = 0;
//        Arrays.sort(changed);
        List<Integer> ints = Arrays.stream(changed).sorted().boxed().collect(Collectors.toList());
        for (int i = 0; i < changed.length; i++) {
            Iterator<Integer> iterator = ints.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
//                if (next==changed[i])
            }
        }
        return original;
    }

    //TLE
    /*public int[] findOriginalArray(int[] changed) {
        int length = changed.length;
        if (length%2!=0) {
            return new int[]{};
        }
        int halfLen = length/2;
        int[] original = new int[halfLen];
        int index = 0;
        Arrays.sort(changed);
        foo: for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < length; j++) {
                if (changed[j]==changed[i]*2) {
                    original[index] = changed[i];
                    changed[i] = Integer.MAX_VALUE;
                    changed[j] = Integer.MAX_VALUE;
                    index++;
                    if (index==halfLen)
                        return original;
                    continue foo;
                }
            }
        }
        return new int[]{};
    }*/

    @Test
    public void test() {
        assertArrayEquals(new int[]{2,4,8,10}, findOriginalArray(new int[]{4,4,16,20,8,8,2,10}));
        assertArrayEquals(new int[]{}, findOriginalArray(new int[]{6,3,0,1}));
        assertArrayEquals(new int[]{1,3,4}, findOriginalArray(new int[]{1,3,4,2,6,8}));
        assertArrayEquals(new int[]{}, findOriginalArray(new int[]{1}));
    }

}
