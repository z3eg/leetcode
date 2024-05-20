package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*1863. Sum of All Subset XOR Totals
        https://leetcode.com/problems/sum-of-all-subset-xor-totals/*/
public class _1863 {

    /*0 / 48 testcases passed*/
    public int subsetXORSum(int[] nums) {
        //find all possible subsets
        List<List<Integer>> foundSubsets = new LinkedList<>();
        LinkedList<Integer> currentSubset = new LinkedList<>();
        LinkedList<Integer> elementsLeft = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            elementsLeft.add(nums[i]);
        }
        addMissingSubset(foundSubsets, elementsLeft, currentSubset);
        //iterate over ^, count XOR and add to sum
        return 0;
    }

    /*backtracking seems to be working properly, but the problem descriprion contradicts itself. [1,3] but no [3,1] in the example
    even though they state the following:
    Note: Subsets with the same elements should be counted multiple times.*/
    private void addMissingSubset(List<List<Integer>> foundSubsets, List<Integer> elementsLeft, List<Integer> currentSubset) {
        for (Integer i : elementsLeft) {
            LinkedList<Integer> newElementsLeft = new LinkedList<>(elementsLeft);
            LinkedList<Integer> newCurrentSubset = new LinkedList<>(currentSubset);
            newCurrentSubset.add(i);
            newElementsLeft.remove(i);
            foundSubsets.add(newCurrentSubset);
            addMissingSubset(foundSubsets, newElementsLeft, newCurrentSubset);
        }
    }

    @Test
    public void test() {
        assertEquals(6, subsetXORSum(new int[]{1,3}));
        assertEquals(28, subsetXORSum(new int[]{5,1,6}));
        assertEquals(480, subsetXORSum(new int[]{3,4,5,6,7,8}));
    }
}
