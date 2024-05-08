package com.company;

import java.util.Arrays;

public class _2706 {

    /*2
    ms
            Beats
77.87%
    of users with Java*/
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int sum = prices[0] + prices[1];
        return sum>money?money:money-sum;
    }
}
