package com.company;

import java.util.HashMap;
import java.util.Map;

public class _303 {

    /*45
        ms
                Beats
8.97%
        of users with Java*/
    /*class NumArray {

        int[] arr;

        public NumArray(int[] nums) {
            arr = nums;
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            for (int i = left; i <= right ; i++) {
                sum+=arr[i];
            }
            return sum;
        }
    }*/

    /*56
    ms
            Beats
5.73%
    of users with Java*/
    /*class NumArray {

        int[] arr;

        Map<int[], Integer> map = new HashMap<>();

        public NumArray(int[] nums) {
            arr = nums;
        }

        public int sumRange(int left, int right) {
            int[] key = new int[]{left, right};
            Integer val = map.get(key);
            if (val!=null)
                return val;
            int sum = 0;
            for (int i = left; i <= right ; i++) {
                sum+=arr[i];
            }
            map.put(key,sum);
            return sum;
        }
    }*/


//    Memory Limit Exceeded
    class NumArray {

        int[][] sums = new int[10000][10000];

        public NumArray(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    for (int k = i; k <= j; k++) {
                        sums[i][j]+=nums[k];
                    }
                }
            }
        }

        public int sumRange(int left, int right) {
            return sums[left][right];
        }
    }
}
