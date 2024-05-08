package com.company;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

//https://leetcode.com/problems/asteroid-collision/
public class _735_AsteroidCollision {
    /*2194ms
    Beats 5.33%of users with Java*/
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> aList = new LinkedList<>();
        for (int a : asteroids) {
            aList.add(a);
        }
        boolean diffSignsPresent = true;
        while (diffSignsPresent) {
            diffSignsPresent = false;
            for (int i = 0; i < aList.size()-1; i++) {
                Integer cur = aList.get(i);
                Integer next = aList.get(i + 1);
                if ((cur > 0 && next < 0)) {
                    diffSignsPresent = true;
                    if (Math.abs(cur) > Math.abs(next))
                        aList.remove(i+1);
                    if (Math.abs(cur) < Math.abs(next))
                        aList.remove(i);
                    if (Math.abs(cur) == Math.abs(next)) {
                        aList.remove(i+1);
                        aList.remove(i);
                    }
                }
            }
        }
        int[] res = new int[aList.size()];
        for (int i = 0; i < aList.size(); i++) {
            res[i] = aList.get(i);
        }
        return res;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{-2,-1}, asteroidCollision(new int[]{-2,-1,2,-2}));
        assertArrayEquals(new int[]{-2,-1,1,2}, asteroidCollision(new int[]{-2,-1,1,2}));
        assertArrayEquals(new int[]{}, asteroidCollision(new int[]{8,-8}));
        assertArrayEquals(new int[]{5,10}, asteroidCollision(new int[]{5,10,-5}));
        assertArrayEquals(new int[]{10}, asteroidCollision(new int[]{10,2,-5}));
    }
}
