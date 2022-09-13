package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/number-of-arithmetic-triplets/
public class _2367_NumberOfArithmeticTriplets {
    //1ms but can be optimized
    /*public int arithmeticTriplets(int[] nums, int diff) {
        int res = 0;

        int numLen = nums.length;
        for (int i = 0; i < numLen - 2; i++) {
            int first = nums[i];
            int second = first + diff;
            int third = first + diff + diff;
            if (binarySearch(nums, second, i, numLen)!=-1 &&
                    binarySearch(nums, third, i, numLen)!=-1)
                res++;
        }
        return res;
    }*/

    //still 1ms but should be waaay faster on big diff sizes
    public int arithmeticTriplets(int[] nums, int diff) {
        int res = 0;

        int numLen = nums.length;
        for (int i = 0; i < numLen - 2; i++) {
            int first = nums[i];
            int second = first + diff;
            int third = first + diff + diff;
            int secondPos = binarySearch(nums, second, i, numLen);
            if (secondPos !=-1 &&
                    binarySearch(nums, third, secondPos, numLen)!=-1)
                res++;
        }
        return res;
    }


    int binarySearch(int[] nums, int value, int start, int end) {
        if (end<start)
            return -1;
        int curIndex = start+(end-start)/2;
        int curItem = nums[curIndex];
        if (end-start==1) {
            if (curItem!=value) {
                return -1;
            }
        }
        if (value==curItem) {
            return curIndex;
        }
        if (value < curItem)
            return binarySearch(nums, value, start, curIndex);
        else
            return binarySearch(nums, value, curIndex, end);
    }

    @Test
    public void testBinary() {
        int[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] ints2 = {-10, -8, -6, -5, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(0, binarySearch(ints2, -10, 0, ints2.length));
        assertEquals(4, binarySearch(ints2, 4, 0, ints2.length));
        assertEquals(10, binarySearch(ints2, 10, 0, ints2.length));
        assertEquals(0, binarySearch(ints, 0, 0, ints.length));
        assertEquals(2, binarySearch(ints, 2, 0, ints.length));
        assertEquals(6, binarySearch(ints, 6, 0, ints.length));
        assertEquals(5, binarySearch(ints, 5, 0, ints.length));
        assertEquals(7, binarySearch(ints, 7, 0, ints.length));
        assertEquals(-1, binarySearch(ints, 11, 0, ints.length));
        assertEquals(-1, binarySearch(ints, 17, 0, ints.length));
        assertEquals(10, binarySearch(ints, 10, 0, ints.length));
        assertEquals(-1, binarySearch(ints, -10, 0, ints.length));
        assertEquals(-1, binarySearch(ints, -1, 0, ints.length));
    }

    @Test
    public void test() {
        assertEquals(2, arithmeticTriplets(new int[]{0,1,4,6,7,10}, 3));
        assertEquals(2, arithmeticTriplets(new int[]{4,5,6,7,8,9}, 2));
    }

    /*Example 1:

Input: nums = [0,1,4,6,7,10], diff = 3
Output: 2
Explanation:
(1, 2, 4) is an arithmetic triplet because both 7 - 4 == 3 and 4 - 1 == 3.
(2, 4, 5) is an arithmetic triplet because both 10 - 7 == 3 and 7 - 4 == 3.
Example 2:

Input: nums = [4,5,6,7,8,9], diff = 2
Output: 2
Explanation:
(0, 2, 4) is an arithmetic triplet because both 8 - 6 == 2 and 6 - 4 == 2.
(1, 3, 5) is an arithmetic triplet because both 9 - 7 == 2 and 7 - 5 == 2.


Constraints:

3 <= nums.length <= 200
0 <= nums[i] <= 200
1 <= diff <= 50
nums is strictly increasing.*/
}
