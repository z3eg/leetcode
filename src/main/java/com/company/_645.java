package com.company;

import org.junit.Test;

public class _645 {

    /*Wrong Answer
13 / 49 testcases passed*/
    /*public int[] findErrorNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=i+1)
                return new int[]{nums[i],i+1};
        }
        return new int[2];
    }*/

    /*2
    ms
            Beats
97.74%
    of users with Java*/
    public int[] findErrorNums(int[] nums) {
        int[] freqs = new int[nums.length+1];
        for (int n : nums)
            freqs[n]++;
        int[] res = new int[2];
        for (int i = 1; i < freqs.length; i++) {
            if (freqs[i] == 2)
                res[0] = i;
            if (freqs[i] == 0)
                res[1] = i;
        }
        return res;
    }

}
