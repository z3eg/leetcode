package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _1750 {

    /*5
    ms
            Beats
33.02%
    of users with Java*/
    public int minimumLength(String s) {
        int l = 0;
        int r = s.length()-1;
        while (l<r) {
            if (s.charAt(l) != s.charAt(r)) {
                return r-l+1;
            }
            while (l < r && s.charAt(l)==s.charAt(l+1)) {
                l++;
            }
            while (l < r && s.charAt(r)==s.charAt(r-1)) {
                r--;
            }
            l++;
            r--;
        }
        int diff = r - l;
        return diff>=0 ? diff +1 : 0;
    }

    @Test
    public void test() {
        assertEquals(0, minimumLength("ccc"));
        assertEquals(0, minimumLength("cccc"));
        assertEquals(0, minimumLength("cc"));
        assertEquals(1, minimumLength("c"));
        assertEquals(0, minimumLength("cabaabac"));
        assertEquals(2, minimumLength("ca"));
        assertEquals(3, minimumLength("aabccabba"));
    }
}
