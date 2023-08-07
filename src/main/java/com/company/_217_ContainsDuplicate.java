package com.company;

import java.util.HashSet;

//https://leetcode.com/problems/contains-duplicate/
public class _217_ContainsDuplicate {
    /*9ms
    Beats 93.21%of users with Java*/
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n))
                return true;
            set.add(n);
        }
        return false;
    }
}
