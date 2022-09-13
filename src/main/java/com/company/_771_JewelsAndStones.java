package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/jewels-and-stones/
public class _771_JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        int counter = 0;
        char[] chars = jewels.toCharArray();
        for (char c : chars) {
            for (int i = 0; i < stones.length(); i++) {
                if (c==stones.charAt(i))
                    counter++;
            }
        }
        return counter;
    }

    @Test
    public void test() {
        assertEquals(3, numJewelsInStones("aA","aAAbbbb"));
        assertEquals(0, numJewelsInStones("z","ZZ"));
    }

    /*Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
Example 2:

Input: jewels = "z", stones = "ZZ"
Output: 0*/
}
