package com.company;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _219 {

    /*Wrong Answer
16 / 58 testcases passed*/
    /*public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.remove(nums[i-k]);
            set.add(nums[i]);
        }
        return false;
    }*/


    /*Runtime Error
18 / 58 testcases passed*/
    /*public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k==0)
            return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.remove(nums[i-k]);
            set.add(nums[i]);
        }
        return false;
    }*/

    /*19
    ms
            Beats
36.70%
    of users with Java*/
    /*17
    ms
            Beats
75.11%
    of users with Java*/
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k==0)
            return false;
        if (k>nums.length)
            k=nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.remove(nums[i-k]);
            set.add(nums[i]);
        }
        return false;
    }


    @Test
    public void test() {
        assertTrue(containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        assertTrue(containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        assertFalse(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }
}
