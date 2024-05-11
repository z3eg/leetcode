package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _3075 {

    /*Wrong Answer
660 / 674 testcases passed*/
    /*public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int res = 0;
        int rounds = 0;
        int totReduced = 0;
        while (k>0) {
            rounds++;
            int cur = happiness[happiness.length - rounds];
            cur-=totReduced;
            if (cur > 0) {
                res+=cur;
            }
            k--;
            totReduced++;
        }
        return res;
    }*/

    /*34
    ms
    Beats
    97.44%
    of users with Java*/
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long res = 0;
        int rounds = 0;
        int totReduced = 0;
        while (k>0) {
            rounds++;
            int cur = happiness[happiness.length - rounds];
            cur-=totReduced;
            if (cur > 0) {
                res+=cur;
            }
            k--;
            totReduced++;
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(4, maximumHappinessSum(new int[]{1,2,3}, 2));
        assertEquals(1, maximumHappinessSum(new int[]{1,1,1,1}, 2));
        assertEquals(5, maximumHappinessSum(new int[]{2,3,4,5}, 1));
    }
}
