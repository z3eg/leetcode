package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/*2798. Number of Employees Who Met the Target
        https://leetcode.com/problems/number-of-employees-who-met-the-target/*/
public class _2798 {
    /*-ms
    Beats 100.00%of users with Java*/
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int res = 0;
        for (int h : hours) {
            if (h >= target)
                res++;
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(3, numberOfEmployeesWhoMetTarget(new int[]{0,1,2,3,4}, 2));
        assertEquals(0, numberOfEmployeesWhoMetTarget(new int[]{5,1,4,2,2}, 6));
        assertEquals(0, numberOfEmployeesWhoMetTarget(new int[]{1}, 6));
        assertEquals(1, numberOfEmployeesWhoMetTarget(new int[]{6}, 6));
        assertEquals(1, numberOfEmployeesWhoMetTarget(new int[]{18}, 6));
    }
}
