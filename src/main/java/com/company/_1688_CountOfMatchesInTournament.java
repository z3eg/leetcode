package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/count-of-matches-in-tournament/
public class _1688_CountOfMatchesInTournament {

    public int numberOfMatches(int n) {
        int num = 0;
        while (n>1) {
            num+=n/2;
            if (n%2==0) {
                n/=2;
            }
            else {
                n=n/2+1;
            }
        }
        return num;
    }

    @Test
    public void test() {
        assertEquals(6, numberOfMatches(7));
        assertEquals(13, numberOfMatches(14));
    }
}
