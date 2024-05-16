package com.company;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _925 {

    public boolean isLongPressedName(String name, String typed) {
        return false;
    }

    @Test
    public void test() {
        assertTrue(isLongPressedName("alex","aaleex"));
        assertFalse(isLongPressedName("saeed","ssaaedd"));
    }
}
