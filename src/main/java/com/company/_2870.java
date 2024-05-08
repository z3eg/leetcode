package com.company;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class _2870 {
    //Wrong Answer
    //488 / 747 testcases passed
    /*public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            Integer freq = map.get(n);
            if (freq == null)
                freq = 0;
            freq++;
            map.put(n, freq);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            Integer val = e.getValue();
            while (val>0) {
                if (val % 3 == 0) {
                    res += val / 3;
                    val = 0;
                }
                else if (val % 2 ==0) {
                    res += val / 2;
                    val = 0;
                }
                else if (val<=1)
                    return -1;
                else {
                    val -= 3;
                    res++;
                }
            }
        }
        return res;
    }*/

    /*20
    ms
            Beats
56.98%
    of users with Java*/
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            Integer freq = map.get(n);
            if (freq == null)
                freq = 0;
            freq++;
            map.put(n, freq);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            Integer val = e.getValue();
            while (val>4) {
                if (val % 3 == 0) {
                    res += val / 3;
                    val = 0;
                }
                else {
                    val -= 3;
                    res++;
                }
            }
            if (val==4)
                res+=2;
            else if (val==3)
                res++;
            else if (val==2)
                res++;
            else if (val==0)
                res+=0;
            else
                return -1;
        }
        return res;
    }


    @Test
    public void test() {
        assertEquals(4, minOperations(new int[]{2,3,3,2,2,4,2,3,4}));
        assertEquals(-1, minOperations(new int[]{2,1,2,2,3,3}));
        assertEquals(1, minOperations(new int[]{1,1,1}));
        assertEquals(1, minOperations(new int[]{1,1}));
        assertEquals(2, minOperations(new int[]{1,1,1,1}));
        assertEquals(2, minOperations(new int[]{1,1,1,1,1}));
        assertEquals(2, minOperations(new int[]{1,1,1,1,1,1}));
    }
}
