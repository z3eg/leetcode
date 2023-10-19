package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*844. Backspace String Compare
        https://leetcode.com/problems/backspace-string-compare/description/?envType=daily-question&envId=2023-10-19*/
public class _844 {
    /*Wrong Answer
    63 / 114 testcases passed*/
    /*public boolean backspaceCompare(String s, String t) {
        String s1 = process(s);
        String t1 = process(t);
        return s1.equals(t1);
    }

    private String process(String t) {
        char[] tchars = t.toCharArray();
        StringBuilder tb = new StringBuilder();
        for (int i = 0; i < tchars.length-1; i++) {
            if (tchars[i]!='#' && tchars[i+1]!='#')
                tb.append(tchars[i]);
        }
        if (tchars[tchars.length-1]!='#')
            tb.append(tchars[tchars.length-1]);
        else
            if (tb.length()>0)
                tb.deleteCharAt(tb.length()-1);
        return tb.toString();
    }*/

    /*1ms
    Beats 86.75%of users with Java*/
    public boolean backspaceCompare(String s, String t) {
        return process(s).equals(process(t));
    }

    private static String process(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='#') {
                if (sb.length()>0)
                    sb.deleteCharAt(sb.length()-1);
            }
            else
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    @Test
    public void test() {
        assertFalse(backspaceCompare("bxj##tw", "bxj###tw"));
        assertTrue(backspaceCompare("#", "a##"));
        assertFalse(backspaceCompare("#", "a"));
        assertFalse(backspaceCompare("a", "#"));
        assertTrue(backspaceCompare("#", "#"));
        assertTrue(backspaceCompare("ab##", "c#d#"));
        assertTrue(backspaceCompare("ab###", "c#d##"));
        assertTrue(backspaceCompare("ab#c", "ad#c"));
        assertFalse(backspaceCompare("a#c", "b"));

    }
}
