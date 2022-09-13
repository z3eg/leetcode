package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/find-target-indices-after-sorting-array/
public class _2089_FindTargetIndicesAfterSortingArray {

    public List<Integer> targetIndices(int[] nums, int target) {
        LinkedList<Integer> res = new LinkedList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == target)
                res.add(i);
        }
        return res;
    }
}
