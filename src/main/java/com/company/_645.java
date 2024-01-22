package com.company;

import org.junit.Test;

public class _645 {

    /*Wrong Answer
13 / 49 testcases passed*/
    public int[] findErrorNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=i+1)
                return new int[]{nums[i],i+1};
        }
        return new int[2];
    }

}
