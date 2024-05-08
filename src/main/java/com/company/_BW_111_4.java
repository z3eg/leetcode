package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/*8013. Number of Beautiful Integers in the Range
        https://leetcode.com/contest/biweekly-contest-111/problems/number-of-beautiful-integers-in-the-range/*/
public class _BW_111_4 {

    //TLE
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        int res = 0;
        while (low < high) {
            int lowDC = digCount(low);
            int tmpHigh;
            if (lowDC %2!=0) {
                low = (int) Math.pow(10, lowDC);
                tmpHigh = low*10;
            }
            else {
                tmpHigh = (int) Math.pow(10, lowDC);
            }
            tmpHigh = Math.min(tmpHigh, high);
            while (low%k!=0 && low <= tmpHigh) {
                low++;
            }
            while (low<=tmpHigh) {
                if (countsEqual(low))
                    res++;
                low+=k;
            }
        }
        return res;
    }
    int digCount(int num) {
        int res = 0;
        while (num>=1) {
            res++;
            num/=10;
        }
        return res;
    }
    boolean countsEqual(int num) {
        int oddCount = 0;
        int evenCount = 0;
        while (num>=1) {
            int nexDig = num%10;
            if (nexDig%2==0)
                evenCount++;
            else
                oddCount++;
            num/=10;
        }
        return (oddCount==evenCount);
    }

    @Test
    public void test() {
        assertEquals(2, numberOfBeautifulIntegers(10, 20, 3));
        assertEquals(1, numberOfBeautifulIntegers(1, 10, 1));
        assertEquals(0, numberOfBeautifulIntegers(5, 5, 2));

    }

    @Test
    public void testDigCount() {
        assertEquals(1, digCount(9));
        assertEquals(3, digCount(144));
        assertEquals(2, digCount(10));
        assertEquals(2, digCount(99));
        assertEquals(3, digCount(100));
    }

    @Test
    public void testCountsEqual() {
        assertTrue(countsEqual(10));
        assertTrue(countsEqual(1458));
        assertFalse(countsEqual(1488));
        assertFalse(countsEqual(333));
        assertFalse(countsEqual(7));
        assertFalse(countsEqual(60));
        assertFalse(countsEqual(59));
    }
}
