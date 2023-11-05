package com.company;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class _1535 {

    /*12ms
    Beats 19.57%of users with Java*/
    public int getWinner(int[] arr, int k) {
        List<Integer> array = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            array.add(j);
            if (j > max)
                max = j;
        }
        /*if (k>max)
            return max;*/
        int winCount = 0;
        while (winCount < k && array.get(0)!=max) {
            if (array.get(0) > array.get(1)) {
                winCount++;
                array.add(array.get(1));
                array.remove(1);
            }
            else {
                winCount = 1;
                array.add(array.get(0));
                array.remove(0);
            }
        }
        return array.get(0);
    }

    @Test
    public void test() {
        assertEquals(25, getWinner(new int[]{1,25,35,42,68,70}, 1));
        assertEquals(5, getWinner(new int[]{2,1,3,5,4,6,7}, 2));
        assertEquals(3, getWinner(new int[]{3,2,1}, 10));
        assertEquals(3, getWinner(new int[]{3,2}, 1_000_000_000));
        assertEquals(3, getWinner(new int[]{3,1,2,5}, 2));
        assertEquals(3, getWinner(new int[]{1,3,2,5}, 2));
        assertEquals(5, getWinner(new int[]{1,3,2,5}, 3));
        assertEquals(5, getWinner(new int[]{1,3,2,5}, 4));
        assertEquals(5, getWinner(new int[]{1,3,2,5}, 5));
    }
}
