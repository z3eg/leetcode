package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _1758 {

    /*Wrong Answer
81 / 89 testcases passed*/
    public int minOperations(String s) {
        char[] larr = s.toCharArray();
        char[] rarr = s.toCharArray();
        int l = 0;
        int r =0;
        for (int i = 1; i < larr.length; i++) {
            if (larr[i]==larr[i-1]) {
                larr[i] = larr[i]=='1'?'0':'1';
                l++;
            }
        }
        for (int i = rarr.length-2; i >= 0; i--) {
            if (rarr[i]==rarr[i+1]) {
                rarr[i] = rarr[i]=='1'?'0':'1';
                r++;
            }
        }
        return Math.min(l,r);
    }

    @Test
    public void test() {
        assertEquals(0, minOperations("0"));
        assertEquals(0, minOperations("1"));
        assertEquals(1, minOperations("0100"));
        assertEquals(0, minOperations("10"));
        assertEquals(2, minOperations("1111"));
        assertEquals(0, minOperations("01010"));
        assertEquals(1, minOperations("01110"));
    }
}
