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
    class NumArray {

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
    }
}
