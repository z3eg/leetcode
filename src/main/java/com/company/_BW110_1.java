package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*6990. Account Balance After Rounded Purchase
        https://leetcode.com/contest/biweekly-contest-110/problems/account-balance-after-rounded-purchase/*/
public class _BW110_1 {

    public int accountBalanceAfterPurchase(int purchaseAmount) {
        return 100-Math.round(((float)purchaseAmount/10))*10;
    }

    @Test
    public void test() {
        assertEquals(0, accountBalanceAfterPurchase(99));
        assertEquals(0, accountBalanceAfterPurchase(100));
        assertEquals(100, accountBalanceAfterPurchase(0));
        assertEquals(90, accountBalanceAfterPurchase(9));
        assertEquals(80, accountBalanceAfterPurchase(15));
    }
}

