package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _1422 {
    public int maxScore(String s) {

    }

    @Test
    public void test() {
        assertEquals(5, maxScore("011101"));
        assertEquals(5, maxScore("00111"));
        assertEquals(3, maxScore("1111"));
    }
}
