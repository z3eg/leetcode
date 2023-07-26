package com.company;

/*2341. Maximum Number of Pairs in Array
        https://leetcode.com/problems/maximum-number-of-pairs-in-array/*/
public class _2341 {
    /*-ms
    Beats 100.00%of users with Java*/
    public int[] numberOfPairs(int[] nums) {
        int[] freqs = new int[101];
        for (int n : nums) {
            freqs[n]++;
        }
        int res = 0;
        for (int f : freqs) {
            res+=f%2;
        }
        return new int[]{(nums.length-res)/2, res};
    }
}
