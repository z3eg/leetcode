package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.BitSet;

//TODO
//https://leetcode.com/problems/longest-consecutive-sequence/
public class _128_LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        BitSet leftBitSet = new BitSet();
        BitSet bitSet = new BitSet();
        for (int num : nums) {
            if (num < 0) {
                leftBitSet.set(Integer.MAX_VALUE - num);
            }
            else {
                bitSet.set(num);
            }
        }
        boolean setBits = true;
        int longest = 0;
        int curBit = leftBitSet.nextSetBit(Integer.MIN_VALUE);
        while (curBit!=Integer.MAX_VALUE) {
            if (setBits) {
                int nextClearBit = leftBitSet.nextClearBit(curBit);
                longest = Math.max(longest,nextClearBit-curBit);
                curBit = nextClearBit;
                setBits=false;
            }
            else {
                curBit = leftBitSet.nextSetBit(curBit);
                setBits=true;
            }
        }
        while (curBit!=Integer.MAX_VALUE) {
            if (setBits) {
                int nextClearBit = bitSet.nextClearBit(curBit);
                longest = Math.max(longest,nextClearBit-curBit);
                curBit = nextClearBit;
                setBits=false;
            }
            else {
                curBit = bitSet.nextSetBit(curBit);
                setBits=true;
            }
        }
        return longest;
    }

    /*Example 1:

    Input: nums = [100,4,200,1,3,2]
    Output: 4
    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
    Example 2:

    Input: nums = [0,3,7,2,5,8,4,6,0,1]
    Output: 9


    Constraints:

    0 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9*/

    @Test
    public void test() {
        Assertions.assertEquals(4, longestConsecutive(new int[]{100,4,200,1,3,2}));
        Assertions.assertEquals(9, longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

}
