package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _525_ContiguousArray {

    public int findMaxLength(int[] nums) {
        int zeros = 0;
        int ones = 0;
        boolean isZero;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            }
            else {
                ones++;
            }
        }
        if (zeros==ones) {
            return nums.length;
        }
        else {
        }
        int halfMaxPosLen = Math.min(zeros, ones);
        return proceedWithMinority((zeros<ones),halfMaxPosLen, nums);
    }

    private int proceedWithMinority(boolean isZero, int halfMaxPosLen, int[] nums) {
        int amountOfMinorirySymbols = halfMaxPosLen;
        int minoroitySymbol = isZero ? 0 : 1;
        int maxLen = 0;
        int i = 0;
        while (nums[i]!=minoroitySymbol) {
            i++;
        }
        int j = 0;
        //first minority found
        while (i < nums.length && j < amountOfMinorirySymbols*2) {
            j++;
            if (nums[i]==minoroitySymbol) {
                amountOfMinorirySymbols--;
            }
        }
        return maxLen;
    }

    @Test
    public void test() {
        assertEquals(2, findMaxLength(new int[]{0,1}));
        assertEquals(2, findMaxLength(new int[]{0,1,0}));
    }

}
