package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _1838 {
    /*103 ms
    Beats 5.14% of users with Java

    */
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int maxCount = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            if (i==nums.length-1 || (i<nums.length-1 && nums[i]!=nums[i+1])) {
                int count = 1;
                int tmpK = k;
                for (int j = i-1; j >= 0; j--) {
                    int curDiff = nums[i] - nums[j];
                    if (curDiff > tmpK) {
                        maxCount = Math.max(maxCount, count);
                        break;
                    }
                    else {
                        tmpK -= curDiff;
                        count++;
                    }
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }

    @Test
    public void test() {
        assertEquals(1, maxFrequency(new int[]{1,10}, 5));
        assertEquals(4, maxFrequency(new int[]{1,1,1,1}, 5));
        assertEquals(1, maxFrequency(new int[]{1}, 5));
        assertEquals(1, maxFrequency(new int[]{1}, 1));
        assertEquals(1, maxFrequency(new int[]{837}, 1));
        assertEquals(3, maxFrequency(new int[]{1,2,4}, 5));
        assertEquals(2, maxFrequency(new int[]{1,4,8,13}, 5));
        assertEquals(1, maxFrequency(new int[]{3,9,6}, 2));
    }
}
