package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/richest-customer-wealth/
public class _1672_RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        int curWealth;
        for (int[] account : accounts) {
            curWealth = 0;
            for (int i : account) {
                curWealth += i;
            }
            if (curWealth > maxWealth) {
                maxWealth = curWealth;
            }
        }
        return maxWealth;
    }

    @Test
    public void test() {
        assertEquals(6, maximumWealth(new int[][]{{1,2,3},{3,2,1}}));
        assertEquals(10, maximumWealth(new int[][]{{1,5},{7,3},{3,5}}));
        assertEquals(17, maximumWealth(new int[][]{{2,8,7},{7,1,3},{1,9,5}}));
    }


}
