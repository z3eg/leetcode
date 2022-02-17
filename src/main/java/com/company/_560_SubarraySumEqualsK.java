package com.company;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/subarray-sum-equals-k/
public class _560_SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int numOfSubArrays = 0;
        int sum = 0;
        List<Integer> sums = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int counterPart = k-nums[i];
            if (sums.contains(counterPart)) {
                numOfSubArrays++;
            }
            sum+=nums[i];
            sums.add(sum);
        }
        return numOfSubArrays;
    }

    //actually passed lmao, though not optimal: 1k+ ms
    /*public int subarraySum(int[] nums, int k) {
        int numOfSubArrays = 0;
        for (int i = 0; i < nums.length; i++) {
            int localSum = 0;
            int curRightPos = i;
            do {
                localSum+=nums[curRightPos];
                curRightPos++;
                if (localSum==k) {
                    numOfSubArrays++;
                }
            } while (curRightPos<nums.length);
        }
        return numOfSubArrays;
    }*/

    @Test
    public void test() {
        assertEquals(3, subarraySum(new int[]{1,-1,0}, 0));
        assertEquals(1, subarraySum(new int[]{-1,-1,1}, 0));
        assertEquals(2, subarraySum(new int[]{1,1,1}, 2));
        assertEquals(2, subarraySum(new int[]{1,2,3}, 3));
    }

    /*
    Constraints:

            1 <= nums.length <= 2 * 104
            -1000 <= nums[i] <= 1000
            -107 <= k <= 107*/
}
