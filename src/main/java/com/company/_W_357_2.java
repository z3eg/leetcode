package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*https://leetcode.com/contest/weekly-contest-357/problems/check-if-it-is-possible-to-split-array/
6953. Check if it is Possible to Split Array*/
public class _W_357_2 {

    /*public boolean canSplitArray(List<Integer> nums, int m) {
        if (nums.size()==1)
            return true;
        int[] arr = new int[nums.size()];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums.get(i);
            sum+=arr[i];
        }
        return canSplitArray(arr, 0, arr.length, m, sum);
    }

    private boolean canSplitArray(int[] arr, int l, int r, int m, int sum) {
        if (r-l<2)
            return true;
        int arr1Sum = 0;
        int arr2Sum = sum;
        for (int i = l; i < r; i++) {
            arr1Sum+=arr[i];
            arr2Sum-=arr[i];
            if ((arr1Sum >=m) && (arr2Sum >=m)) {
                if (canSplitArray(arr, l, i+1, m, arr1Sum) &&
                        canSplitArray(arr, i+1, r, m, arr2Sum))
                    return true;
            }
        }
        return false;
    }*/

    public boolean canSplitArray(List<Integer> nums, int m) {
        int n = nums.size();
        if(n <= 2){
            return true;
        }
        for(int i = 0; i < n -1; i++){
            if(nums.get(i) + nums.get(i + 1) >= m)
                return true;
        }

        return false;
    }

    @Test
    public void test() {
        assertFalse(canSplitArray(Arrays.asList(4,5,1,1,1,1,1,1,1,1,1,1,1,1), 7));
        assertTrue(canSplitArray(Arrays.asList(1,1,2), 3));
        assertFalse(canSplitArray(Arrays.asList(2, 1, 3), 5));
        assertFalse(canSplitArray(Arrays.asList(52, 32, 3, 14, 68, 12, 40, 11, 31, 68, 42, 21, 62, 35, 8, 44, 61, 43, 6, 63, 27, 25, 1, 36, 25, 35), 117));
//        assertTrue(canSplitArray(Arrays.asList(16, 44, 34, 15, 36, 7, 47, 2, 36, 3, 11, 22, 23, 27, 19, 25, 22, 12, 11, 12, 24, 21, 24, 19, 9), 60));
        assertTrue(canSplitArray(Arrays.asList(1,1), 3));
        assertTrue(canSplitArray(Arrays.asList(2, 2, 1), 4));
        assertTrue(canSplitArray(Arrays.asList(2, 3, 3, 2, 3), 6));
    }

}
