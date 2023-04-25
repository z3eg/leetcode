package com.company;

import java.util.LinkedList;
import java.util.List;

public class _2610_ConvertAnArrayIntoA2DArrayWithConditions {

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        boolean contains = true;
        while (contains) {
            contains = false;
            List<Integer> curRow = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 201 && !curRow.contains(nums[i])) {
                    curRow.add(nums[i]);
                    nums[i] = 201;
                    contains = true;
                }
            }
            if (contains)
                res.add(curRow);
        }
        return res;
    }
}
