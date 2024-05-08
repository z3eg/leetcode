package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _2958 {

    //shrinking sliding window going back and forth?
    /*public int maxSubarrayLength(int[] nums, int k) {
        int max = 1;
        for (int i : nums) {
            max = Math.max(i, max);
        }
        int window = 1;
        int l = -1;
        int r = -1;
        int maxOcc = 0;
        int res = 0;
        while (window <= nums.length) {
            //going right
            while (r < nums.length-1) {
                r++;
                if (nums[r] == max) {
                    maxOcc++;
                }
                if (maxOcc>=k) {
                    res++;
                }
                if (l < nums.length-window) {
                    l++;
                    if (nums[l] == max) {
                        maxOcc--;
                    }
                }
            }
            window++;
            if (window == nums.length)
                return res+((nums[l-1]==max)?1:0);
            //going left
            while (l > 0) {
                l--;
                if (nums[l] == max) {
                    maxOcc++;
                }
                if (maxOcc>=k) {
                    res++;
                }
                if (r > window-1) {
                    r--;
                    if (nums[r] == max) {
                        maxOcc--;
                    }
                }
            }
            window++;
        }
        return res;
    }*/

    public int maxSubarrayLength(int[] nums, int k) {
        int max = 1;
        for (int i : nums) {
            max = Math.max(i, max);
        }
        int window = 1;
        int l = -1;
        int r = 0;
        int maxOcc = 0;
        int res = 0;
        while (window <= nums.length) {
            //going right
            while (r < nums.length) {
                if (nums[r] == max) {
                    maxOcc++;
                }
                if (maxOcc>=k) {
                    res++;
                }
                l++;
                if (nums[l] == max) {
                    maxOcc--;
                }
                r++;
            }
            if (nums[l] == max) {
                maxOcc++;
            }
            l--;
            window++;
            if (window>=nums.length)
                return res;
            //going left
            while (l >= 0) {
                if (nums[l] == max) {
                    maxOcc++;
                }
                if (maxOcc>=k) {
                    res++;
                }
                r--;
                if (nums[r] == max) {
                    maxOcc--;
                }
                l--;
            }
            if (nums[r] == max) {
                maxOcc++;
            }
            r++;
            window++;
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(5, maxSubarrayLength(new int[]{2,1,2}, 1));
        assertEquals(1, maxSubarrayLength(new int[]{2,1,2}, 2));
        assertEquals(6, maxSubarrayLength(new int[]{1,3,2,3,3}, 2));
        assertEquals(6, maxSubarrayLength(new int[]{1,4,2,1}, 2));
    }
}
