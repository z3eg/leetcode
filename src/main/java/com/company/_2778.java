package com.company;

public class _2778 {
    /*1
ms
Beats
100.00%
*/
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (n%(i+1)==0)
                sum+=nums[i]*nums[i];
        }
        return sum;
    }
}
