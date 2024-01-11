package com.company;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _551 {

    /*1
    ms
            Beats
46.62%
    of users with Java*/
    public boolean checkRecord(String s) {
        if (s.contains("LLL"))
            return false;
        if (s.contains("A")) {
            s = s.replaceFirst("A","B");
            return (!s.contains("A"));
        }
        return true;
    }

    @Test
    public void test() {
        assertFalse(checkRecord("PPAALP"));
        assertFalse(checkRecord("PPAALP"));
        assertFalse(checkRecord("PPALALP"));
        assertTrue(checkRecord("PPALLP"));
        assertTrue(checkRecord("PLLPALLP"));
        assertFalse(checkRecord("PPALLL"));
        assertFalse(checkRecord("PPALLLLLL"));
    }
}
