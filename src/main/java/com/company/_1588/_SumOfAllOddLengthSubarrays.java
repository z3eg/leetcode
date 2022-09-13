package com.company._1588;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
public class _SumOfAllOddLengthSubarrays {

    //TODO optimize this (can use already calculated arrays and just add new elements)
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int arrLen = arr.length;
        int[] lengths = new int[(int) Math.ceil((double) arrLen / 2)];
        lengths[0] = 1;
        int i = 1;
        int lenLen = lengths.length;
        while (i < lenLen) {
            lengths[i]+=lengths[i-1]+2;
            i++;
        }
        for (int length : lengths) {
            for (int k = 0; k < arrLen - length+1; k++) {
                int[] subArr = Arrays.copyOfRange(arr, k, k + length);
                sum += sumArr(subArr);
            }
        }
        return sum;
    }

    int sumArr(int[]arr) {
        int sum = 0;
        for (int i : arr) {
            sum+=i;
        }
        return sum;
    }

    @Test
    public void test() {
//        assertEquals(58, sumOddLengthSubarrays(new int[]{1,4,2,5,3,7}));
        assertEquals(58, sumOddLengthSubarrays(new int[]{1,4,2,5,3}));
        assertEquals(3, sumOddLengthSubarrays(new int[]{1,2}));
    }

    /*Example 1:

    Input: arr = [1,4,2,5,3]
    Output: 58
    Explanation: The odd-length subarrays of arr and their sums are:
            [1] = 1
            [4] = 4
            [2] = 2
            [5] = 5
            [3] = 3
            [1,4,2] = 7
            [4,2,5] = 11
            [2,5,3] = 10
            [1,4,2,5,3] = 15
    If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
    Example 2:

    Input: arr = [1,2]
    Output: 3
    Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.
    Example 3:

    Input: arr = [10,11,12]
    Output: 66*/
}
