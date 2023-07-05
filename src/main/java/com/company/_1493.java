package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*1493. Longest Subarray of 1's After Deleting One Element
        https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/*/
public class _1493 {

    //TLE at 73/74
    /*public int longestSubarray(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = 0;
            int left = i-1;
            int right = i+1;
            while (left >= 0 && nums[left]==1) {
                cur++;
                left--;
            }
            while (right < nums.length && nums[right]==1) {
                cur++;
                right++;
            }
            max = Math.max(max, cur);
        }
        return max;
    }*/


    //couldn't come up with a decent implementation
    /*public int longestSubarray(int[] nums) {
        int max = 0;
        //have 2 pointers counting at the same time. if u get 1 zero, u keep going, if u get 2nd - u break and compare with max
        return max;
    }*/

    /*Runtime
    3 ms
    Beats
    29.43%*/
    public int longestSubarray(int[] nums) {
        int max = 0;
        //make a list of 1-interval length. if there are more than 2 0s in a row add 0 to a list
        //count every [i] + [i+1]
        List<Integer> intervals = new LinkedList<>();
        int cur = 0;
        boolean zeeroesPresent = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                cur++;
            if (nums[i] == 0) {
                intervals.add(cur);
                cur = 0;
                zeeroesPresent = true;
            }
        }
        intervals.add(cur);
        if (intervals.size()==1) {
            return zeeroesPresent?intervals.get(0):intervals.get(0)-1;
        }
        for (int i = 0; i < intervals.size() - 1; i++) {
            max = Math.max(max, intervals.get(i) + intervals.get(i+1));
        }
        return max;
    }

    @Test
    public void test() {
        assertEquals(1, longestSubarray(new int[]{1,1}));
        assertEquals(9, longestSubarray(new int[]{1,1,1,1,1,1,0,1,1,1,0,1,1,1}));
        assertEquals(8, longestSubarray(new int[]{1,1,1,1,1,1,0,1,0,0,1,1,1,1,0,1,1,1,1}));
        assertEquals(8, longestSubarray(new int[]{1,1,1,1,0,1,1,1,1,0,0,1,1,1,1,1,1,0,1}));
        assertEquals(6, longestSubarray(new int[]{1,1,1,0,1,1,1,0,0,1,1,1,1,1}));
        assertEquals(6, longestSubarray(new int[]{1,1,1,1,1,1,0,0,1,1,1,0,1,1,1}));
        assertEquals(8, longestSubarray(new int[]{1,1,1,0,1,1,1,0,1,1,1,1,1}));
        assertEquals(5, longestSubarray(new int[]{1,1,1,1,1,0,0,1,1,1,1}));
        assertEquals(5, longestSubarray(new int[]{1,1,1,1,0,0,1,1,1,1,1}));
        assertEquals(4, longestSubarray(new int[]{1,1,1,1,0,0,1,1,1,1}));
        assertEquals(1, longestSubarray(new int[]{0,0,0,1,0,0,0}));
        assertEquals(1, longestSubarray(new int[]{0,1}));
        assertEquals(1, longestSubarray(new int[]{1,0}));
        assertEquals(0, longestSubarray(new int[]{1}));
        assertEquals(3, longestSubarray(new int[]{1,1,0,1}));
        assertEquals(5, longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
        assertEquals(2, longestSubarray(new int[]{1,1,1}));
    }
}
