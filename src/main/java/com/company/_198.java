package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _198 {
    public int rob(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, rob(nums, i, new boolean[nums.length], 0, 0));
        }
        return res;
    }

    public int rob(int[] nums, int h, boolean[] isRobbed, int curMoney, int maxMoney) {
        if (h>0 && isRobbed[h-1])
            return 0;
        if (h<nums.length-1 && isRobbed[h+1])
            return 0;
        curMoney+=nums[h];
        isRobbed[h]=true;
        for (int i = 0; i < nums.length; i++) {
            if (!isRobbed[i] && (i==0 || !isRobbed[i-1]) && (i==nums.length-1 || !isRobbed[i+1]))
                maxMoney = Math.max(curMoney, rob(nums, i, isRobbed, curMoney, maxMoney));
        }
        isRobbed[h] = false;
        return maxMoney;
    }

    @Test
    public void test() {
        assertEquals(4, rob(new int[]{1,2,3,1}));
        assertEquals(12, rob(new int[]{2,7,9,3,1}));
    }
}
