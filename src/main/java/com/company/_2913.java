package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _2913 {

    /*108
    ms
    Beats
    8.75%*/
    /*public int sumCounts(List<Integer> nums) {
        int l = 0;
        int r = 0;
        int sum = 0;
        boolean goingLeft = false;
        while (r-l<nums.size()) {
            //calculating the window square bs
            HashSet<Integer> curWindow = new HashSet<>();
            for (int i = l; i <= r; i++) {
                curWindow.add(nums.get(i));
            }
            sum+= curWindow.size()*curWindow.size();
            //updating pointers
            if (!goingLeft) {
                if (r==nums.size()-1)
                {
                    goingLeft = true;
                    l--;
                }
                else {
                    l++;
                    r++;
                }
            }
            else {
                if (l==0) {
                    goingLeft = false;
                    r++;
                }
                else {
                    l--;
                    r--;
                }
            }
        }
        return sum;
    }*/


    /*8
    ms
    Beats
    68.82%
    */
    public int sumCounts(List<Integer> nums) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int[] freqMap = new int[101];
        freqMap[nums.get(0)]++;
        boolean goingLeft = false;
        int uqNums = 1;
        sum = 1;
        while (r-l<nums.size()-1) {
            if (!goingLeft) {
                if (r==nums.size()-1)
                {
                    goingLeft = true;
                    l--;
                    uqNums = add(l, nums, freqMap, uqNums);
                    sum+=uqNums*uqNums;
                }
                else {
                    r++;
                    uqNums = add(r, nums, freqMap, uqNums);
                    uqNums = remove(l, nums, freqMap, uqNums);
                    l++;
                    sum+=uqNums*uqNums;
                }
            }
            else {
                if (l==0) {
                    goingLeft = false;
                    r++;
                    uqNums = add(r, nums, freqMap, uqNums);
                    sum+=uqNums*uqNums;
                }
                else {
                    l--;
                    uqNums = add(l,nums,freqMap,uqNums);
                    uqNums = remove(r,nums,freqMap,uqNums);
                    r--;
                    sum+=uqNums*uqNums;
                }
            }
        }
        return sum;
    }

    int add(int idx, List<Integer> nums, int[] freqMap, int uqNums) {
        freqMap[nums.get(idx)]++;
        //new unique element in the window
        if (freqMap[nums.get(idx)]==1)
            uqNums++;
        return uqNums;
    }

    int remove(int idx, List<Integer> nums, int[] freqMap, int uqNums) {
        freqMap[nums.get(idx)]--;
        //unique element left the window
        if (freqMap[nums.get(idx)]==0)
            uqNums--;
        return uqNums;
    }


    @Test
    public void test(){
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(1);
        assertEquals(15, sumCounts(nums));
        nums = new ArrayList<>();
        nums.add(1);
        nums.add(1);
        assertEquals(3, sumCounts(nums));
    }

}
