package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/*2251. Number of Flowers in Full Bloom
        https://leetcode.com/problems/number-of-flowers-in-full-bloom/description/?envType=daily-question&envId=2023-10-11*/
public class _2251 {

    /*46 / 52 testcases passed
    TLE*/
    /*public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] res = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < flowers.length; j++) {
                if (people[i] >=flowers[j][0] && people[i] <=flowers[j][1])
                    res[i]++;
            }
        }
        return res;
    }*/


    /*773ms
    Beats 5.00%of users with Java*/
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] res = new int[people.length];
        int[] starts = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            starts[i] = flowers[i][0];
        }
        Arrays.sort(starts);
        int[] ends = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            ends[i] = flowers[i][1]+1;
        }
        Arrays.sort(ends);
        for (int i = 0; i < people.length; i++) {
            int started = bs(starts, 0, starts.length-1, people[i]);
            int ended = bs(ends, 0, ends.length-1, people[i]);
            res[i] = started - ended;
        }
        return res;
    }

    int bs(int[] arr, int l, int r, int n) {
        if (r-l<=1)
        {
            if (n < arr[l])
                return l;
            else if (n < arr[r])
                return r;
            else if (n >= arr[r])
                return r+1;
        }
        int mid = (l+r)/2;
        if (arr[mid]==n) {
           while (mid < arr.length && arr[mid]==n)
               mid++;
           return mid;
        }
        else if (n > arr[mid])
            return bs(arr, mid, r, n);
        else
            return bs(arr, l, mid, n);
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{2,1,1}, fullBloomFlowers(new int[][]{{49,49},{45,48},{5,41},{5,12},{8,21},{34,45},{43,48}}, new int[]{40,49,24}));
        assertArrayEquals(new int[]{1,2,2,2}, fullBloomFlowers(new int[][]{{1,6},{3,7},{9,12},{4,13}}, new int[]{2,3,7,11}));
        assertArrayEquals(new int[]{2,2,1}, fullBloomFlowers(new int[][]{{1,10},{3,3}}, new int[]{3,3,2}));
    }

}
