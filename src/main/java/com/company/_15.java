package com.company;

import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _15 {

    /*Time Limit Exceeded
311 / 316 testcases passed*/
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i]+nums[j]+nums[k]==0) {
                        int[] arr = new int[]{nums[i],nums[j],nums[k]};
                        Arrays.sort(arr);
                        List<Integer> l = new LinkedList<>();
                        for (int a: arr)
                            l.add(a);
                        set.add(l);
                    }
                }
            }
        }
        return new LinkedList<>(set);
    }

    @Test
    public void test() {
        assertEquals(new LinkedList<List<Integer>>(), /*new Main().*/threeSum(new int[]{0,1,1}));
        List<List<Integer>> expected = new LinkedList<>();
        List<Integer> first = new LinkedList<>();
        first.add(0);
        first.add(0);
        first.add(0);
        expected.add(first);
        assertEquals(expected, /*new Main().*/threeSum(new int[]{0,0,0}));

        first = new LinkedList<>();
        expected = new LinkedList<>();
        first.add(-1);
        first.add(-1);
        first.add(2);
        expected.add(first);
        List<Integer> second = new LinkedList<>();
        second.add(-1);
        second.add(0);
        second.add(1);
        expected.add(second);
        assertEquals(expected, /*new Main().*/threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
