package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _3075 {

    public long maximumHappinessSum(int[] happiness, int k) {
        return 0;
    }

    @Test
    public void test() {
        assertEquals(4, maximumHappinessSum(new int[]{1,2,3}, 2));
        assertEquals(1, maximumHappinessSum(new int[]{1,1,1,1}, 2));
        assertEquals(5, maximumHappinessSum(new int[]{2,3,4,5}, 1));
    }
}
