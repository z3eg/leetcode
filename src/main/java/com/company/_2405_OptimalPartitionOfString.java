package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/optimal-partition-of-string/
public class _2405_OptimalPartitionOfString {
    /*Runtime
    10 ms
    Beats
    89.77%*/
    public int partitionString(String s) {
        int p = 0;
        int res = 0;
        boolean[] letterChecked = new boolean[26];
        int sLen = s.length();
        while (p < sLen) {
            int i = s.charAt(p) - 97;
            if (letterChecked[i]) {
                letterChecked = new boolean[26];
                res++;
            }
            letterChecked[i] = true;
            p++;
        }
        return res+1;
    }

    @Test
    public void test() {
        assertEquals(5, partitionString("abacabaa"));
        assertEquals(4, partitionString("abacaba"));
        assertEquals(6, partitionString("ssssss"));
    }
}
