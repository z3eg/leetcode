package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/contest/biweekly-contest-86/problems/maximum-number-of-robots-within-budget/
public class _6143_MaximumNumberofRobotsWithinBudget {

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int totalBudget = 0;
        int num = 0;
        while (totalBudget<=budget) {
            int maxChargeTime = 0;
            int sumRunningCosts = 0;
            for (int i = 0; i <= num; i++) {
                maxChargeTime=Math.max(maxChargeTime,chargeTimes[i]);
                sumRunningCosts+=runningCosts[i];
            }
            totalBudget = maxChargeTime + (num+1) * sumRunningCosts;
            num++;
        }
        return --num;
    }

    @Test
    public void test() {
        assertEquals(0, maximumRobots(new int[]{11,12,19}, new int[]{10,8,7}, 19));
        assertEquals(3, maximumRobots(new int[]{3,6,1,3,4}, new int[]{2,1,3,4,5}, 25));
        assertEquals(3, maximumRobots(new int[]{8,76,74,9,75,71,71,42,15,58,88,38,56,59,10,11},
                new int[]{1,92,41,63,22,37,37,8,68,97,39,59,45,50,29,37}, 412));
    }
}
