package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class _935 {
    public int knightDialer(int n) {
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res+=transitions(n-1, i, 0);
        }
        return res;
    }

    int[] transitionsFrom(int button) {
        return switch (button) {
            case 1 -> new int[]{6,8};
            case 2 -> new int[]{7,9};
            case 3 -> new int[]{4,8};
            case 4 -> new int[]{3,9,0};
            case 5 -> new int[]{};
            case 6 -> new int[]{1,7,0};
            case 7 -> new int[]{2,6};
            case 8 -> new int[]{1,3};
            case 9 -> new int[]{4,2};
            case 0 -> new int[]{4,6};
            default -> null;
        };
    }

    //naive recursion
    /*private int transitions(int n, int curLen, int lastDigit, int curRes) {
        if (curLen > n)
            return curRes;
        if (curLen == n)
            return curRes+1;
        int[] nextDigits = transitionsFrom(lastDigit);
        for (int nd : nextDigits) {
            curRes = transitions(n, curLen+1, nd, curRes);
        }
        return curRes;
    }*/

    //naive recursion optimized for DP
    private int transitions(int n, int lastDigit, int curRes) {
        if (0 == n)
            return curRes+1;
        int[] nextDigits = transitionsFrom(lastDigit);
        for (int nd : nextDigits) {
            curRes = transitions(n-1,  nd, curRes);
        }
        return curRes;
    }



    @Test
    public void test() {
        assertEquals(20, knightDialer(2));
        assertEquals(10, knightDialer(1));
//        assertEquals(136006598, knightDialer(3131));
    }
}
