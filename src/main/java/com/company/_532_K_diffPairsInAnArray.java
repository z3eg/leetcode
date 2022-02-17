package com.company;

import com.sun.source.tree.Tree;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/k-diff-pairs-in-an-array/
public class _532_K_diffPairsInAnArray {

    public int findPairs(int[] nums, int k) {
        int res =0;
        Map<Integer, Integer> frequencyMap = new TreeMap<Integer, Integer>() {
        };
        for (int num : nums) {
            frequencyMap.merge(num, 1, Integer::sum);
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = frequencyMap.entrySet().iterator();
        if (k==0) {
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> curEntry = iterator.next();
                if (curEntry.getValue()>1) {
                    res++;
                }
            }
        } else {
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> curEntry = iterator.next();
                int counterPart = curEntry.getKey() + k;
                if (frequencyMap.containsKey(counterPart)) {
                    res++;
                    iterator.remove();
                }
            }
        }
        return res;
    }

    //more efficient memory-wise
    /*private class Pair {
        int val1;
        int val2;

        public Pair(int val1, int val2) {
            this.val1 = val1;
            this.val2 = val2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return val1==(pair.val1) && val2==(pair.val2) || val1==(pair.val2) && val2==(pair.val1);
        }

        @Override
        public int hashCode() {
            return Math.abs(val1-val2)*val1*val2;
        }
    }

    public int findPairs(int[] nums, int k) {
        HashSet<Pair> uniquePairs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i!=j && Math.abs(nums[i]-nums[j]) == k) {
                    Pair uniquePair = new Pair(nums[i], nums[j]);
                    uniquePairs.add(uniquePair);
                }
            }
        }
        return uniquePairs.size();
    }*/

    //actually passed lmao
    /*public int findPairs(int[] nums, int k) {
        HashSet<List<Integer>> uniquePairs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i!=j && Math.abs(nums[i]-nums[j]) == k) {
                    List<Integer> uniquePair = new LinkedList<>();
                    uniquePair.add(nums[i]);
                    uniquePair.add(nums[j]);
                    List<Integer> sortedPair = uniquePair.stream().sorted().collect(Collectors.toList());
                    uniquePairs.add(sortedPair);
                }
            }
        }
        return uniquePairs.size();
    }*/

    /*@Test
    public void testHashCode() {
        System.out.println(new Pair(3,1).hashCode());
        System.out.println(new Pair(3,4).hashCode());
        System.out.println(new Pair(3,5).hashCode());
        System.out.println(new Pair(1,4).hashCode());
        System.out.println(new Pair(1,1).hashCode());
        System.out.println(new Pair(1,5).hashCode());
        System.out.println(new Pair(4,3).hashCode());
    }*/

    @Test
    public void test() {
        assertEquals(1, findPairs(new int[]{1,1,1,1,1},0));
        assertEquals(2, findPairs(new int[]{-1,-2,-3},1));
        assertEquals(1, findPairs(new int[]{1,3,1,5,4},0));
        assertEquals(4, findPairs(new int[]{1,2,3,4,5},1));
        assertEquals(2, findPairs(new int[]{3,1,4,1,5},2));
    }

}
