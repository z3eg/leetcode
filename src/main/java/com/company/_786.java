package com.company;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class _786 {

    /*Time Limit Exceeded
58 / 59 testcases passed*/
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        TreeMap<Double, int[]> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i!=j) {
                    map.put((double) arr[i] / arr[j], new int[]{arr[i],arr[j]});
                }
            }
        }
        int pos = 1;
        Iterator<Map.Entry<Double, int[]>> iterator = map.entrySet().iterator();
        while (iterator.hasNext() && pos<k) {
            iterator.next();
            pos++;

        }
        return iterator.next().getValue();
    }
}
