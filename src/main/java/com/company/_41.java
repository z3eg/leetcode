package com.company;

public class _41 {

    /*Runtime Error
8 / 176 testcases passed*/
    /*public int firstMissingPositive(int[] nums) {
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
    }*/

    /*Wrong Answer
175 / 176 testcases passed*/
    /*public int firstMissingPositive(int[] nums) {
        int[] freq = new int[100_001];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i]<100_001)
                freq[nums[i]]++;
        }
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 0)
                return i;
        }
        return 0;
    }*/

    /*3
    ms
    Beats
    37.78%
    of users with Java*/
    public int firstMissingPositive(int[] nums) {
        int[] freq = new int[100_002];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i]<=100_001)
                freq[nums[i]]++;
        }
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 0)
                return i;
        }
        return 0;
    }

}
