package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _696 {

    /*Time Limit Exceeded
76 / 91 testcases passed*/
    public int countBinarySubstrings(String s) {
        int winSize = s.length();
        int res = 0;
        if (winSize%2!=0)
            winSize--;
        while (winSize>1) {
            for (int i = 0; i <= s.length() - winSize; i++) {
                int l = i;
                int r = i+winSize-1;
                boolean isGood = true;
                while (l<r) {
                    if (s.charAt(l)==s.charAt(r)) {
                        isGood = false;
                        break;
                    }
                    if (l > i && s.charAt(l)!=s.charAt(l-1)) {
                        isGood = false;
                        break;
                    }

                    l++;
                    r--;
                }
                if (isGood)
                    res++;
            }
            winSize-=2;
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(1, countBinarySubstrings("01"));
        assertEquals(6, countBinarySubstrings("00110011"));
        assertEquals(4, countBinarySubstrings("10101"));
    }
}
