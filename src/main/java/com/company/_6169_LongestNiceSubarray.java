package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/contest/weekly-contest-309/problems/longest-nice-subarray/
public class _6169_LongestNiceSubarray {
    public int longestNiceSubarray(int[] nums) {
        int longest = 1;
        int numLen = nums.length;
        List<Integer> ints;
        foo: for (int i = 0; i < numLen; i++) {
            ints = new LinkedList<>();
            ints.add(nums[i]);
            for (int j = i+1; j < numLen; j++) {
                int curNum = nums[j];
                for (Integer num: ints) {
                    if ((num & curNum) != 0) {
                        longest = Math.max(longest, ints.size());
                        continue foo;
                    }
                }
                ints.add(curNum);
            }
            longest = Math.max(longest, ints.size());
        }
        return longest;
    }

    @Test
    public void test() {
        assertEquals(3, longestNiceSubarray(new int[]{135745088,609245787,16,2048,2097152}));
        assertEquals(3, longestNiceSubarray(new int[]{1,3,8,48,10}));
        assertEquals(3, longestNiceSubarray(new int[]{744437702,379056602,145555074,392756761,560864007,934981918,113312475,1090,16384,33,217313281,117883195,978927664}));
        assertEquals(1, longestNiceSubarray(new int[]{3,1,5,11,13}));
    }
}
