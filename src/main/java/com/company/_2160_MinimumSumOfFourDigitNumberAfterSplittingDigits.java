package com.company;

import org.junit.Test;

import java.util.Arrays;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/
public class _2160_MinimumSumOfFourDigitNumberAfterSplittingDigits {

    public int minimumSum(int num) {
        int[] array = new int[4];
        int counter = 0;
        while (num>=1) {
            array[counter] = num%10;
            num=num/10;
            counter++;
        }
        Arrays.sort(array);
        return (array[0]*10+array[2] + array[1]*10+array[3]);
    }

    @Test
    public void test() {
        assertEquals(52,minimumSum(2932));
        assertEquals(13,minimumSum(4009));
    }



    /*Example 1:

Input: num = 2932
Output: 52
Explanation: Some possible pairs [new1, new2] are [29, 23], [223, 9], etc.
The minimum sum can be obtained by the pair [29, 23]: 29 + 23 = 52.
Example 2:

Input: num = 4009
Output: 13
Explanation: Some possible pairs [new1, new2] are [0, 49], [490, 0], etc.
The minimum sum can be obtained by the pair [4, 9]: 4 + 9 = 13.*/
}
