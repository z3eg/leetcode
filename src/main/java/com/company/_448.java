package com.company;

import java.util.LinkedList;
import java.util.List;

public class _448 {
    /*3
    ms
            Beats
99.27%
    of users with Java*/
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new LinkedList<>();
        int l = nums.length;
        int[] freqs = new int[l+1];
        for (int n : nums) {
            freqs[n]++;
        }
        for (int i = 1; i < freqs.length; i++) {
            if (freqs[i]==0)
                res.add(i);
        }
        return res;
    }
}
