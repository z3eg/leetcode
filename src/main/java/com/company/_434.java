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
    public int countSegments(String s) {
        if (s.length()==0)
            return 0;
        return s.split(" ").length;
    }

    @Test
    public void test() {
        assertEquals(0, countSegments(""));
        assertEquals(0, countSegments(" "));
        assertEquals(0, countSegments("  "));
        assertEquals(0, countSegments("   "));
    }
}
