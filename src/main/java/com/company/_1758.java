package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _1758 {
    public int minOperations(String s) {

    }

    @Test
    public void test() {
        assertEquals(1, minOperations("0100"));
        assertEquals(0, minOperations("10"));
        assertEquals(2, minOperations("1111"));
    }
}
