package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _1422 {

    /*Wrong Answer
96 / 104 testcases passed*/
    /*public int maxScore(String s) {
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='1') {
                score++;
            }
        }
        int max_score = score-1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='0') {
                score++;
                max_score = Math.max(score, max_score);
            }
            else {
                score--;
            }
        }
        return max_score;
    }*/


    /*1
    ms
            Beats
97.78%
    of users with Java*/
    public int maxScore(String s) {
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='1') {
                score++;
            }
        }
        if (s.charAt(0)=='0') {
            score++;
        }
        else {
            score--;
        }
        int max_score = score;
        for (int i = 1; i < s.length()-1; i++) {
            if (s.charAt(i)=='0') {
                score++;
                max_score = Math.max(score, max_score);
            }
            else {
                score--;
            }
        }
        return max_score;
    }

    @Test
    public void test() {
        assertEquals(3, maxScore("111001"));
        assertEquals(5, maxScore("011101"));
        assertEquals(5, maxScore("00111"));
        assertEquals(3, maxScore("1111"));
    }
}
