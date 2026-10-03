package com.company;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class _76 {


//    265 / 268 testcases passed
/*    public String minWindow(String s, String t) {
        if (s.equals(t))
            return s;
        int tLen = t.length();
        int sLen = s.length();
        if (sLen < tLen) {
            return "";
        }
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
//        Deque<Character> win = new LinkedList<>();
        for (int i = l; i <= r; i++) {
            char c = s.charAt(i);
            int curPos = c-'A';
            freqs[curPos]--;
//            win.addLast(c);
        }
        boolean goingRight = false;
        while (winSize<sLen) {
            if (l==0 && !goingRight) {
                goingRight = true;
                r++;
                add(freqs, r, s);
//                win.addLast(s.charAt(r));
                winSize++;
            }
            else if (r==sLen-1 && goingRight) {
                goingRight = false;
                l--;
                add(freqs, l, s);
//                win.addFirst(s.charAt(l));
                winSize++;
            }
            else if (goingRight) {
                rem(freqs, l, s);
//                win.removeFirst();
                l++;
                r++;
                add(freqs, r, s);
//                win.addLast(s.charAt(r));
            }
            else {
                l--;
                add(freqs, l, s);
//                win.addFirst(s.charAt(l));
                rem(freqs, r, s);
//                win.removeLast();
                r--;
            }
            if (match(care,freqs))
                return s.substring(l, r+1);
        }
        return "";
    }*/


    /*Runtime
168
ms
Beats
5.70%*/
    /*public String minWindow(String s, String t) {
        if (s.equals(t))
            return s;
        int tLen = t.length();
        int sLen = s.length();
        if (sLen < tLen) {
            return "";
        }
        int[] freqs = new int[58];
        boolean[] care = new boolean[58];
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            int curPos = c-'A';
            freqs[curPos]++;
            care[curPos] = true;
        }
        int l = 0;
        int r = 0;
        String res = null;
//        Deque<Character> q = new LinkedList<>();
//        add(freqs,r,s);
//        q.addLast(s.charAt(r));
        while (r < sLen) {
            while (match(care, freqs) && l<r) {
                //shrinking
                String sub = s.substring(l, r);
                if (res == null || res.length() > sub.length())
                    res = sub;
                rem(freqs, l, s);
//                q.removeFirst();
                l++;
            }
            while (!match(care, freqs) && r < sLen)
            {
                //expanding
                add(freqs, r, s);
//                q.addLast(s.charAt(r));
                r++;
            }
        }
        //r reached end, gonna shrink now while it matches
        while (match(care, freqs)) {
            //shrinking
            String sub = s.substring(l, r);
            if (res == null || res.length() > sub.length())
                res = sub;
            rem(freqs, l, s);
//            q.removeFirst();
            l++;
        }
        if (match(care, freqs)) {
            String sub = s.substring(l, r);
            if (res == null || res.length() > sub.length())
                res = sub;
        }
        return res==null?"":res;
    }*/

    /*18
ms
Beats
43.95%*/
    /*public String minWindow(String s, String t) {
        if (s.equals(t))
            return s;
        int tLen = t.length();
        int sLen = s.length();
        if (sLen < tLen) {
            return "";
        }
        int[] freqs = new int[58];
        boolean[] care = new boolean[58];
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            int curPos = c-'A';
            freqs[curPos]++;
            care[curPos] = true;
        }
        int l = 0;
        int r = 0;
        int lRes = 0;
        int rRes = 0;
        int minDiff = sLen;
        String res = null;
//        Deque<Character> q = new LinkedList<>();
//        add(freqs,r,s);
//        q.addLast(s.charAt(r));
        while (r < sLen) {
            while (match(care, freqs) && l<r) {
                //shrinking
//                String sub = s.substring(l, r);

                if (minDiff >= r-l)
                {
                    minDiff = r-l;
                    lRes = l;
                    rRes = r;
                }
                rem(freqs, l, s);
//                q.removeFirst();
                l++;
            }
            while (!match(care, freqs) && r < sLen)
            {
                //expanding
                add(freqs, r, s);
//                q.addLast(s.charAt(r));
                r++;
            }
        }
        //r reached end, gonna shrink now while it matches
        while (match(care, freqs)) {
            //shrinking
            if (minDiff >= r-l)
            {
                minDiff = r-l;
                lRes = l;
                rRes = r;
            }
            rem(freqs, l, s);
//            q.removeFirst();
            l++;
        }
        *//*if (match(care, freqs)) {
            String sub = s.substring(l, r);
            if (res == null || res.length() > sub.length())
                res = sub;
        }*//*
        return s.substring(lRes,rRes);
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
                if (freqs[i]>0)
                    return false;
        }
        return true;
    }*/

    /*Runtime
11
ms
Beats
59.11%
*/
    public String minWindow(String s, String t) {
        if (s.equals(t))
            return s;
        int tLen = t.length();
        int sLen = s.length();
        if (sLen < tLen) {
            return "";
        }
        int[] freqs = new int[58];
//        boolean[] care = new boolean[58];
        Set<Integer> valPos = new HashSet<>();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            int curPos = c-'A';
            freqs[curPos]++;
            valPos.add(curPos);
        }
        int[] valPosA = new int[valPos.size()];
        int i = 0;
        for(int val : valPos)
            valPosA[i++] = val;
        int l = 0;
        int r = 0;
        int lRes = 0;
        int rRes = 0;
        int minDiff = sLen;
        String res = null;
//        Deque<Character> q = new LinkedList<>();
//        add(freqs,r,s);
//        q.addLast(s.charAt(r));
        while (r < sLen) {
            while (match(valPosA, freqs) && l<r) {
                //shrinking
//                String sub = s.substring(l, r);

                if (minDiff >= r-l)
                {
                    minDiff = r-l;
                    lRes = l;
                    rRes = r;
                }
                rem(freqs, l, s);
//                q.removeFirst();
                l++;
            }
            while (!match(valPosA, freqs) && r < sLen)
            {
                //expanding
                add(freqs, r, s);
//                q.addLast(s.charAt(r));
                r++;
            }
        }
        //r reached end, gonna shrink now while it matches
        while (match(valPosA, freqs)) {
            //shrinking
            if (minDiff >= r-l)
            {
                minDiff = r-l;
                lRes = l;
                rRes = r;
            }
            rem(freqs, l, s);
//            q.removeFirst();
            l++;
        }
        /*if (match(care, freqs)) {
            String sub = s.substring(l, r);
            if (res == null || res.length() > sub.length())
                res = sub;
        }*/
        return s.substring(lRes,rRes);
    }

    void add(int[] freqs, int pos, String s) {
        char c = s.charAt(pos);
        freqs[c-'A']--;
    }

    void rem(int[] freqs, int pos, String s) {
        char c = s.charAt(pos);
        freqs[c-'A']++;
    }

    boolean match(int[] valPos, int[] freqs) {
        for (int valPo : valPos) {
            if (freqs[valPo] > 0)
                return false;
        }
        return true;
    }

    @Test
    public void test() {
        assertEquals("abc", minWindow("abc","ac"));
        assertEquals("BANC", minWindow("ADOBECODEBANC","ABC"));
        assertEquals("a", minWindow("ab","a"));
        assertEquals("a", minWindow("a","a"));
        assertEquals("", minWindow("a","aa"));
    }
}
