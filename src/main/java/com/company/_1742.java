package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*1742. Maximum Number of Balls in a Box
        https://leetcode.com/problems/maximum-number-of-balls-in-a-box/*/
public class _1742 {
    /*15ms
    Beats 75.29%of users with Java*/
    public int countBalls(int lowLimit, int highLimit) {
        int[] boxes = new int[46];
        int max = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = sum(i);
            boxes[sum]++;
            max = Math.max(max,boxes[sum]);
        }
        return max;
    }

    private int sum(int i) {
        int sum = 0;
        while(i >=1 ) {
            sum+=i%10;
            i/=10;
        }
        return sum;
    }

    @Test
    public void testSum() {
        assertEquals(45, sum(99999));
        assertEquals(1, sum(100000));
        assertEquals(1, sum(1));
        assertEquals(1, sum(10));
        assertEquals(1, sum(100));
        assertEquals(1, sum(1000));
        assertEquals(2, sum(2));
        assertEquals(8, sum(26));
    }

    @Test
    public void test() {
        assertEquals(2, countBalls(1, 10));
        assertEquals(2, countBalls(5, 15));
    }
}
