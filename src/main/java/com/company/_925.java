package com.company;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _925 {

    /*Wrong Answer
10 / 94 testcases passed*/
    public boolean isLongPressedName(String name, String typed) {
        int n = 0;
        int t = 0;
        if (name.length() > typed.length())
            return false;
        if (name.charAt(n) != typed.charAt(t))
            return false;
        while (t < typed.length()) {
            while (n < name.length() && t < typed.length() && name.charAt(n) == typed.charAt(t)) {
                n++;
                t++;
            }
            while (t < typed.length() && typed.charAt(t)==typed.charAt(t-1))
                t++;
            if (n < name.length() && t < typed.length() && name.charAt(n)!=typed.charAt(t))
                return false;
        }
        return n >= name.length()-1 && t>=typed.length()-1;
    }

    @Test
    public void test() {
        assertTrue(isLongPressedName("alex","aaleexa"));
        assertTrue(isLongPressedName("alex","aaaaaaaaaaaalex"));
        assertTrue(isLongPressedName("alex","alexxxxxxxx"));
        assertTrue(isLongPressedName("alex","alex"));
        assertTrue(isLongPressedName("alex","aaleex"));
        assertTrue(isLongPressedName("alex","aaleexx"));
        assertTrue(isLongPressedName("alex","aaleexxxxxx"));
        assertFalse(isLongPressedName("saeed","ssaaedd"));
    }
}
