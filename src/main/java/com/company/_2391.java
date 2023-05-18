package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/
2391. Minimum Amount of Time to Collect Garbage*/
public class _2391 {

    //beats 74.92% runtime
    /*public int garbageCollection(String[] garbage, int[] travel) {
        int res = 0;
        int curM = 0;
        int curG = 0;
        int curP = 0;
        for (int i = 0; i < travel.length; i++) {
            if (garbage[i].contains("M")) {
                res+=curM;
                curM=0;
            }
            if (garbage[i].contains("G")) {
                res+=curG;
                curG=0;
            }
            if (garbage[i].contains("P")) {
                res+=curP;
                curP=0;
            }
            res+=garbage[i].length();
            curM+=travel[i];
            curG+=travel[i];
            curP+=travel[i];
        }
        if (garbage[garbage.length-1].contains("M")) {
            res+=curM;
        }
        if (garbage[garbage.length-1].contains("G")) {
            res+=curG;
        }
        if (garbage[garbage.length-1].contains("P")) {
            res+=curP;
        }
        res+=garbage[garbage.length-1].length();
        return res;
    }*/

    //beats 94.44%
    public int garbageCollection(String[] garbage, int[] travel) {
        int res = 0;
        int gLenMin1 = garbage.length - 1;
        boolean countP = garbage[gLenMin1].contains("P");
        boolean countG = garbage[gLenMin1].contains("G");
        boolean countM = garbage[gLenMin1].contains("M");
        res+=garbage[gLenMin1].length();
        int tLenMin1 = travel.length - 1;
        for (int i = tLenMin1; i >=0 ; i--) {
            res+=garbage[i].length();
            if (countP)
                res+=travel[i];
            if (countG)
                res+=travel[i];
            if (countM)
                res+=travel[i];
            if (!countP)
                countP=garbage[i].contains("P");
            if (!countG)
                countG=garbage[i].contains("G");
            if (!countM)
                countM=garbage[i].contains("M");
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(21, garbageCollection(new String[]{"G","P","GP","GG"}, new int[]{2,4,3}));
        assertEquals(37, garbageCollection(new String[]{"MMM","PGM","GP"}, new int[]{3,10}));
    }
}
