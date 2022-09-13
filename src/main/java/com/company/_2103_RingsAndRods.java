package com.company;

//https://leetcode.com/problems/rings-and-rods/
public class _2103_RingsAndRods {

    //TODO optimize
    public int countPoints(String rings) {
        int res = 0;
        for (int i = 0; i < 10; i++) {
            if (rings.contains("R"+i) && rings.contains("G"+i) && rings.contains("B"+i))
                res++;
        }
        return res;
    }

}
