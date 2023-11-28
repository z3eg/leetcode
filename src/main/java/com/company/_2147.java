package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class _2147 {

    /*Wrong Answer
117 / 248 testcases passed*/
    /*public int numberOfWays(String corridor) {
        String sim= simplify(corridor);
        int sectionNum = 0;
        for (int i = 0; i < sim.length(); i++) {
            if (sim.charAt(i)=='O')
                sectionNum++;
        }
        if (sectionNum == 0)
            return 0;
        if (sectionNum == 1)
            return 1;
        int firstSectionIndex = sim.indexOf('O');
        int lastSectionIndex = sim.lastIndexOf('O');
        int res = 1;
        int dividers = 1;
        for (int i = firstSectionIndex; i <= lastSectionIndex; i++) {
            if (sim.charAt(i)=='P')
                dividers++;
            else {
                res*=dividers;
                dividers=1;
            }
        }
        return res;
    }*/

    /*Wrong Answer
136 / 248 testcases passed*/
    public int numberOfWays(String corridor) {
        String sim= simplify(corridor);
        if (sim.contains("S"))
            return 0;
        int sectionNum = 0;
        for (int i = 0; i < sim.length(); i++) {
            if (sim.charAt(i)=='O')
                sectionNum++;
        }
        if (sectionNum == 0)
            return 0;
        if (sectionNum == 1)
            return 1;
        int firstSectionIndex = sim.indexOf('O');
        int lastSectionIndex = sim.lastIndexOf('O');
        int res = 1;
        int dividers = 1;
        int MOD = 1_000_000_007;
        for (int i = firstSectionIndex; i <= lastSectionIndex; i++) {
            if (sim.charAt(i)=='P')
                dividers++;
            else {
                res= (res * dividers) % MOD;
                dividers=1;
            }
        }
        return res;
    }

    String simplify(String corridor) {
        //treat pairs of chairs with any number of plants in betwen them as a non-dividable room (O - just so it's different visually from P)
        //simplify it to a string of flowers and solve that
        return corridor.replaceAll("SP*S", "O");
    }

    @Test
    public void testSimplify() {
        assertEquals("OPPO", simplify("SSPPSPS"));
        assertEquals("PPOP", simplify("PPSPSP"));
    }

    @Test
    public void test() {
        assertEquals(3, numberOfWays("SSPPSPS"));
        assertEquals(1, numberOfWays("PPSPSP"));
        assertEquals(0, numberOfWays("S"));
    }
}
