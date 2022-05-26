package com.company;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/majority-element/
public class _169_MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int numLen = nums.length;
        double halfNumLen = (double) numLen / 2;
        for (int curEl : nums) {
            Integer curFreq = freqMap.get(curEl);
            if (curFreq == null) {
                curFreq = 0;
            }
            curFreq++;
            if (curFreq >= halfNumLen) {
                return curEl;
            }
            freqMap.put(curEl, curFreq);
        }
        return 0;
    }

    @Test
    public void test() {
        assertEquals(1, majorityElement(new int[]{1}));
        assertEquals(3, majorityElement(new int[]{3,2,3}));
        assertEquals(2, majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    /*Example 1:

    Input: nums = [3,2,3]
    Output: 3
    Example 2:

    Input: nums = [2,2,1,1,1,2,2]
    Output: 2*/
}
