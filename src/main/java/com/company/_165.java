package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _165 {

    /*Wrong Answer
69 / 84 testcases passed*/
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int minlen = Math.min(s1.length, s2.length);
        for (int i = 0; i < minlen; i++) {
            if (Integer.parseInt(s1[i]) < Integer.parseInt(s2[i]))
                return -1;
            if (Integer.parseInt(s1[i]) > Integer.parseInt(s2[i]))
                return 1;
        }
        return 0;
    }

    @Test
    public void test() {
        assertEquals(-1, compareVersion("0.1","1.1"));
        assertEquals(0, compareVersion("1.01","1.001"));
        assertEquals(0, compareVersion("1.0","1.0.0"));
    }

}
