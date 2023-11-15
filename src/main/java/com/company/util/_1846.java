package com.company.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _1846 {
//    46 / 49 testcases passed
    /*public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int max = 0;
        for (int a : arr) {
            max = Math.max(a, max);
        }
        return Math.min(max, arr.length);
    }*/


//18 / 49 testcases passed TLE
    /*public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            while (arr[i] - arr[i-1] > 1)
                arr[i]--;
        }
        return arr[arr.length-1];
    }*/

//    6ms
//    Beats 82.14%of users with Java
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0]=1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]>arr[i-1])
                arr[i] = arr[i-1]+1;
        }
        return arr[arr.length-1];
    }

    @Test
    public void test() {
        assertEquals(2, maximumElementAfterDecrementingAndRearranging(new int[]{2,2,1,2,1}));
        assertEquals(3, maximumElementAfterDecrementingAndRearranging(new int[]{100,1,1000}));
        assertEquals(5, maximumElementAfterDecrementingAndRearranging(new int[]{1,2,3,4,5}));
    }
}
