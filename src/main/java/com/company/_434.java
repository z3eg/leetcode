package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _434 {

    /*Wrong Answer
20 / 28 testcases passed*/
    /*public int countSegments(String s) {
        return s.split("\s").length;
    }*/

    /*Wrong Answer
21 / 28 testcases passed*/
    /*public int countSegments(String s) {
        if (s.length()==0)
            return 0;
        return s.split(" ").length;
    }*/

    /*Wrong Answer
25 / 28 testcases passed*/
    /*public int countSegments(String s) {
        if (s.length()==0)
            return 0;
        return s.split("\s+").length;
    }*/

    /*0
    ms
            Beats
100.00%
    of users with Java*/
    public int countSegments(String s) {
        int count= 0;
        int i = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i)==' ')
                i++;
            if (i < s.length())
                count++;
            while (i < s.length() && s.charAt(i)!=' ')
                i++;
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(2, countSegments("    foo    bar    "));
        assertEquals(2, countSegments("foo    bar    "));
        assertEquals(2, countSegments("    foo    bar"));
        assertEquals(6, countSegments(", , , ,        a, eaefa"));
        assertEquals(0, countSegments(""));
        assertEquals(0, countSegments(" "));
        assertEquals(0, countSegments("  "));
        assertEquals(0, countSegments("   "));
    }
}
