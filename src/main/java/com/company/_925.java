package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _925 {

    /*Wrong Answer
10 / 94 testcases passed*/
    /*public boolean isLongPressedName(String name, String typed) {
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
    }*/


    /*Runtime Error
6 / 94 testcases passed*/
    /*public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length())
            return false;
        int nc = 1;
        int tc = 1;
        List<int[]> nl = new LinkedList<>();
        List<int[]> tl = new LinkedList<>();
        populateAList(name, nc, nl);
        populateAList(typed, tc, tl);
        if (nl.size()!=tl.size())
            return false;
        for (int i = 0; i < nl.size(); i++) {
            int[] n = nl.get(i);
            int[] t = tl.get(i);
            if (n[0]!= t[0])
                return false;
            if (n[1] > t[1])
                return false;
        }
        return true;
    }

    private void populateAList(String s, int counter, List<int[]> list) {
        int t0 = s.charAt(0);
        int t1 = 1;
        while (counter < s.length()) {
            while (counter < s.length() && s.charAt(counter)==t0) {
                t1++;
                counter++;
            }
            list.add(new int[]{t0,t1});
            if (counter < s.length()) {
                t0 = s.charAt(counter);
                t1 = 1;
                counter++;
            }
        }
        if (t0!=list.get(list.size()-1)[0])
            list.add(new int[]{t0,t1});
    }*/


    /*2
    ms
    Beats
    10.23%
    of users with Java*/
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length())
            return false;
        int nc = 1;
        int tc = 1;
        List<int[]> nl = new LinkedList<>();
        List<int[]> tl = new LinkedList<>();
        populateAList(name, nc, nl);
        populateAList(typed, tc, tl);
        if (nl.size()!=tl.size())
            return false;
        for (int i = 0; i < nl.size(); i++) {
            int[] n = nl.get(i);
            int[] t = tl.get(i);
            if (n[0]!= t[0])
                return false;
            if (n[1] > t[1])
                return false;
        }
        return true;
    }

    private void populateAList(String s, int counter, List<int[]> list) {
        int t0 = s.charAt(0);
        int t1 = 1;
        while (counter < s.length()) {
            while (counter < s.length() && s.charAt(counter)==t0) {
                t1++;
                counter++;
            }
            list.add(new int[]{t0,t1});
            if (counter < s.length()) {
                t0 = s.charAt(counter);
                t1 = 1;
                counter++;
            }
        }
        if (list.isEmpty() || t0!=list.get(list.size()-1)[0])
            list.add(new int[]{t0,t1});
    }

    @Test
    public void test() {
        assertFalse(isLongPressedName("aaaaaaaa","a"));
        assertTrue(isLongPressedName("a","aaaaaaaa"));
        assertFalse(isLongPressedName("a","b"));
        assertFalse(isLongPressedName("alex","aaleexa"));
        assertTrue(isLongPressedName("alex","aaaaaaaaaaaalex"));
        assertTrue(isLongPressedName("alex","alexxxxxxxx"));
        assertTrue(isLongPressedName("alex","alex"));
        assertTrue(isLongPressedName("alex","aaleex"));
        assertTrue(isLongPressedName("alex","aaleexx"));
        assertTrue(isLongPressedName("alex","aaleexxxxxx"));
        assertFalse(isLongPressedName("saeed","ssaaedd"));
    }
}
