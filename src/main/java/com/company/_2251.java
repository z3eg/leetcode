package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

/*2251. Number of Flowers in Full Bloom
        https://leetcode.com/problems/number-of-flowers-in-full-bloom/description/?envType=daily-question&envId=2023-10-11*/
public class _2251 {

    /*46 / 52 testcases passed
    TLE*/
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] res = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < flowers.length; j++) {
                if (people[i] >=flowers[j][0] && people[i] <=flowers[j][1])
                    res[i]++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{1,2,2,2}, fullBloomFlowers(new int[][]{{1,6},{3,7},{9,12},{4,13}}, new int[]{2,3,7,11}));
        assertArrayEquals(new int[]{2,2,1}, fullBloomFlowers(new int[][]{{1,10},{3,3}}, new int[]{3,3,2}));
    }

}
