package com.company;

import org.junit.Test;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class _1544 {

    /*3
    ms
    Beats
    61.07%
    of users with Java*/
    public String makeGood(String s) {
        //32
        boolean isGood = false;
        List<Character> chars = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            chars.add(s.charAt(i));
        }
        while (!isGood && !chars.isEmpty()) {
            isGood = true;
            int idx = -2;
            for (int i = 0; i < chars.size()-1; i++) {
                if (Math.abs(chars.get(i)-chars.get(i+1))==32) {
                    idx = i;
                    isGood = false;
                    break;
                }
            }
            if (idx!=-2) {
                chars.remove(idx);
                chars.remove(idx);
            }
        }
        char[] charArr = new char[chars.size()];
        for (int i = 0; i < chars.size(); i++) {
            charArr[i] = chars.get(i);
        }
        return new String(charArr);
    }

    @Test
    public void test() {
        assertEquals("leetcode", makeGood("leEeetcode"));
        assertEquals("", makeGood("abBAcC"));
        assertEquals("s", makeGood("s"));
    }
}
