package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*456. 132 Pattern
        https://leetcode.com/problems/132-pattern/description/?envType=daily-question&envId=2023-09-30*/
public class _456_132Pattern {

    public boolean find132pattern(int[] nums) {
        if (nums.length<3)
            return false;
        int l = 0;
        while (l < nums.length-1 && nums[l]>=nums[l+1])
            l++;
        for (int i = l; i < nums.length - 2; i++) {
            int m = l+1;
            while (m < nums.length-1 && nums[m]<=nums[m+1])
                m++;
            for (int j = m; j < nums.length - 1; j++) {
                if (nums[j] > nums[i]) {
                    int r = m+1;
                    while (r < nums.length-1 && nums[r]==nums[r+1])
                        r++;
                    for (int k = r; k < nums.length; k++) {
                        if (nums[k] < nums[j] && nums[k] > nums[i])
                            return true;
                    }
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        assertTrue(find132pattern(new int[]{-1,3,2,0}));
        assertFalse(find132pattern(new int[]{1}));
        assertFalse(find132pattern(new int[]{1,2}));
        assertFalse(find132pattern(new int[]{1,2,3,4}));
        assertTrue(find132pattern(new int[]{3,1,4,2}));
        assertFalse(find132pattern(new int[]{1,0,1,-4,-3}));
    }
}
