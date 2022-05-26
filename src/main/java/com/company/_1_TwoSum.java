package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


//https://leetcode.com/problems/two-sum/
public class _1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int start = 0;
        while (start!=nums.length-1) {
            for (int i = start+1; i < nums.length; i++) {
                int dif = target - nums[start];
                if (nums[i] == dif) {
                    result[0] = start;
                    result[1] = i;
                    return result;
                }
            }
            start++;
        }
        return result;
    }

    /*Example 1:

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    Example 2:

    Input: nums = [3,2,4], target = 6
    Output: [1,2]
    Example 3:

    Input: nums = [3,3], target = 6
    Output: [0,1]
*/

    @Test
    public void test() {
        int[] res1 = twoSum(new int[]{2, 7, 11, 15}, 9);
        Arrays.sort(res1);
        assertArrayEquals(new int[]{0,1}, res1);
        int[] res2 = twoSum(new int[]{3, 2, 4}, 6);
        Arrays.sort(res2);
        assertArrayEquals(new int[]{1,2}, res2);
        int[] res3 = twoSum(new int[]{3, 3}, 6);
        Arrays.sort(res3);
        assertArrayEquals(new int[]{0,1}, res3);
    }
}
