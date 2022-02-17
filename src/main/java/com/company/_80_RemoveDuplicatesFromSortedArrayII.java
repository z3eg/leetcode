package com.company;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
public class _80_RemoveDuplicatesFromSortedArrayII {

    //actually worked from the first try, LMAO
    public int removeDuplicates(int[] nums) {
        int k = nums.length;
        int i = 0;
        int positionToShiftTo = 0;
        while (i < k) {
            int curNum = nums[i];
            int curNumTimes = 0;
            int positionCount = 0;
            while (i<k && nums[i] == curNum) {
                curNumTimes++;
                if (curNumTimes == 3) {
                    positionToShiftTo = i;
                }
                if (curNumTimes>2) {
                    positionCount++;
                }
                i++;
            }
            k-=positionCount;
            i-=positionCount;
            shiftElements(nums, positionToShiftTo, positionCount);
        }
        return k;
    }

    private void shiftElements(int[] nums, int posTo, int positionsCount) {
        for (int i = posTo+positionsCount; i < nums.length; i++) {
            nums[i-positionsCount] = nums[i];
        }
    }

    @Test
    public void testShiftElements() {
        int[] nums = new int[]{1,1,1,2,2,3};
        shiftElements(nums, 2, 1);
        assertArrayEquals(new int[]{1,1,2,2,3,3},nums);
    }


    @Test
    public void test() {
        //example 1
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = removeDuplicates(nums);
        assertArrayEquals(new int[]{1,1,2,2,3,3},nums);
        assertEquals(5,k);
        //example 2
        nums = new int[]{0,0,1,1,1,1,2,3,3};
        k = removeDuplicates(nums);
        assertArrayEquals(new int[]{0,0,1,1,2,3,3,3,3},nums);
        assertEquals(7,k);
    }
}
