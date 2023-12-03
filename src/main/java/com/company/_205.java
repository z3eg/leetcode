package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _205 {
    public boolean isIsomorphic(String s, String t) {

    }

    @Test
    public void test() {
        assertTrue(isIsomorphic("egg","add"));
        assertTrue(isIsomorphic("paper","title"));
        assertFalse(isIsomorphic("foo","bar"));
    }
}
