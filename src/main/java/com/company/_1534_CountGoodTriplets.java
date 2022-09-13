package com.company;

import java.util.Arrays;

//https://leetcode.com/problems/count-good-triplets/
public class _1534_CountGoodTriplets {

    //TODO optimize
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        // Arrays.sort(arr);
        int num = 0;
        for (int i = 0; i < arr.length-2; i++) {
            for (int j = i+1; j < arr.length-1; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    if (Math.abs(arr[j]-arr[i]) <= a && Math.abs(arr[k]-arr[j]) <= b && Math.abs(arr[k]-arr[i]) <= c)
                        num++;
                }
            }
        }
        return num;
    }
}
