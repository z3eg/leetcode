package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/*215. Kth Largest Element in an Array
        https://leetcode.com/problems/kth-largest-element-in-an-array/*/
public class _215 {

    /*3ms
    Beats 99.51%of users with Java*/
    public int findKthLargest(int[] nums, int k) {
        int[] freqs = new int[20001];
        for (int n : nums)
            freqs[n+10000]++;
        int i;
        for (i = freqs.length-1; i > 0 && k >= 1; i--) {
            if (freqs[i]!=0)
                k-=freqs[i];
            if (k<=0)
                return i-10000;
        }
        return i-10000;
    }

    @Test
    public void test() {
        assertEquals(1, findKthLargest(new int[]{1}, 1));
        assertEquals(5, findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        assertEquals(4, findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
