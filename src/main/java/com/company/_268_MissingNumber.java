package com.company;

import org.junit.Test;

import java.util.BitSet;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/missing-number/
public class _268_MissingNumber {

    //even worse lol
    public int missingNumber(int[] nums) {
        BitSet bitSet = new BitSet(nums.length+1);
        for (int num : nums) {
            bitSet.set(num);
        }
        return bitSet.nextClearBit(0);
    }

    //not fast enough
    /*public int missingNumber(int[] nums) {
        int[] ints = new int[nums.length + 1];
        for (int num : nums) {
            ints[num] = num;
        }
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] == 0) {
                return i;
            }
        }
        return 0;
    }*/

    /*Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.*/

    @Test
    public void test() {
        assertEquals(2,missingNumber(new int[]{3,0,1}));
        assertEquals(2,missingNumber(new int[]{0,1}));
        assertEquals(8,missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}
