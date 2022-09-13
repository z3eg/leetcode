package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/split-a-string-in-balanced-strings/
public class _1221_SplitAStringInBalancedStrings {

    public int balancedStringSplit(String s) {
        int res = 0;
        int counter = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            switch (c) {
                case 'L' -> counter++;
                case 'R' -> counter--;
            }
            if (counter==0)
                res++;
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(4, balancedStringSplit("RLRRLLRLRL"));
        assertEquals(2, balancedStringSplit("RLRRRLLRLL"));
        assertEquals(1, balancedStringSplit("LLLLRRRR"));
    }

    /*Example 1:

Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
Example 2:

Input: s = "RLRRRLLRLL"
Output: 2
Explanation: s can be split into "RL", "RRRLLRLL", each substring contains same number of 'L' and 'R'.
Note that s cannot be split into "RL", "RR", "RL", "LR", "LL", because the 2nd and 5th substrings are not balanced.
Example 3:

Input: s = "LLLLRRRR"
Output: 1
Explanation: s can be split into "LLLLRRRR".*/
}
