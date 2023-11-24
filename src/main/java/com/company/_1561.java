package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/*1561. Maximum Number of Coins You Can Get
        https://leetcode.com/problems/maximum-number-of-coins-you-can-get/*/
public class _1561 {

    /*
        Runtime
        31 ms
        Beats
        98.17%
    */

    /*27
    ms
    Beats
    98.94%
    of users with Java*/
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int l = 0;
        int res = 0;
        int r = piles.length-1;
        while (l<r) {
            r--;
            res+=piles[r];
            r--;
            l++;
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(9, maxCoins(new int[]{2,4,1,2,7,8}));
        assertEquals(4, maxCoins(new int[]{2,4,5}));
        assertEquals(18, maxCoins(new int[]{9,8,7,6,5,1,2,3,4}));
    }
}
