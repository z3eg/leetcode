package com.company;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/*673. Number of Longest Increasing Subsequence
        https://leetcode.com/problems/number-of-longest-increasing-subsequence/*/
public class _673 {

    /*public int findNumberOfLIS(int[] nums) {
        TreeMap<Integer, Integer> lengthToNumer = new TreeMap<>(Comparator.reverseOrder());
        countFrom(nums, 1, lengthToNumer, 0, nums[0]);
        return lengthToNumer.entrySet().iterator().next().getValue();
    }

    void countFrom(int[] nums, int pos, Map<Integer,Integer> map, int curVal, int lastEl) {
        for (int i = pos; i < nums.length; i++) {
            if (nums[i] > lastEl) {
                curVal++;
                lastEl=curVal;
            }
            else {
                countFrom(nums, i+1, map, curVal, lastEl);
            }
            map.put(curVal, map.get(curVal)==null?1:map.get(curVal)+1);
        }
    }*/

    public int findNumberOfLIS(int[] nums) {
        List<Integer> integers = new LinkedList<>();
        for (int i : nums) {
            integers.add(i);
        }
        for (int i = 1; i < integers.size()-1; i++) {
            if (!(integers.get(i)>integers.get(i-1) && integers.get(i) < integers.get(i+1))) {
                integers.remove(i);
            }
        }
        return integers.size();
    }

    @Test
    public void test() {
        assertEquals(2, findNumberOfLIS(new int[]{1,3,5,4,7}));
        assertEquals(5, findNumberOfLIS(new int[]{2,2,2,2,2}));
    }
}
