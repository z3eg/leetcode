package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

public class _2433 {

    /*3ms
    Beats 59.65%of users with Java*/
    public int[] findArray(int[] pref) {
        if (pref.length==1)
            return pref;
        int[] res = new int[pref.length];
        int[] accum = new int[pref.length];
        res[0] = pref[0];
        accum[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            res[i] = accum[i-1]^pref[i];
            accum[i] = accum[i-1]^res[i];
        }
        return res;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{5,7,2,3,2}, findArray(new int[]{5,2,0,3,1}));
        assertArrayEquals(new int[]{13}, findArray(new int[]{13}));
    }

}
