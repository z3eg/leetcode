package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/number-of-1-bits/
public class _191_NumberOf1Bits {

    // you need to treat n as an unsigned value
    public int hammingWeight(long n) {
        int num = 0;
        while (n>=1) {
            num+=n%2;
            n/=2;
        }
        return num;
    }

    /*Example 1:

Input: n = 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
Example 2:

Input: n = 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.*/

    @Test
    public void test() {
        assertEquals(3,hammingWeight(00000000000000000000000000001011));
        assertEquals(1,hammingWeight(00000000000000000000000010000000));
//        assertEquals(31,hammingWeight(11111111111111111111111111111101));
    }

}
