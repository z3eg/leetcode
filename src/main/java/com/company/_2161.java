package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/*https://leetcode.com/problems/partition-array-according-to-given-pivot/
        2161. Partition Array According to Given Pivot*/
public class _2161 {

//    TLE
    /*public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> leftPart = new LinkedList<>();
        List<Integer> midPart = new LinkedList<>();
        List<Integer> rightPart = new LinkedList<>();
        for (int n : nums) {
            if (n < pivot) {
                leftPart.add(n);
            }
            else if (n == pivot) {
                midPart.add(n);
            }
            else {
                rightPart.add(n);
            }
        }
        int leftPartSize = leftPart.size();
        for (int i = 0; i < leftPartSize; i++) {
            nums[i] = leftPart.get(i);
        }
        int midPartSize = midPart.size();
        for (int i = 0; i < midPartSize; i++) {
            nums[i+leftPartSize] = midPart.get(i);
        }
        int rightPartStart = leftPartSize + midPartSize;
        int rightPartSize = rightPart.size();
        for (int i = 0; i < rightPartSize; i++) {
            nums[i + rightPartStart] = rightPart.get(i);
        }
        return nums;
    }*/

    //TLE
    /*public int[] pivotArray(int[] nums, int pivot) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < nums.length-1; i++) {
                if (nums[i]>pivot && nums[i+1]<=pivot || nums[i]>=pivot && nums[i+1]<pivot) {
                    int tmp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = tmp;
                    sorted = false;
                }
            }

        }
        return nums;
    }*/

    public int[] pivotArray(int[] nums, int pivot) {
        int numLen = nums.length;
        int[] res = new int[numLen];
        int leftIndex = 0;
        int rightIndex = numLen-1;
        for (int i = 0; i < numLen; i++) {
            if (nums[i] < pivot) {
                res[leftIndex] = nums[i];
                leftIndex++;
            }
            if (nums[numLen-i-1] > pivot) {
                res[rightIndex] = nums[numLen-i-1];
                rightIndex--;
            }
        }
        for (int i = leftIndex; i <= rightIndex; i++) {
            res[i] = pivot;
        }
        return res;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{9,5,3,10,10,12,14}, pivotArray(new int[]{9,12,5,10,14,3,10}, 10));
        assertArrayEquals(new int[]{-3,2,4,3}, pivotArray(new int[]{-3,4,3,2}, 2));
    }
}
