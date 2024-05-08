package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/*287. Find the Duplicate Number
        https://leetcode.com/problems/find-the-duplicate-number/description/?envType=daily-question&envId=2023-09-19*/
public class _287 {

    /*1ms
    Beats 100.00%of users with Java*/

    public int findDuplicate(int[] nums) {
        boolean[] seen = new boolean[nums.length];
        for (int n : nums) {
            if (seen[n])
                return n;
            else
                seen[n] = true;
        }
        return 0;
    }

    @Test
    public void test() {
        assertEquals(2, findDuplicate(new int[]{1,3,4,2,2}));
        assertEquals(3, findDuplicate(new int[]{3,1,3,4,2}));
    }


}
