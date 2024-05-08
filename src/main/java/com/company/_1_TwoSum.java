package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


//https://leetcode.com/problems/two-sum/
public class _1_TwoSum {

    /*44ms
    Beats 52.09%of users with Java*/
    /*public int[] twoSum(int[] nums, int target) {
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
    }*/


    /*1ms
    Beats 99.36%of users with Java*/
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key),i};
            }
            else {
                map.put(nums[i], i);
            }
        }
        return new int[]{0,1};
    }

    @Test
    public void test() {
        int[] res2 = twoSum(new int[]{3, 2, 4}, 6);
        Arrays.sort(res2);
        int[] res1 = twoSum(new int[]{2, 7, 11, 15}, 9);
        Arrays.sort(res1);
        assertArrayEquals(new int[]{0,1}, res1);
        assertArrayEquals(new int[]{1,2}, res2);
        int[] res3 = twoSum(new int[]{3, 3}, 6);
        Arrays.sort(res3);
        assertArrayEquals(new int[]{0,1}, res3);
    }
}
