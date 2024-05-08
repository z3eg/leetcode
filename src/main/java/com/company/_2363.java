package com.company;

import java.util.*;

/*2363. Merge Similar Items
        https://leetcode.com/problems/merge-similar-items/*/
public class _2363 {

    /*8ms
    Beats 82.36%of users with Java*/
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer,Integer> map = new TreeMap<>();
        for (int[] item : items1) {
            map.put(item[0], item[1]);
        }
        for (int[] item : items2) {
            Integer itemVal = map.get(item[0]);
            map.put(item[0], itemVal ==null?item[1]:itemVal+item[1]);
        }
        List<List<Integer>> res = new LinkedList<>();
        for (Map.Entry e : map.entrySet()) {
            List list = new ArrayList();
            list.add(e.getKey());
            list.add(e.getValue());
            res.add(list);
        }
        return res;
    }
}
