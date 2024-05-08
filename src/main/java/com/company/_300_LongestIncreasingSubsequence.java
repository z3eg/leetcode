package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/longest-increasing-subsequence/
public class _300_LongestIncreasingSubsequence {

    /*Wrong Answer
35 / 55 testcases passed*/
    /*public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length-1] = 1;
        int longest = 1;
        for (int i = nums.length-1; i >=0 ; i--) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    longest = Math.max(longest, dp[i]);
                }
            }
        }
        return longest;
    }*/

    /*46
    ms
            Beats
37.94%
    of users with Java*/
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int longest = 1;
        for (int i = nums.length-1; i >=0 ; i--) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    longest = Math.max(longest, dp[i]);
                }
            }
        }
        return longest;
    }

    @Test
    public void test() {
        assertEquals(6, lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
        assertEquals(4, lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        assertEquals(4, lengthOfLIS(new int[]{0,1,0,3,2,3}));
        assertEquals(1, lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }

   /* Example 1:

    Input: nums = [10,9,2,5,3,7,101,18]
    Output: 4
    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
    Example 2:

    Input: nums = [0,1,0,3,2,3]
    Output: 4
    Example 3:

    Input: nums = [7,7,7,7,7,7,7]
    Output: 1
*/
}
