package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/*746. Min Cost Climbing Stairs
        https://leetcode.com/problems/min-cost-climbing-stairs/description/?envType=daily-question&envId=2023-10-13*/
public class _746 {

    /*Time Limit Exceeded
259 / 283 testcases passed*/
    /*public int minCostClimbingStairs(int[] cost) {
        return minCost(cost, 0, 0, Integer.MAX_VALUE);
    }

    int minCost(int[] cost, int cur, int step, int min) {
        if (step>cost.length-2)
            return Math.min(cur, min);
        min = Math.min(min, minCost(cost, cur+cost[step], step+1, min));
        min = Math.min(min, minCost(cost, cur+cost[step+1], step+2, min));
        return min;
    }*/

    /*public int minCostClimbingStairs(int[] cost) {
        int cur = 0;
        int i = -1;
        while (i < cost.length-2) {
            int pref;
            if (cost[i+1] < cost[i+2])
                pref = i+1;
            else
                pref = i+2;
            cur+=cost[pref];
            i = pref;
        }
        return cur;
    }*/

    /*Runtime
    0 ms
    Beats
    100%*/
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[dp.length-1] = 0;
        dp[dp.length-2] = cost[cost.length-1];
        for (int i = dp.length-3; i >=0; i--) {
            dp[i] = cost[i]+Math.min(dp[i+1], dp[i+2]);
        }
        return Math.min(dp[0], dp[1]);
    }

    @Test
    public void test() {
        assertEquals(6, minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
        assertEquals(15, minCostClimbingStairs(new int[]{10,15,20}));
        assertEquals(10, minCostClimbingStairs(new int[]{10,15}));
    }
}
