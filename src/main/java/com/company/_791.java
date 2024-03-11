package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _791 {

    /*1
ms
Beats
75.87%
of users with Java*/
    public String customSortString(String order, String s) {
        int[] freqs = new int[26];
        for (char c : s.toCharArray()) {
            freqs[c-'a']++;
        }
        int counter = 0;
        char[] res = new char[s.length()];
        for (char c : order.toCharArray()) {
            for (int i = 0; i < freqs[c - 'a']; i++) {
                res[counter+i] = c;
            }
            counter+=freqs[c - 'a'];
        }
        if (counter < s.length()) {
            for (int i = 0; i < s.length(); i++) {
                if (order.indexOf(s.charAt(i))==-1) {
                    res[counter]=s.charAt(i);
                    counter++;
                }
            }
        }
        return new String(res);
    }

    @Test
    public void test() {
        assertEquals("cbad", customSortString("cba","abcd"));
    }
}
