package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.lang.Math.*;

import static org.junit.Assert.assertEquals;

public class _3727 {

    /*31
ms
Beats
93.66%
*/
    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i]*=nums[i];
        }
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length-1;
        long res = 0;
        boolean rTurn = true;
        while (l<=r) {
            if (rTurn) {
                res+=nums[r];
                r--;
            }
            else {
                res-=nums[l];
                l++;
            }
            rTurn=!rTurn;
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(12, maxAlternatingSum(new int[]{1,2,3}));
        assertEquals(16, maxAlternatingSum(new int[]{1,-1,2,-2,3,-3}));
    }
}
