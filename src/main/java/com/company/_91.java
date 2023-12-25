package com.company;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class _91 {
    public int numDecodings(String s) {
        if (s.startsWith("0"))
            return 0;
        if (s.contains("00"))
            return 0;
        Set<List<String>> set = new HashSet<>();
        decode(s, new LinkedList<>(), set);
        return set.size();
    }

    void decode(String s, List<String> list, Set<List<String>> set) {
        if (s.length()>0 && !s.startsWith("0")) {
            if (s.length()>1) {
                for (int i = 1; i < s.length(); i++) {
                    decode(s.substring(0,i), list, set);
                    decode(s.substring(i), list, set);
                }
            }
            if (canDecode(s)) {
                list.add(s);
                set.add(new LinkedList<>(list));
            }
        }
    }

    boolean canDecode(String s) {
        if (s.length()>2)
            return false;
        return Integer.parseInt(s) <= 26;
    }

    @Test
    public void test() {
        assertEquals(2, numDecodings("12"));
        assertEquals(3, numDecodings("226"));
        assertEquals(0, numDecodings("06"));
    }

    @Test
    public void testCanDecode() {
        assertFalse(canDecode("0"));
        assertFalse(canDecode("01"));
        assertFalse(canDecode("101"));
        assertFalse(canDecode("27"));
        assertFalse(canDecode("09"));
        assertFalse(canDecode("009"));
        assertFalse(canDecode("100"));
        assertTrue(canDecode("10"));
        assertTrue(canDecode("1"));
        assertTrue(canDecode("26"));
        assertTrue(canDecode("15"));
    }
}
