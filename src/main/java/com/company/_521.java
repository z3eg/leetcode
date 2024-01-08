package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class _521 {

    /*0
    ms
            Beats
100.00%
    of users with Java*/
    public int findLUSlength(String a, String b) {
        return a.equals(b)?-1:Math.max(a.length(),b.length());
    }

    @Test
    public void test() {
        assertEquals(3, findLUSlength("aba", "cdc"));
        assertEquals(3, findLUSlength("aaa", "bbb"));
        assertEquals(-1, findLUSlength("aaa", "aaa"));
    }
}
