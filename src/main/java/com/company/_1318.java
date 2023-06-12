package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/*1318. Minimum Flips to Make a OR b Equal to c
        https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/*/
public class _1318 {
    /*Runtime
    1 ms
    Beats
    8.23%*/
    public int minFlips(int a, int b, int c) {
        int or = a|b;
        if (or == c) {
            return 0;
        }
        char[] aC = converTo32BitString(a);
        char[] bC = converTo32BitString(b);
        char[] cC = converTo32BitString(c);
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (cC[i] == '1') {
                if (aC[i]=='0' && bC[i]=='0')
                    res++;
            }
            else {
                if (aC[i]=='1' && bC[i]=='1')
                    res+=2;
                else if (aC[i]=='1' || bC[i]=='1')
                    res++;
            }
        }
        return res;
    }

    private char[] converTo32BitString(int n) {
        String s = Integer.toBinaryString(n);
        char[] chars = new char[32];
        Arrays.fill(chars, '0');
        int curIn = 31;
        for (int i = s.length()-1; i >= 0; i--) {
            chars[curIn] = s.charAt(i);
            curIn--;
        }
        return chars;
    }

    @Test
    public void test() {
        assertEquals(3, minFlips(2,6,5));
        assertEquals(1, minFlips(4,2,7));
        assertEquals(0, minFlips(1,2,3));
    }
}
