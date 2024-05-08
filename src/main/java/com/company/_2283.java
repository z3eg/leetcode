package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _2283 {
    /*1ms
    Beats 83.88%of users with Java*/
    public boolean digitCount(String num) {
        byte[] freqs = new byte[10];
        for (char c : num.toCharArray())
            freqs[c-'0']++;
        for (int i = 0; i < num.length(); i++) {
            byte currentFreq = freqs[i];
            if (num.charAt(i) - '0' != currentFreq)
                return false;
        }
        return true;
    }

    @Test
    public void test() {
        assertTrue(digitCount("1210"));
        assertFalse(digitCount("030"));
    }
}
