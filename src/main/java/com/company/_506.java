package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class _506 {

    /*25
    ms
            Beats
    19.02%
    of users with Java*/
    public String[] findRelativeRanks(int[] score) {
        int[] score2 = Arrays.copyOf(score, score.length);
        Arrays.sort(score2);
        String[] res = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            int place = findInArr(score[i], score2);
            String rank = switch(place) {
                case 1 -> "Gold Medal";
                case 2 -> "Silver Medal";
                case 3 -> "Bronze Medal";
                default -> String.valueOf(place);
            };
            res[i] = rank;
        }
        return res;
    }

    private int findInArr(int n, int[] arr) {
        //can optimize using BS
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n)
                return arr.length-i;
        }
        return -1;
    }

    @Test
    public void test() {
        assertArrayEquals(new String[]{"Gold Medal"}, findRelativeRanks(new int[]{17}));
        assertArrayEquals(new String[]{"Gold Medal","Silver Medal","Bronze Medal","4","5"}, findRelativeRanks(new int[]{5,4,3,2,1}));
        assertArrayEquals(new String[]{"Gold Medal","5","Bronze Medal","Silver Medal","4"}, findRelativeRanks(new int[]{10,3,8,9,4}));
    }
}
