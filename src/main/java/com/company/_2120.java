package com.company;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/*https://leetcode.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid/
2120. Execution of All Suffix Instructions Staying in a Grid*/
public class _2120 {
    /*public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] res = new int[s.length()];
        //precalc shift for each move and go backwards?
        int xShift = 0;
        int yShift = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'L' -> xShift--;
                case 'R' -> xShift++;
                case 'U' -> yShift--;
                case 'D' -> yShift++;
            }

        }
    }*/

    public int[] executeInstructions(int n, int[] startPos, String s) {
        int sLen = s.length();
        int[] res = new int[sLen];
        char[] chars = s.toCharArray();
        for (int i = 0; i < sLen; i++) {
            int y = startPos[0];
            int x = startPos[1];
            int moves = 0;
            for (int j = i; j < sLen; j++) {
                switch (chars[j]) {
                    case 'L' -> x--;
                    case 'R' -> x++;
                    case 'U' -> y--;
                    case 'D' -> y++;
                }
                if (x < 0 || x >= n || y < 0 || y >= n) {
                    res[i] = moves;
                    break;
                } else {
                    moves++;
                }
            }
            res[i] = moves;
        }
        return res;
    }

    @Test
    public void main() {
        assertArrayEquals(new int[]{1,5,4,3,1,0}, executeInstructions(3,new int[]{0,1}, "RRDDLU"));
        assertArrayEquals(new int[]{4,1,0,0}, executeInstructions(2,new int[]{1,1}, "LURD"));
        assertArrayEquals(new int[]{0,0,0,0}, executeInstructions(1,new int[]{0,0}, "LRUD"));
    }
}
