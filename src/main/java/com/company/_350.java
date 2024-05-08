package com.company;

import java.util.LinkedList;
import java.util.List;

public class _350 {

    /*Runtime
2
    ms
            Beats
96.41%
    of users with Java*/
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] freqs1 = new int[1001];
        int[] freqs2 = new int[1001];
        for (int n : nums1) {
            freqs1[n]++;
        }
        for (int n : nums2) {
            freqs2[n]++;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < freqs1.length; i++) {
            if (freqs1[i] > 0 && freqs2[i] > 0) {
                int min = Math.min(freqs1[i], freqs2[i]);
                for (int j = 0; j < min; j++) {
                    list.add(i);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    
}
