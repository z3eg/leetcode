package com.company;

import org.junit.Test;

import static org.apache.commons.math3.primes.Primes.isPrime;
import static org.junit.Assert.assertEquals;

public class _762 {

    /*Wrong Answer
    103 / 202 testcases passed*/
    public int countPrimeSetBits(int left, int right) {
        int counter = 0;
        for (int i = left; i <= right; i++) {
            if (isPrimeNumber(numberOfOnes(i)))
                counter++;
        }
        return counter;
    }

    private int numberOfOnes(int i) {
        int n = 0;
        while (i>=1) {
            if (i%2==1)
                n++;
            i/=2;
        }
        return n;
    }

    private boolean isPrimeNumber(int i) {
        return (i==2||i==3||i==5||i==7||i==11);
    }


    @Test
    public void test() {
        assertEquals(4, countPrimeSetBits(6,10));
        assertEquals(5, countPrimeSetBits(10,15));
    }
}
