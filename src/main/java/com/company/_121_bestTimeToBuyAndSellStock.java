package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class _121_bestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        int curProfit;
        for (int i = 0; i < prices.length; i++) {
            if (min>prices[i]) {
                min = prices[i];
            }
            else {
                curProfit = prices[i] - min;
                if (curProfit > maxProfit) {
                    maxProfit = curProfit;
                }
            }
        }
        return maxProfit;
    }

    @Test
    public void test() {
        assertEquals(0, maxProfit(new int[]{7}));
        assertEquals(5, maxProfit(new int[]{7,1,5,3,6,4}));
        assertEquals(0, maxProfit(new int[]{7,6,4,3,1}));
    }

}
