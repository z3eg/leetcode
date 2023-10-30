package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class _1356 {
    /*892ms
    Beats 5.09%of users with Java*/
    public int[] sortByBits(int[] arr) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (getBits(arr[i]) > getBits(arr[i+1]) || (getBits(arr[i]) == getBits(arr[i+1]) && (arr[i]>arr[i+1]))) {
                    sorted = false;
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
        }
        return arr;
    }

    public int getBits(int n) {
        int count = 0;
        while (n>=1) {
            count+=n%2;
            n/=2;
        }
        return count;
    }

    @Test
    public void testGetBits() {
        assertEquals(0, getBits(0));
        assertEquals(1, getBits(1));
        assertEquals(1, getBits(2));
        assertEquals(1, getBits(4));
        assertEquals(1, getBits(8));
        assertEquals(2, getBits(3));
        assertEquals(2, getBits(5));
        assertEquals(2, getBits(6));
        assertEquals(3, getBits(7));
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{0,1,2}, sortByBits(new int[]{0,2,1}));
        assertArrayEquals(new int[]{0,1}, sortByBits(new int[]{1,0}));
        assertArrayEquals(new int[]{15}, sortByBits(new int[]{15}));
        assertArrayEquals(new int[]{0,1,2,4,8,3,5,6,7}, sortByBits(new int[]{0,1,2,3,4,5,6,7,8}));
        assertArrayEquals(new int[]{1,2,4,8,16,32,64,128,256,512,1024}, sortByBits(new int[]{1024,512,256,128,64,32,16,8,4,2,1}));
    }
}
