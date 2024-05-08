package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*2483. Minimum Penalty for a Shop
        https://leetcode.com/problems/minimum-penalty-for-a-shop/*/
public class _2483 {
    /*15ms
    Beats 42.09%of users with Java*/
    public int bestClosingTime(String customers) {
        int first = 0;
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i)=='Y')
                first++;
        }
        int min = first;
        int cur = first;
        int res = 0;
        for (int i = 1; i <= customers.length(); i++) {
            if (customers.charAt(i-1)=='N')
                cur++;
            if (customers.charAt(i-1)=='Y')
                cur--;
            if (cur < min) {
                min = cur;
                res = i;
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(2, bestClosingTime("YYNY"));
        assertEquals(0, bestClosingTime("NNNNN"));
        assertEquals(4, bestClosingTime("YYYY"));
    }
}
