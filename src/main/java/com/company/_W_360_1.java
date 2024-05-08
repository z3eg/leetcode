package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*https://leetcode.com/contest/weekly-contest-360/problems/furthest-point-from-origin/
        8015. Furthest Point From Origin*/
public class _W_360_1 {

    public int furthestDistanceFromOrigin(String moves) {
        int dashes = 0;
        int pos = 0;
        for (char c : moves.toCharArray()) {
            if (c=='L')
                pos--;
            if (c=='R')
                pos++;
            if (c=='_')
                dashes++;
        }
        return Math.abs(pos)+dashes;
    }

    @Test
    public void test() {
        assertEquals(1,furthestDistanceFromOrigin("_"));
        assertEquals(1,furthestDistanceFromOrigin("L"));
        assertEquals(1,furthestDistanceFromOrigin("R"));
        assertEquals(3,furthestDistanceFromOrigin("L_RL__R"));
        assertEquals(5,furthestDistanceFromOrigin("_R__LL_"));
        assertEquals(7,furthestDistanceFromOrigin("_______"));
    }
}
