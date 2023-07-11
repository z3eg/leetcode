package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

/*1475. Final Prices With a Special Discount in a Shop
        https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/*/
public class _1475 {
    /*Runtime
    1 ms
    Beats
    96.75%*/
    public int[] finalPrices(int[] prices) {
        int pricesLen = prices.length;
        for (int i = 0; i < pricesLen-1; i++) {
            for (int j = i+1; j < pricesLen; j++) {
                if (prices[i] >= prices[j]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    @Test
    public void test() {
        Assertions.assertArrayEquals(new int[]{9,0,1,6}, finalPrices(new int[]{10,1,1,6}));
        Assertions.assertArrayEquals(new int[]{4,2,4,2,3}, finalPrices(new int[]{8,4,6,2,3}));
        Assertions.assertArrayEquals(new int[]{1,2,3,4,5}, finalPrices(new int[]{1,2,3,4,5}));
    }
}
