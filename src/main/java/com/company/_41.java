package com.company;

public class _41 {

    /*Runtime Error
8 / 176 testcases passed*/
    public int firstMissingPositive(int[] nums) {
        int[] freq = new int[100_000];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                freq[nums[i]]++;
        }
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 0)
                return i;
        }
        return 0;
    }

}
