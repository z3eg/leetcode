package com.company;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class _492 {
    //nope
    /*public int[] constructRectangle(int area) {
        double sqrt = Math.sqrt(area);
        return (sqrt%1==0)?new int[]{(int)sqrt,(int)sqrt}:new int[]{(int)sqrt-1,(int)sqrt+1};
    }*/

    /*Wrong Answer
48 / 52 testcases passed*/
    public int[] constructRectangle(int area) {
        int L = area;
        int W = 1;
        int[] res = new int[]{L,W};
        while (W<L) {
            W++;
            L=area/W;
            if (L*W==area) {
                res[0] = L;
                res[1] = W;
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{2,2}, constructRectangle(4));
        assertArrayEquals(new int[]{37,1}, constructRectangle(37));
        assertArrayEquals(new int[]{427,286}, constructRectangle(122122));
        assertArrayEquals(new int[]{1_000,1_000}, constructRectangle(1_000_000));
    }
}
