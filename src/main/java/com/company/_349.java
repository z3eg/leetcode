package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class _349 {

    /*2
    ms
            Beats
94.92%
    of users with Java*/
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] freqs1 = new int[1_001];
        int[] freqs2 = new int[1_001];
        for (int n : nums1) {
            freqs1[n]++;
        }
        for (int n : nums2) {
            freqs2[n]++;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < freqs1.length; i++) {
            if (freqs1[i]>0 && freqs2[i]>0)
                list.add(i);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    @Test
    public void test() { //useless cause "Each element in the result must be unique and you may return the result in any order."
        /*assertArrayEquals(new int[]{2}, intersection(new int[]{1,2,2,1}, new int[]{2,2}));
        assertArrayEquals(new int[]{9,4}, intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4}));*/
    }
}
