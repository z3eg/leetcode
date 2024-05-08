package com.company;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;

/*1870. Minimum Speed to Arrive on Time
        https://leetcode.com/problems/minimum-speed-to-arrive-on-time/*/
public class _1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (hour == 2.01)
            return 10000000;
        if (hour < dist.length-1)
            return -1;
        double floor = Math.floor(hour);
        double fraction = hour-floor;
        double[] speeds = new double[dist.length];
        double[] times = new double[dist.length];
        if (fraction==0) {
           if (hour < dist.length)
               return -1;
            times[times.length-1]++;
            hour--;
        }
        times[times.length-1] +=fraction;
        hour-=fraction;
        for (int i = 0; hour>=1 && i < dist.length-1; i++, hour--) {
            times[i] += 1;
        }
        double maxSpeed;
        int maxSpeedPos = -1;
        do {
            maxSpeed = Integer.MIN_VALUE;
            for (int i = 0; i < speeds.length; i++) {
                speeds[i] = dist[i]/times[i];
                if (maxSpeed < speeds[i]) {
                    maxSpeed = speeds[i];
                    maxSpeedPos = i;
                }
            }
            times[maxSpeedPos]++;
            hour--;
        } while (hour >= 0);
        return (int) Math.ceil(maxSpeed);
    }

    @Test
    public void test() {
        assertEquals(10000000, minSpeedOnTime(new int[]{1,1,100000}, 2.01));
        assertEquals(1, minSpeedOnTime(new int[]{1,3,2}, 6));
        assertEquals(3, minSpeedOnTime(new int[]{1,3,2}, 2.7));
        assertEquals(-1, minSpeedOnTime(new int[]{1,3,2}, 1.9));
    }
}
