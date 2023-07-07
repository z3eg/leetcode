package com.company;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertArrayEquals;

/*2670. Find the Distinct Difference Array
        https://leetcode.com/problems/find-the-distinct-difference-array/*/
public class _2670 {
    /*Runtime
    6 ms
    Beats
    93.82%*/
    public int[] distinctDifferenceArray(int[] nums) {
        int numLen = nums.length;
        int[] lefts = new int[numLen];
        Set<Integer> leftSet = new HashSet<>();
        int[] rights = new int[numLen];
        Set<Integer> rightSet = new HashSet<>();
        for (int i = 0; i < numLen; i++) {
            leftSet.add(nums[i]);
            lefts[i] = leftSet.size();
            rightSet.add(nums[numLen -i-1]);
            rights[numLen -i-1] = rightSet.size();
        }
        int[] res = new int[numLen];
        for (int i = 0; i < numLen-1; i++) {
            res[i] = lefts[i] - rights[i+1];
        }
        res[numLen-1] = lefts[numLen-1];
        return res;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{1}, distinctDifferenceArray(new int[]{-2131}));
        assertArrayEquals(new int[]{1}, distinctDifferenceArray(new int[]{1}));
        assertArrayEquals(new int[]{-3,-1,1,3,5}, distinctDifferenceArray(new int[]{1,2,3,4,5}));
        assertArrayEquals(new int[]{-2,-1,0,2,3}, distinctDifferenceArray(new int[]{3,2,3,4,2}));
    }
}
