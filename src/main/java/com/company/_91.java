package com.company;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class _91 {
    /*public int numDecodings(String s) {
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
    }*/

    /*Wrong Answer
41 / 269 testcases passed*/
    /*Map<String, Integer> map = new HashMap<>();

    public int numDecodings(String s) {
        Integer val = map.get(s);
        if (val != null)
            return val;
        if (s.startsWith("0"))
            return 0;
        if (s.length()>2) {
            int num = Math.max(numDecodings(s.substring(0, 1)) + numDecodings(s.substring(1)) ,
                    numDecodings(s.substring(0, 2)) + numDecodings(s.substring(2)));
            map.put(s, num);
            return num;
        }
        if (s.length()==2) {
            return 2;
        }
        if (s.length()==1)
            return 1;
        return 0;
    }
*/

    /*Wrong Answer
    116 / 269 testcases passed*/
    Map<String, Integer> map = new HashMap<>();

    public int numDecodings(String s) {
        Integer val = map.get(s);
        if (val != null)
            return val;
        if (s.startsWith("0"))
            return 0;
        if (s.length()>2) {
            int num = Math.max(numDecodings(s.substring(0, 1)) + numDecodings(s.substring(1)) ,
                    numDecodings(s.substring(0, 2)) + numDecodings(s.substring(2)));
            map.put(s, num);
            return num;
        }
        if (s.length()==2) {
            if (s.contains("0")) {
                if (s.contains("1") || s.contains("2"))
                    return 1;
                else
                    return 0;
            }
            else {
                return Integer.parseInt(s) < 26? 2: 1;
            }
        }
        if (s.length()==1)
            return 1;
        return 0;
    }

    @Test
    public void test() {
        assertEquals(3, numDecodings("226"));
        assertEquals(2, numDecodings("12"));
        assertEquals(0, numDecodings("06"));
    }

    /*@Test
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
    }*/
}
