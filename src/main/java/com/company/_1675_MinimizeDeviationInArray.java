package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _1675_MinimizeDeviationInArray {

    private int max;
    private int min;
    private double avg;
    private double sum;
    private int lastFixPos;
    private int lastFixVal;
    private int lastFixValBefore;

    public int minimumDeviation(int[] nums) {
        lastFixPos = -1;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        double[] deviationsFromAvg = new double[nums.length];
        boolean arrayChanged = true;
        while (arrayChanged) {
            updateDeviation(nums,deviationsFromAvg);
            arrayChanged = fixBiggestDeviation(nums,deviationsFromAvg);
        }
        return max-min;
    }

    private boolean fixBiggestDeviation(int[] nums, double[] deviations) {
        double biggestDeviation = 0;
        int biggestDeviationPos = 0;
        for (int i = 0; i < deviations.length; i++) {
            double curDeviation = deviations[i];
            if ((Math.abs(curDeviation) > biggestDeviation && isFixable(nums[i], curDeviation))) {
                biggestDeviation = Math.abs(curDeviation);
                biggestDeviationPos = i;
            }
        }
        if (biggestDeviation != 0) {
            sum -= nums[biggestDeviationPos];
            if (biggestDeviationPos == lastFixPos && nums[biggestDeviationPos] == lastFixVal) {
                lastFixValBefore = nums[biggestDeviationPos];
            }
            if (nums[biggestDeviationPos] == lastFixValBefore) {
                int valAfterChange = (isEven(nums[biggestDeviationPos])) ? nums[biggestDeviationPos]/2 :
                        nums[biggestDeviationPos]*2;
                if (valAfterChange == lastFixVal) {
                    return false;
                }
            }
            nums[biggestDeviationPos] = (isEven(nums[biggestDeviationPos])) ? nums[biggestDeviationPos]/2 :
                    nums[biggestDeviationPos]*2;
            lastFixPos = biggestDeviationPos;
            lastFixVal = nums[biggestDeviationPos];
            sum += nums[biggestDeviationPos];
            updateMinMax(nums);
            return true;
        }
        return false;
    }

    private boolean isFixable(int num, double deviation) {
        return (isEven(num) && deviation>0) || (!isEven(num) && deviation < 0);
    }

    private boolean isEven(int num) {
        return num%2==0;
    }

    private void updateDeviation(int[] nums, double[] deviations) {
        updateAvg(nums);
        for (int i = 0; i < nums.length; i++) {
            deviations[i] = nums[i]-avg;
        }
    }

    private void updateAvg(int[] nums) {
        if (max == Integer.MIN_VALUE && min == Integer.MAX_VALUE) {
            for (int num : nums) {
                sum += num;
                if (num>max) {
                    max = num;
                }
                if (num<min) {
                    min = num;
                }
            }
        }
        this.avg = sum/nums.length;
    }

    private void updateMinMax(int[] nums) {
        min = nums[0];
        max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
            if (max < nums[i]) {
                max = nums[i];
            }
        }
    }

    @Test
    public void test() {
        assertEquals(1, minimumDeviation(new int[]{1,2,3,4}));
        assertEquals(3, minimumDeviation(new int[]{4,1,5,20,3}));
        assertEquals(3, minimumDeviation(new int[]{2,10,8}));
    }


    /*You are given an array nums of n positive integers

    Example 1:

    Input: nums = [1,2,3,4]
    Output: 1
    Explanation: You can transform the array to [1,2,3,2], then to [2,2,3,2], then the deviation will be 3 - 2 = 1.
    Example 2:

    Input: nums = [4,1,5,20,3]
    Output: 3
    Explanation: You can transform the array after two operations to [4,2,5,5,3], then the deviation will be 5 - 2 = 3.
    Example 3:

    Input: nums = [2,10,8]
    Output: 3


    Constraints:

    n == nums.length
2 <= n <= 105
            1 <= nums[i] <= 109*/
}
