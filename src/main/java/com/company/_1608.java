package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _1608 {

    /*2
    ms
    Beats
    47.70%
    of users with Java*/
    public int specialArray(int[] nums) {
        for (int i = 1; i <= nums.length; i++) {
            int counter = 0;
            for (int n : nums) {
                if (n >= i)
                    counter++;
                if (counter> i)
                    break;
            }
            if (counter==i)
                return i;
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(2, specialArray(new int[]{3,5}));
        assertEquals(-1, specialArray(new int[]{0,0}));
        assertEquals(3, specialArray(new int[]{0,4,3,0,4}));
    }

}
