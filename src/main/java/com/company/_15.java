package com.company;

import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _15 {

    /*Time Limit Exceeded
311 / 316 testcases passed*/
    /*public List<List<Integer>> threeSum(int[] nums) {
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
    }*/

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length-1;
        boolean moveL = true;
        while ((r-l)>=2) {
            int third = 0-(nums[l]+nums[r]);
            if (bs(l+1,r-1,nums,third))
            {
                List<Integer> triplet = new LinkedList<>();
                triplet.add(nums[l]);
                triplet.add(third);
                triplet.add(nums[r]);
                res.add(triplet);
            }
            if (moveL)
                l++;
            else
                r--;
            moveL = !moveL;
        }
        return new LinkedList<>(res);
    }

    private boolean bs(int l, int r, int[] nums, int wanted) {
        int mid = (r+l)/2;
        if (r-l<=2)
            return nums[l]==wanted || nums[r]==wanted || nums[mid]==wanted;
        else {
            if (nums[mid] > wanted)
                return bs(l,mid,nums,wanted);
            else
                return bs(mid,r,nums,wanted);
        }
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
