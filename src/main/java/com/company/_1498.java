package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/*https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
        1498. Number of Subsequences That Satisfy the Given Sum Condition*/
public class _1498 {

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int[] p = new int[nums.length];
        p[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            p[i] = (p[i-1]*2)%1000000007;
        }
        int l = 0;
        int r = nums.length-1;
        int ans = 0;
        while (l<=r) {
            if (nums[l]+nums[r]<=target) {
                ans+=p[r-l];
                ans%=1000000007;
                l++;
            }
            else {
                r--;
            }
        }
        return ans;
    }

    @Test
    public void test() throws InterruptedException {
        assertEquals(4, numSubseq(new int[]{3,5,6,7}, 9));
        assertEquals(6, numSubseq(new int[]{3,3,6,8}, 10));
        assertEquals(61, numSubseq(new int[]{2,3,3,4,6,7}, 12));
    }
}
