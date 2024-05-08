package com.company;

import java.util.*;

/*442. Find All Duplicates in an Array
        https://leetcode.com/problems/find-all-duplicates-in-an-array/description/*/
public class _442 {
    /*Time Limit Exceeded
    25 / 28 testcases passed*/
    /*public List<Integer> findDuplicates(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            list.add(n);
            set.add(n);
        }
        for (Integer next : set) {
            list.remove(next);
        }
        return list;
    }*/

    /*7ms
    Beats 47.33%of users with Java*/
    public List<Integer> findDuplicates(int[] nums) {
        int[] arr = new int[100001];
        for (int n : nums) {
            arr[n]++;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>1)
                list.add(i);
        }
        return list;
    }
}
