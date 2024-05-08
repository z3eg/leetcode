package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*403. Minimum Subsequence in Non-Increasing Order
        https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/description/*/
public class _1403 {
    /*4ms
    Beats 90.71%of users with Java*/
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int i = nums.length -1;
        int sum = 0;
        List<Integer> res = new LinkedList<>();
        int halfTotalSum = 0;
        for (int n : nums)
            halfTotalSum+=n;
        halfTotalSum/=2;
        while (i >= 0 && sum <= halfTotalSum) {
            sum+=nums[i];
            res.add(nums[i]);
            i--;
        }
        return res;
    }


}
