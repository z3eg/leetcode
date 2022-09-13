package com.company;

import org.junit.Test;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/
public class _2037_MinimumNumberOfMoves {

    //TODO optimize
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int sum = 0;
        for (int i = 0; i < seats.length; i++) {
            sum+=Math.abs(seats[i]-students[i]);
        }
        return sum;
    }

    @Test
    public void test() {

    }
}
