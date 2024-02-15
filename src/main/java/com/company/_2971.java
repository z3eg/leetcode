package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _2971 {
    /*Wrong Answer
918 / 980 testcases passed*/
    /*public long largestPerimeter(int[] nums) {
        int totalSum = 0;
        for (int n : nums) {
            totalSum+=n;
        }
        int sidesLeft = nums.length;
        while (sidesLeft > 2) {
            long max = -1;
            int maxPos = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    maxPos = i;
                }
            }
            totalSum -= max;
            if (max < totalSum)
                return max+totalSum;
            nums[maxPos] = -1;
            sidesLeft--;
        }
        return -1;
    }*/

    /*1
ms
Beats
100.00%
of users with Java*/
    public long largestPerimeter(int[] nums) {
        long totalSum = 0;
        for (int n : nums) {
            totalSum+=n;
        }
        int sidesLeft = nums.length;
        while (sidesLeft > 2) {
            long max = -1;
            int maxPos = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    maxPos = i;
                }
            }
            totalSum -= max;
            if (max < totalSum)
                return max+totalSum;
            nums[maxPos] = -1;
            sidesLeft--;
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(17876942274L, largestPerimeter(new int[]{300005055,352368231,311935527,315829776,327065463,388851949,319541150,397875604,311309167,391897750,366860048,359976490,325522439,390648914,359891976,369105322,350430086,398592583,354559219,372400239,344759294,379931363,308829137,335032174,336962933,380797651,378305476,336617902,393487098,301391791,394314232,387440261,316040738,388074503,396614889,331609633,374723367,380418460,349845809,318514711,308782485,308291996,375362898,397542455,397628325,392446446,368662132,378781533,372327607,378737987}));
        assertEquals(15, largestPerimeter(new int[]{5,5,5}));
        assertEquals(12, largestPerimeter(new int[]{1,12,1,2,5,50,3}));
        assertEquals(-1, largestPerimeter(new int[]{5,5,50}));
    }
}
