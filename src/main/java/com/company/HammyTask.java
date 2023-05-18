package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HammyTask {

    public int getRepeatingNumber(int [] arr) {
        boolean[] booleans = new boolean[10];
        for (int j : arr) {
            if (!booleans[j]) {
                booleans[j] = true;
            } else {
                return j;
            }
        }
        return 0;
    }

    //arr[i] is withing [0...1000]

    @Test
    public void test() {
        assertEquals(1, getRepeatingNumber(new int[]{1,3,6,1,4}));
    }

}
