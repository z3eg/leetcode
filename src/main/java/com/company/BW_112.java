package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BW_112 {
    public boolean canBeEqual(String s1, String s2) {
        if (s1.charAt(0)!=s2.charAt(0) && s1.charAt(0)!=s2.charAt(2))
            return false;
        if (s1.charAt(1)!=s2.charAt(1) && s1.charAt(1)!=s2.charAt(3))
            return false;
        if (s1.charAt(2)!=s2.charAt(2) && s1.charAt(2)!=s2.charAt(0))
            return false;
        if (s1.charAt(3)!=s2.charAt(3) && s1.charAt(3)!=s2.charAt(1))
            return false;
        return true;
    }

    @Test
    public void test() {
        assertFalse(canBeEqual("cmpr","rmcp"));
        assertTrue(canBeEqual("abcd","cbad"));
        assertTrue(canBeEqual("abcd","cdab"));
        assertTrue(canBeEqual("cdcd","abcd"));
        assertFalse(canBeEqual("abcd","dacb"));
    }
}
