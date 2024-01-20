package com.company;

import org.junit.Test;
import scala.Int;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class _907 {

    /*Wrong Answer
73 / 87 testcases passed*/
    /*public int sumSubarrayMins(int[] arr) {
        int MODULO = 1_000_000_000;
        int sum = 0;
        for (int len = 1; len <= arr.length; len++) {
            for (int start = 0; start <= arr.length - len; start++) {
                int min = arr[start];
                for (int i = start+1; i < start+len; i++) {
                    min = Math.min(min,arr[i]);
                }
                sum+=min;
            }
        }
        return sum%MODULO;
    }*/

    /*Time Limit Exceeded
    77 / 87 testcases passed*/
    /*public int sumSubarrayMins(int[] arr) {
        int MODULO = 1_000_000_007;
        int sum = 0;
        for (int len = 1; len <= arr.length; len++) {
            for (int start = 0; start <= arr.length - len; start++) {
                int min = arr[start];
                for (int i = start+1; i < start+len; i++) {
                    min = Math.min(min,arr[i]);
                }
                sum=(sum+min)%MODULO;
            }
        }
        return sum%MODULO;
    }*/

    /*public int sumSubarrayMins(int[] arr) {
        Map<String, Integer> map = new HashMap<>();
        int MODULO = 1_000_000_007;
        int sum = 0;
        for (int len = 1; len <= arr.length; len++) {
            for (int start = 0; start <= arr.length - len; start++) {
                int min;
                String key = start + "_" + (start + len);
                if (map.containsKey(key))
                    min = map.get(key);
                else {
                    min = arr[start];
                    for (int i = start + 1; i < start + len; i++) {
                        min = Math.min(min, arr[i]);
                    }
                    map.put(key,min);
                }
                sum=(sum+min)%MODULO;
            }
        }
        return sum%MODULO;
    }*/

    //TLE
    /*public int sumSubarrayMins(int[] arr) {
        Map<String, Integer> map = new HashMap<>();
        int MODULO = 1_000_000_007;
        int sum = 0;
        for (int len = 1; len <= arr.length; len++) {
            for (int start = 0; start <= arr.length - len; start++) {
                int min = min(start, len, map, arr);
                sum=(sum+min)%MODULO;
            }
        }
        return sum%MODULO;
    }

    int min(int start, int len, Map<String, Integer> map, int[] arr) {
        int min;
        String key = start + "_" + (start + len);
        if (map.containsKey(key))
            min = map.get(key);
        else {
            if (start+1 == arr.length || len==1)
                min = arr[start];
            else
                min = Math.min(arr[start], min(start+1, len-1, map, arr));
            map.put(key,min);
        }
        return min;
    }*/


    //MLE
    public int sumSubarrayMins(int[] arr) {
        int[][] dp = new int[30001][30001];
        int MODULO = 1_000_000_007;
        int sum = 0;
        for (int len = 1; len <= arr.length; len++) {
            for (int start = 0; start <= arr.length - len; start++) {
                int min = min(start, len, dp, arr);
                sum=(sum+min)%MODULO;
            }
        }
        return sum%MODULO;
    }

    int min(int start, int len, int[][] dp, int[] arr) {
        int min;
        if (dp[start][len]!=0)
            min = dp[start][len];
        else {
            if (start+1 == arr.length || len==1)
                min = arr[start];
            else
                min = Math.min(arr[start], min(start+1, len-1, dp, arr));
            dp[start][len] = min;
        }
        return min;
    }


    @Test
    public void test() {
        assertEquals(17, sumSubarrayMins(new int[]{3,1,2,4}));
        assertEquals(444, sumSubarrayMins(new int[]{11,81,94,43,3}));
    }
}
