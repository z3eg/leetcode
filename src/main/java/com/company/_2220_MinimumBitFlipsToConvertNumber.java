package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
public class _2220_MinimumBitFlipsToConvertNumber {

    //TODO optimize
    public int minBitFlips(int start, int goal) {
        int res = 0;
        String startBin = Integer.toBinaryString(start);
        String goalBin = Integer.toBinaryString(goal);
        String startFormatted = String.format("%32s", startBin).replaceAll(" ", "0");
        String goalFormatted = String.format("%32s", goalBin).replaceAll(" ", "0");
        for (int i = 0; i < startFormatted.length(); i++) {
            if (startFormatted.charAt(i)!=goalFormatted.charAt(i))
                res++;
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(3,minBitFlips(10,7));
        assertEquals(3,minBitFlips(3,4));
    }

    /*Example 1:

Input: start = 10, goal = 7
Output: 3
Explanation: The binary representation of 10 and 7 are 1010 and 0111 respectively. We can convert 10 to 7 in 3 steps:
- Flip the first bit from the right: 1010 -> 1011.
- Flip the third bit from the right: 1011 -> 1111.
- Flip the fourth bit from the right: 1111 -> 0111.
It can be shown we cannot convert 10 to 7 in less than 3 steps. Hence, we return 3.
Example 2:

Input: start = 3, goal = 4
Output: 3
Explanation: The binary representation of 3 and 4 are 011 and 100 respectively. We can convert 3 to 4 in 3 steps:
- Flip the first bit from the right: 011 -> 010.
- Flip the second bit from the right: 010 -> 000.
- Flip the third bit from the right: 000 -> 100.
It can be shown we cannot convert 3 to 4 in less than 3 steps. Hence, we return 3.
*/
}
