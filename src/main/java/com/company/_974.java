package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _974 {

    /*Time Limit Exceeded
70 / 73 testcases passed*/
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;
        for (int len = 1; len <= nums.length; len++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                sum+=nums[j];
            }
            if (sum%k==0)
                res++;
            for (int i = len; i < nums.length; i++) {
                sum+=nums[i];
                sum-=nums[i-len];
                if (sum%k==0)
                    res++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(7, subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));
        assertEquals(0, subarraysDivByK(new int[]{5}, 9));
    }

}
