package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/combination-sum-iv/
public class _377_CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++)
            for (int num : nums)
                if (num <= i) dp[i] += dp[i - num];
        return dp[target];
    }


    //fast but hard to understand
    /*public int combinationSum4(int[] nums, int target) {
        Integer[] memo = new Integer[target + 1];
        return recurse(nums, target, memo);
    }

    public int recurse(int[] nums, int remain, Integer[] memo) {

        if (remain < 0) return 0;
        if (memo[remain] != null) return memo[remain];
        if (remain == 0) return 1;

        int ans = 0;
        for (int num : nums) {
            ans += recurse(nums, remain - num, memo);
        }

        memo[remain] = ans;
        return memo[remain];
    }*/

        //TLE
    /*private static class Node {
        public int content;

        public Node(int content) {
            this.content = content;
        }
    }

    public int combinationSum4(int[] nums, int target) {
        int curSum = 0;
        Node node = new Node(0);
        sum(nums, curSum, target, node);
        return node.content;
    }

    private void sum(int[] nums, int curSum, int target, Node res) {
        if (curSum > target)
            return;
        if (curSum == target)
            res.content++;
        for (int num : nums) {
            sum(nums, curSum+num, target, res);
        }
    }*/

    @Test
    public void test() {
        assertEquals(181997601, combinationSum4(new int[]{1,2,3},32));
        assertEquals(7, combinationSum4(new int[]{1,2,3},4));
        assertEquals(0, combinationSum4(new int[]{9},3));
    }

    /*Example 1:

Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
Example 2:

Input: nums = [9], target = 3
Output: 0*/
}
