package com.company;

import scala.Int;

import java.util.*;

public class _15_3Sum {
    /*Time Limit Exceeded
308 / 312 testcases passed*/
    /*public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i]+nums[j]+nums[k]==0) {
                        List<Integer> triplet = new LinkedList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        res.add(triplet);
                    }
                }
            }
        }
        return res;
    }*/

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        /*int l = 0;
        int r = nums.length-1;
        while (r-l>2) {
            if (nums[l])
        }*/
        return res;
    }

}
