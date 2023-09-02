package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*https://leetcode.com/contest/biweekly-contest-112/problems/maximum-sum-of-almost-unique-subarray/
        6989. Maximum Sum of Almost Unique Subarray*/
public class BW_112_3 {
    public long maxSum(List<Integer> nums, int m, int k) {
        return 0;
    }

    @Test
    public void test() {
        assertEquals(18, maxSum(Arrays.asList(2,6,7,3,1,7), 3, 4));
        assertEquals(23, maxSum(Arrays.asList(5,9,9,2,4,5,4), 1, 3));
        assertEquals(0, maxSum(Arrays.asList(1,2,1,2,1,2,1), 3, 3));
    }
}
