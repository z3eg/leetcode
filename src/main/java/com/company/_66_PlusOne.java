package com.company;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/plus-one/
public class _66_PlusOne {

    public int[] plusOne(int[] digits) {
        int digiLen = digits.length;
        int lastDig = digits[digiLen - 1];
        if (lastDig != 9) {
            digits[digiLen-1]++;
            return digits;
        }
        int backCounter = digiLen-1;
        while (digits[backCounter]==9) {
            digits[backCounter]=0;
            backCounter--;
            if (backCounter==-1) {
                int[] newArr = new int[digits.length+1];
                newArr[0] = 1;
                System.arraycopy(digits, 0, newArr, 1, digits.length);
                return newArr;
            }
        }
        digits[backCounter]++;
        return digits;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{9,0,0,0}, plusOne(new int[]{8,9,9,9}));
        assertArrayEquals(new int[]{1,2,4}, plusOne(new int[]{1,2,3}));
        assertArrayEquals(new int[]{4,3,2,2}, plusOne(new int[]{4,3,2,1}));
        assertArrayEquals(new int[]{1,0}, plusOne(new int[]{9}));
    }
}
