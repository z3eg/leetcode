package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.Assert.assertArrayEquals;

//https://leetcode.com/problems/sliding-window-maximum/
public class _239 {
    /*Time Limit Exceeded
51 / 51 testcases passed
    Last Executed Input
            nums =*/
    /*public int[] maxSlidingWindow(int[] nums, int k) {
        int numLen = nums.length;
        int[] res = new int[numLen - k + 1];
        int max = nums[0];
        for (int i = 1; i < k; i++) {
            max = Math.max(max, nums[i]);
        }
        res[0] = max;
        int resLen = res.length;
        for (int i = 1; i < resLen; i++) {
            if (nums[i+k-1]>max) {
                max = nums[i+k-1];
            }
            else {
                if (max==nums[i-1]) {
                    //recount max
                    max = nums[i];
                    for (int j = i+1; j < i+k; j++) {
                        max = Math.max(max, nums[j]);
                    }
                }
            }
            res[i] = max;
        }
        return res;
    }*/

    public int[] maxSlidingWindow(int[] nums, int k) {
        int numLen = nums.length;
        int[] res = new int[numLen - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        return res;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{3,3,5,5,6,7}, maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));
        assertArrayEquals(new int[]{1}, maxSlidingWindow(new int[]{1}, 1));
    }
}
