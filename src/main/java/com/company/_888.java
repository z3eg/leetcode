package com.company;

import org.junit.Test;

public class _888 {

    /*204
    ms
    Beats
    24.28%
    of users with Java*/
    /*public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aTot = 0;
        int bTot = 0;
        for (int a : aliceSizes)
            aTot+= a;
        for (int b : bobSizes)
            bTot += b;
        int avg = (aTot+bTot)/2;
        for (int a : aliceSizes) {
            for (int b : bobSizes) {
                if (aTot-a+b==avg)
                    return new int[]{a,b};
            }
        }
        return null;
    }*/

    /*205
    ms
    Beats
    22.95%
    of users with Java*/
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aTot = 0;
        int bTot = 0;
        for (int a : aliceSizes)
            aTot+= a;
        for (int b : bobSizes)
            bTot += b;
        int avg = (aTot+bTot)/2;
        int diff = avg - aTot;
        for (int a : aliceSizes) {
            for (int b : bobSizes) {
                if (b-a == diff)
                    return new int[]{a,b};
            }
        }
        return null;
    }

    @Test
    public void test() {

    }
}
