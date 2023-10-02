package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/*https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
        2038. Remove Colored Pieces if Both Neighbors are the Same Color*/
public class _2038 {

    /*21ms
    Beats 6.58%of users with Java*/
    /*public boolean winnerOfGame(String colors) {
        if (colors.length()<3)
            return false;
        int aMoves = 0;
        int bMoves = 0;
        for (int i = 1; i < colors.length() - 1; i++) {
            if (colors.charAt(i)=='A' && colors.charAt(i-1)=='A' && colors.charAt(i+1)=='A')
                aMoves++;
            if (colors.charAt(i)=='B' && colors.charAt(i-1)=='B' && colors.charAt(i+1)=='B')
                bMoves++;
        }
        return aMoves > bMoves;
    }*/

    /*10ms
    Beats 83.31%of users with Java*/
    /*9ms
    Beats 87.14%of users with Java*/

    public boolean winnerOfGame(String colors) {
        if (colors.length()<3)
            return false;
        int aMoves = 0;
        int bMoves = 0;
        char[] cA = colors.toCharArray();
        for (int i = 1; i < colors.length() - 1; i++) {
            if (cA[i]=='A' && cA[i-1]=='A' && cA[i+1]=='A')
                aMoves++;
            if (cA[i]=='B' && cA[i-1]=='B' && cA[i+1]=='B')
                bMoves++;
        }
        return aMoves > bMoves;
    }

    @Test
    public void test() {
        assertTrue(winnerOfGame("AAABABB"));
        assertFalse(winnerOfGame("AA"));
        assertFalse(winnerOfGame("ABBBBBBBAAA"));
    }
}
