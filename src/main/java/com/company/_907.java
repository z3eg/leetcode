package com.company;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class _907 {

    /*Wrong Answer
73 / 87 testcases passed*/
    /*public int sumSubarrayMins(int[] arr) {
        int MODULO = 1_000_000_000;
        int sum = 0;
        for (int len = 1; len <= arr.length; len++) {
            for (int start = 0; start <= arr.length - len; start++) {
                int min = arr[start];
                for (int i = start+1; i < start+len; i++) {
                    min = Math.min(min,arr[i]);
                }
                sum+=min;
            }
        }
        return sum%MODULO;
    }*/

    /*Time Limit Exceeded
    77 / 87 testcases passed*/
    public int sumSubarrayMins(int[] arr) {
        int MODULO = 1_000_000_007;
        int sum = 0;
        for (int len = 1; len <= arr.length; len++) {
            for (int start = 0; start <= arr.length - len; start++) {
                int min = arr[start];
                for (int i = start+1; i < start+len; i++) {
                    min = Math.min(min,arr[i]);
                }
                sum=(sum+min)%MODULO;
            }
        }
        return sum%MODULO;
    }

    @Test
    public void test() {
        assertEquals(17, sumSubarrayMins(new int[]{3,1,2,4}));
        assertEquals(444, sumSubarrayMins(new int[]{11,81,94,43,3}));
    }
}
