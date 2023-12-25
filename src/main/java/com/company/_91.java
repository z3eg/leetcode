package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _91 {
    public int numDecodings(String s) {

    }

    @Test
    public void test() {
        assertEquals(2, numDecodings("12"));
        assertEquals(3, numDecodings("226"));
        assertEquals(0, numDecodings("06"));
    }
}
