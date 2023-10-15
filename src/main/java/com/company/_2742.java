package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/*2742. Painting the Walls
        https://leetcode.com/problems/painting-the-walls/description/?envType=daily-question&envId=2023-10-14*/
public class _2742 {
    public int paintWalls(int[] cost, int[] time) {
        double[] costToTimeRatio = new double[cost.length];
        int totalTime = 0;
        for (int i = 0; i < cost.length; i++) {
            costToTimeRatio[i] = (double) cost[i] /time[i];
            totalTime += time[i];
        }
        //sort
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < costToTimeRatio.length - 1; i++) {
                if (costToTimeRatio[i] > costToTimeRatio[i+1]) {
                    double tmp = costToTimeRatio[i];
                    costToTimeRatio[i] = costToTimeRatio[i+1];
                    costToTimeRatio[i+1] = tmp;
                    int costTmp = cost[i];
                    cost[i] = cost[i+1];
                    cost[i+1] = costTmp;
                    costTmp = time[i];
                    time[i] = time[i+1];
                    time[i+1] = costTmp;
                }
            }
        }
        int curCost = 0;
        int curTime = 0;
        int i = 0;
        while (curTime < totalTime/2) {
            curTime+=time[i];
            curCost+=cost[i];
            i++;
        }
        return curCost;
    }

    @Test
    public void test() {
        assertEquals(3, paintWalls(new int[]{1,2,3,2}, new int[]{1,2,3,2}));
        assertEquals(4, paintWalls(new int[]{2,3,4,2}, new int[]{1,1,1,1}));
    }
}
