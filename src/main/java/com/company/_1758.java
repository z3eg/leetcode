package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _1758 {

    /*Wrong Answer
81 / 89 testcases passed*/
    /*public int minOperations(String s) {
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
    }*/

    /*2109
    ms
            Beats
    5.90%
    of users with Java*/
    public int minOperations(String s) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            int count = 0;
            //change all to the right
            for (int j = i; j < chars.length-1; j++) {
                if (chars[j+1]==chars[j]) {
                    count++;
                    chars[j+1] = chars[j+1]=='1'?'0':'1';
                }
            }
            //change all to the left
            for (int j = i; j > 0; j--) {
                if (chars[j-1]==chars[j]) {
                    count++;
                    chars[j-1] = chars[j-1]=='1'?'0':'1';
                }
            }
            min = Math.min(min, count);
        }
        return min;
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
        assertEquals(3, minOperations("10010100"));
    }
}
