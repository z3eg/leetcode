package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/hamming-distance/
public class _61_HammingDistance {
    /*1ms
    Beats 10.89%of users with Java*/
    public int hammingDistance(int x, int y) {
        String xBS = Integer.toBinaryString(x);
        String yBS = Integer.toBinaryString(y);
        int xLen = xBS.length();
        int yLen = yBS.length();
        String shortest;
        String longest;
        if (xLen > yLen) {
            shortest = yBS;
            longest = xBS;
        }
        else {
            shortest = xBS;
            longest = yBS;
        }
        shortest = addZeroes(shortest, longest.length()-shortest.length());
        int res = 0;
        for (int i = shortest.length()-1; i >= 0; i--) {
            if (shortest.charAt(i)!=longest.charAt(i))
                res++;
        }
        return res;
    }

    String addZeroes(String s, int zeroes) {
        return "0".repeat(Math.max(0, zeroes)) + s;
    }

    @Test
    public void test() {
        assertEquals(2, hammingDistance(1,4));
        assertEquals(1, hammingDistance(3,1));
    }
}
