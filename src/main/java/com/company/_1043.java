package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _1043 {
    //completely misunderstood. contigious is the key
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int partitions = arr.length / k;
        int lastPartSize = arr.length % k;
        Arrays.sort(arr);
        int res = 0;
        for (int i = 1; i <= partitions; i++) {
            res+=arr[arr.length-i]*k;
        }
        res+=lastPartSize*arr[arr.length-partitions-1];
        return res;
    }

    @Test
    public void test() {
        assertEquals(83, maxSumAfterPartitioning(new int[]{1,4,1,5,7,3,6,1,9,9,3}, 4));
        assertEquals(84, maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10}, 3));
        assertEquals(1, maxSumAfterPartitioning(new int[]{1}, 1));
    }
}
