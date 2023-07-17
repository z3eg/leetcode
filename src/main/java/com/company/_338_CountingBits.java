package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class _338_CountingBits {

    /*Runtime
    12 ms
    Beats
    17.46%*/
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 0; i <= n; i++) {
            res[i] = getOnes(i);
        }
        return res;
    }

    int getOnes(int n) {
        int res = 0;
        while (n>=1) {
            res+=n%2;
            n/=2;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(countBits(20)));
    }
}
