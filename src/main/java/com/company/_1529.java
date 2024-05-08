package com.company;

import org.junit.jupiter.api.Test;

/*1529. Minimum Suffix Flips
        https://leetcode.com/problems/minimum-suffix-flips/*/
public class _1529 {

    /*5ms
    Beats 94.00%of users with Java*/
    public int minFlips(String target) {
        int res = target.startsWith("1")?1:0;
        char[] chars = target.toCharArray();
        for (int i = 0; i < chars.length-1; i++) {
            if (chars[i]!=chars[i+1])
                res++;
        }
        return res;
    }

    @Test
    public void test() {

    }
}
