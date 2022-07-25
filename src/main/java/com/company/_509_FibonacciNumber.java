package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _509_FibonacciNumber {

    public int fib(int n) {
        if (n==0)
            return 0;
        int secondPrec = 1;
        int cur = 1;
        int tmp;
        for (int i = 3; i <= n; i++) {
            tmp = cur;
            cur = cur+secondPrec;
            secondPrec = tmp;
        }
        return cur;
    }

    @Test
    public void test() {
        assertEquals(0, fib(0));
        assertEquals(1, fib(1));
        assertEquals(1, fib(2));
        assertEquals(2, fib(3));
        assertEquals(3, fib(4));
        assertEquals(6765, fib(20));
    }

    /*The Fibonacci numbers, commonly denotedda F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

    F(0) = 0, F(1) = 1
    F(n) = F(n - 1) + F(n - 2), for n > 1.
    Given n, calculate F(n).

    Example 1:

    Input: n = 2
    Output: 1
    Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
    Example 2:

    Input: n = 3
    Output: 2
    Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
    Example 3:

    Input: n = 4
    Output: 3
    Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

    Constraints:
            0 <= n <= 30*/
}
