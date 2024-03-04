package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _948 {

    /*2
    ms
            Beats
97.13%
    of users with Java*/
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int maxScore = score;
        int l = 0;
        int r = tokens.length-1;
        while (l <= r) {
            if (tokens[l] <= power) {
                power-=tokens[l];
                score++;
                l++;
                maxScore = Math.max(maxScore, score);
            }
            else if (score>0) {
                power+=tokens[r];
                score--;
                r--;
            }
            else {
                return maxScore;
            }
        }
        return maxScore;
    }

    @Test
    public void test() {
        assertEquals(0, bagOfTokensScore(new int[]{}, 200));
        assertEquals(2, bagOfTokensScore(new int[]{100,200,300,400}, 200));
        assertEquals(0, bagOfTokensScore(new int[]{100}, 50));
        assertEquals(1, bagOfTokensScore(new int[]{200,100}, 150));
    }
}
