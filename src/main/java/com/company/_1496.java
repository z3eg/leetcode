package com.company;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _1496 {

    /*3
    ms
            Beats
51.76%
    of users with Java*/
    public boolean isPathCrossing(String path) {

        int[][] coords = new int[path.length()+1][2];
        int[] coord = new int[2];
        coords[0][0] = coord[0];
        coords[0][1] = coord[1];
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            switch (c) {
                case 'N' -> coord[1]++;
                case 'S' -> coord[1]--;
                case 'E' -> coord[0]++;
                case 'W' -> coord[0]--;
            }
            for (int j = 0; j < i+1; j++) {
                if (coords[j][0]==coord[0] && coords[j][1]==coord[1])
                    return true;
            }
            coords[i+1][0] = coord[0];
            coords[i+1][1] = coord[1];
        }
        return false;
    }

    @Test
    public void test() {
        assertTrue(isPathCrossing("NNEESSWW"));
        assertFalse(isPathCrossing("N"));
        assertFalse(isPathCrossing("NES"));
        assertTrue(isPathCrossing("NESWW"));
        assertTrue(isPathCrossing("NESW"));
    }
}
