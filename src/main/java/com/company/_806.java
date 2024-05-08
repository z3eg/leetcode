package com.company;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class _806 {

    /*1
    ms
            Beats
56.53%
    of users with Java*/
    public int[] numberOfLines(int[] widths, String s) {
        int lineNum = 1;
        int curLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int curLet = widths[s.charAt(i)-'a'];
            if (curLen + curLet > 100) {
                lineNum++;
                curLen=curLet;
            }
            else
                curLen+=curLet;
        }
        return new int[]{lineNum, curLen};
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{3,60}, numberOfLines(new int[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10}, "abcdefghijklmnopqrstuvwxyz"));
        assertArrayEquals(new int[]{2,4}, numberOfLines(new int[]{4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10}, "bbbcccdddaaa"));
    }
}
