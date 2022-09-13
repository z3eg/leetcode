package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
public class _1304_FindNUniqueIntegersSumUpToZero {

    public int[] sumZero(int n) {
        if (n==1)
            return new int[]{0};
        int[] ints = new int[n];
        int mid = n / 2;
        int j = 1;
        for (int i = 0; j <= mid; i+=2) {
            ints[i] = j;
            ints[i+1] = -j;
            j++;
        }
        return ints;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(sumZero(4)));
        System.out.println(Arrays.toString(sumZero(5)));
        System.out.println(Arrays.toString(sumZero(6)));
    }
}
