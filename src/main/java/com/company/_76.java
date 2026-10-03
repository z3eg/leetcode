package com.company;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class _76 {


//    192 / 268 testcases passed
    public String minWindow(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();
        if (sLen < tLen)
            return "";
        int[] freqs = new int[58];
        boolean[] care = new boolean[58];
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            int curPos = c-'A';
            freqs[curPos]++;
            care[curPos] = true;
        }
        int winSize = tLen-1;
        int l = 0;
        int r = winSize-1;
        Deque<Character> win = new LinkedList<>();
        for (int i = l; i <= r; i++) {
            char c = s.charAt(i);
            int curPos = c-'A';
            freqs[curPos]--;
            win.addLast(c);
        }
        boolean goingRight = false;
        while (winSize<sLen) {
            if (l==0 && !goingRight) {
                goingRight = true;
                r++;
                add(freqs, r, s);
                win.addLast(s.charAt(r));
                winSize++;
            }
            else if (r==sLen-1 && goingRight) {
                goingRight = false;
                l--;
                add(freqs, l, s);
                win.addFirst(s.charAt(l));
                winSize++;
            }
            else if (goingRight) {
                rem(freqs, l, s);
                win.removeFirst();
                l++;
                r++;
                add(freqs, r, s);
                win.addLast(s.charAt(r));
            }
            else {
                l--;
                add(freqs, l, s);
                win.addFirst(s.charAt(l));
                rem(freqs, r, s);
                win.removeLast();
                r--;
            }
            if (match(care,freqs))
                return s.substring(l, r+1);
        }
        return "";
    }

    void add(int[] freqs, int pos, String s) {
        char c = s.charAt(pos);
        freqs[c-'A']--;
    }

    void rem(int[] freqs, int pos, String s) {
        char c = s.charAt(pos);
        freqs[c-'A']++;
    }

    boolean match(boolean[] care, int[] freqs) {
        for (int i = 0; i < 58; i++) {
            if (care[i])
                if (freqs[i]!=0)
                    return false;
        }
        return true;
    }

    @Test
    public void test() {
        assertEquals("BANC", minWindow("ADOBECODEBANC","ABC"));
        assertEquals("a", minWindow("a","a"));
        assertEquals("", minWindow("a","aa"));
    }
}
