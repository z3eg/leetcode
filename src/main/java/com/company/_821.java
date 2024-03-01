package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class _821 {

    /*9
    ms
            Beats
15.06%
    of users with Java*/
    public int[] shortestToChar(String s, char c) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==c)
                list.add(i);
        }
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int min = Integer.MAX_VALUE;
            for (Integer pos : list) {
                min = Math.min(min, Math.abs(i - pos));
            }
            res[i] = min;
        }
        return res;
    }

    /*private int bs(int i, List<Integer> list) {
        return bs(i, list, 0, list.size());
    }

    private int bs(int i, List<Integer> list, int l, int r) {
        if (r-l<=1)
            return 1;
        if (list.get(l)==i)
            return 0;
        if (list.get(r)==i)
            return 0;
    }*/

    @Test
    public void test() {
        assertArrayEquals(new int[]{3,2,1,0,1,0,0,1,2,2,1,0}, shortestToChar("loveleetcode", 'e'));
        assertArrayEquals(new int[]{3,2,1,0}, shortestToChar("aaab", 'b'));
    }
}
