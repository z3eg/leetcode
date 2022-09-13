package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class _6171_FindSubarraysWithEqualSum {

    public boolean findSubarrays(int[] nums) {
        int[] sums = new int[nums.length-1];
        int sumLen = sums.length;
        for (int i = 0; i < sumLen; i++) {
            sums[i] = nums[i]+nums[i+1];
        }
        Arrays.sort(sums);
        for (int i = 0; i < sumLen-1; i++) {
            if (sums[i]==sums[i+1])
                return true;
        }
        return false;
    }

    @Test
    public void test() {
        assertTrue(findSubarrays(new int[]{4,2,4}));
        assertFalse(findSubarrays(new int[]{1,2,3,4,5}));
        assertTrue(findSubarrays(new int[]{0,0,0}));
    }
}
