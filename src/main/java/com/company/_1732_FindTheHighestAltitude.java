package com.company;

//https://leetcode.com/problems/find-the-highest-altitude/
public class _1732_FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int highest = 0;
        int start = 0;
        for (int i = 0; i < gain.length; i++) {
            start+=gain[i];
            highest = Math.max(highest, start);
        }
        return highest;
    }
}
