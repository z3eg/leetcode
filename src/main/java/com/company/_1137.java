package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _1137 {

    /*0
    ms
    Beats
    100.00%
    of users with Java*/
    public int tribonacci(int n) {
        int[]ns = new int[38];
        ns[0]=0;
        ns[1]=1;
        ns[2]=1;
        return dp(n, ns);
    }

    int dp(int n, int[] ns) {
        if (n==0)
            return 0;
        if (ns[n]==0) {
            ns[n] = dp(n-1, ns) + dp(n-2, ns) + dp(n-3, ns);
        }
        return ns[n];
    }

    @Test
    public void test() {
        assertEquals(4, tribonacci(4));
        assertEquals(1389537, tribonacci(25));
    }
}
