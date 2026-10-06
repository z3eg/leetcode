package com.company;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/*2
ms
Beats
91.86%
*/
public class _238 {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int lProd = 1;
        int rp = nums.length-1;
        int rProd = 1;
        for (int i = 0; i <nums.length; i++) {
            left[i] = lProd;
            lProd*=nums[i];
            right[rp] = rProd;
            rProd*=nums[rp];
            rp--;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = left[i]*right[i];
        }
        return nums;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{24,12,8,6}, productExceptSelf(new int[]{1,2,3,4}));
        assertArrayEquals(new int[]{0,0,9,0,0}, productExceptSelf(new int[]{-1,1,0,-3,3}));
//        assertArrayEquals(new int[]{}, productExceptSelf(new int[]{}));
    }
}
