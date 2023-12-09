package com.company;

public class _303 {

    /*45
        ms
                Beats
8.97%
        of users with Java*/
    class NumArray {

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
    }
}
