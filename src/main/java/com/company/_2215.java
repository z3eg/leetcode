package com.company;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/find-the-difference-of-two-arrays/
//2215. Find the Difference of Two Arrays
public class _2215 {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        char[] c1 = new char[2001];
        char[] c2 = new char[2001];
        for (int i = 0; i < 2001; i++) {
            c1[i] = '0';
        }
        for (int i = 0; i < 2001; i++) {
            c2[i] = '0';
        }
        for (int n : nums1) {
            c1[n+1000] = '1';
        }
        for (int n : nums2) {
            c2[n+1000] = '1';
        }

        long m1 = Long.parseUnsignedLong(new String(c1), 2);
        long m2 = Long.parseUnsignedLong(new String(c2), 2);
        List<List<Integer>> res = new LinkedList<>();
        /*res.add(r1);
        res.add(r2);*/
        return res;
    }

    //    17 ms, Beats 24.62%
    /*public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> m1 = new HashMap<>();
        Map<Integer, Boolean> m2 = new HashMap<>();
        for (int j : nums1) {
            m1.putIfAbsent(j, true);
        }
        for (int j : nums2) {
            m1.put(j, false);
        }
        for (int j : nums2) {
            m2.putIfAbsent(j, true);
        }
        for (int j : nums1) {
            m2.put(j, false);
        }
        LinkedList<Integer> r1 = new LinkedList<>();
        LinkedList<Integer> r2 = new LinkedList<>();
        for (Integer k : m1.keySet()) {
            if (m1.get(k))
                r1.add(k);
        }
        for (Integer k : m2.keySet()) {
            if (m2.get(k))
                r2.add(k);
        }
        List<List<Integer>> res = new LinkedList<>();
        res.add(r1);
        res.add(r2);
        return res;
    }*/

    //4ms, beats 98%
    /*public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        boolean[] n1 = new boolean[2001];
        boolean[] n2 = new boolean[2001];
        for (int n : nums1) {
            n1[n + 1000] = true;
        }
        for (int n : nums2) {
            n2[n + 1000] = true;
        }
        LinkedList<Integer> r1 = new LinkedList<>();
        LinkedList<Integer> r2 = new LinkedList<>();
        for (int i = 0; i < 2001; i++) {
            if (n1[i] && !n2[i])
                r1.add(i-1000);
            if (n2[i] && !n1[i])
                r2.add(i-1000);
        }
        List<List<Integer>> res = new LinkedList<>();
        res.add(r1);
        res.add(r2);
        return res;
    }*/

    @Test
    public void test() {
        findDifference(new int[]{-1000, -999}, new int[]{0});
    }
}
