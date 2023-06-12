package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*1502. Can Make Arithmetic Progression From Sequence
        https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/*/
public class _1502 {
    /*Runtime
    4 ms
    Beats
    5.34%*/
    /*public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length==2)
            return true;
        int max = Integer.MIN_VALUE;
        Set<Integer> diffs = new TreeSet<>();
        for (int i : arr) {
            max = Math.max(max, i);
        }
        for (int i : arr) {
            diffs.add(max-i);
        }
        if (diffs.size()==1 && diffs.iterator().next()==0) {
            return true;
        }
        Iterator<Integer> it = diffs.iterator();
        Integer a1 = it.next();
        Integer a2 = it.next();
        int diff = a2-a1;
        for (int i = 0; i < arr.length; i++) {
            if (!diffs.contains(diff*i))
                return false;
        }
        return true;
    }*/

    /*Runtime
    3 ms
    Beats
    9.23%*/
    /*public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length==2)
            return true;
        Set<Integer> nums = new TreeSet<>();
        for (int n: arr) {
            nums.add(n);
        }
        if (nums.size()==1)
            return true;
        if (nums.size()!=arr.length)
            return false;
        Iterator<Integer> it = nums.iterator();
        Integer first = it.next();
        Integer cur = it.next();
        int diff = cur-first;
        while (it.hasNext()) {
            Integer next = it.next();
            if (next - cur != diff)
                return false;
            cur = next;
        }
        return true;
    }*/

    /*Runtime
    2 ms
    Beats
    81.19%*/
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length==2)
            return true;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i+1]-arr[i]!=arr[i]-arr[i-1])
                return false;
        }
        return true;
    }


    @Test
    public void test() {
        assertTrue(canMakeArithmeticProgression(new int[]{0,0,0,0}));
        assertTrue(canMakeArithmeticProgression(new int[]{3,5}));
        assertFalse(canMakeArithmeticProgression(new int[]{1,2,4}));
        assertTrue(canMakeArithmeticProgression(new int[]{3,5,1}));
    }
}
