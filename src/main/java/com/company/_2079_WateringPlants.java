package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/watering-plants/
public class _2079_WateringPlants {
    /*
        Runtime
        0 ms
        Beats
        100%
    */
    public int wateringPlants(int[] plants, int capacity) {
        int steps = 0;
        int curPos = 0;
        int curCap = capacity;
        while (curPos<plants.length) {
            int curPlant = plants[curPos];
            if (curCap < curPlant) {
                steps+=(curPos)*2;
                curCap = capacity;
            }
            curCap-=curPlant;
            curPos++;
            steps++;
        }
        return steps;
    }


    @Test
    public void test() {
        assertEquals(49, wateringPlants(new int[]{7,7,7,7,7,7,7}, 8));
        assertEquals(14, wateringPlants(new int[]{2,2,3,3}, 5));
        assertEquals(30, wateringPlants(new int[]{1,1,1,4,2,3}, 4));
    }
}
