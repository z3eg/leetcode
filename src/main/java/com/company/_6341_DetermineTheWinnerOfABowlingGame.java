package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/contest/weekly-contest-343/problems/determine-the-winner-of-a-bowling-game/
public class _6341_DetermineTheWinnerOfABowlingGame {
    public int isWinner(int[] player1, int[] player2) {
        int s1 = 0;
        int s2 = 0;
        int p1doubler = 0;
        int p2doubler = 0;
        for (int i = 0; i < player1.length; i++) {
            p1doubler-=(p1doubler>0)?1:0;
            p2doubler-=(p2doubler>0)?1:0;
            s1+=player1[i]*((p1doubler>0)?2:1);
            s2+=player2[i]*((p2doubler>0)?2:1);
            if (player1[i]==10)
                p1doubler = 3;
            if (player2[i]==10)
                p2doubler = 3;
        }
        if (s1>s2)
            return 1;
        if (s2>s1)
            return 2;
        return 0;
    }

    @Test
    public void test() {
        assertEquals(1, isWinner(new int[]{9,7,10,7}, new int[]{10,2,4,10}));
        assertEquals(1, isWinner(new int[]{10,2,2,3}, new int[]{3,8,4,5}));
        assertEquals(1, isWinner(new int[]{4,10,7,9}, new int[]{6,5,2,3}));
        assertEquals(2, isWinner(new int[]{3,5,7,6}, new int[]{8,10,10,2}));
        assertEquals(0, isWinner(new int[]{2,3}, new int[]{4,1}));
    }
}
