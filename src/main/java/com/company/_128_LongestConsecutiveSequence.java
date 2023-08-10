package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.BitSet;
import java.util.HashSet;

//TODO
//https://leetcode.com/problems/longest-consecutive-sequence/
public class _128_LongestConsecutiveSequence {

    /*260ms
    Beats 36.77%of users with Java*/
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums)
            set.add(n);
        int maxLen = 1;
        for (int n : nums) {
            //is it a start of a sequence?
            if (!set.contains(n-1)) {
                int curLen = 1;
                while (set.contains(++n))
                    curLen++;
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }

    @Test
    public void test() {
        Assertions.assertEquals(2, longestConsecutive(new int[]{27,26}));
        Assertions.assertEquals(1, longestConsecutive(new int[]{53,26}));
        Assertions.assertEquals(1, longestConsecutive(new int[]{53}));
        Assertions.assertEquals(0, longestConsecutive(new int[]{}));
        Assertions.assertEquals(4, longestConsecutive(new int[]{100,4,200,1,3,2}));
        Assertions.assertEquals(9, longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

}
