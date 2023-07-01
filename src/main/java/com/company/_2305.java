package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/*2305. Fair Distribution of Cookies
        https://leetcode.com/problems/fair-distribution-of-cookies/*/
public class _2305 {
    public int distributeCookies(int[] cookies, int k) {
        int[] distribs = new int[k];
        Arrays.sort(cookies);
        int cookiesSum = 0;
        for (int bag : cookies)
            cookiesSum+=bag;
        int avg = cookiesSum/k;
        for (int j = cookies.length-1; j >= 0; j--) {
            int minPos = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < distribs.length; i++) {
                if (min > distribs[i]) {
                    minPos = i;
                    min = distribs[i];
                }
            }
            distribs[minPos] += cookies[j];
        }
        int max = Integer.MIN_VALUE;
        for (int dist : distribs) {
            max = Math.max(max, dist);
        }
        return max;
    }

    @Test
    public void test() {
        assertEquals(31, distributeCookies(new int[]{8,15,10,20,8}, 2));
        assertEquals(7, distributeCookies(new int[]{6,1,3,2,2,4,1,2}, 3));
    }
}
