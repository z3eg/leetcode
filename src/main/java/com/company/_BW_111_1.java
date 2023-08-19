package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*6954. Count Pairs Whose Sum is Less than Target
        https://leetcode.com/contest/biweekly-contest-111/problems/count-pairs-whose-sum-is-less-than-target/*/
public class _BW_111_1 {
    public int countPairs(List<Integer> nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i+1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target)
                    res++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(0, countPairs(Arrays.asList(-1), 2));
        assertEquals(0, countPairs(Arrays.asList(-1), -6));
        assertEquals(3, countPairs(Arrays.asList(-1,1,2,3,1), 2));
        assertEquals(10, countPairs(Arrays.asList(-6,2,5,-2,-7,-1,3), -2));
    }
}
