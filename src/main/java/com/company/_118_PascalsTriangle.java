package com.company;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle/
public class _118_PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> firstRow = new LinkedList<>();
        firstRow.add(1);
        res.add(firstRow);
        if (numRows==1)
            return res;
        LinkedList<Integer> secondRow = new LinkedList<>();
        secondRow.add(1);
        secondRow.add(1);
        res.add(secondRow);
        for (int i = 2; i < numRows; i++) {
            List<Integer> newRow = new LinkedList<>();
            List<Integer> prevRow = res.get(res.size() - 1);
            newRow.add(1);
            for (int j = 1; j < prevRow.size(); j++) {
                newRow.add(prevRow.get(j-1)+prevRow.get(j));
            }
            newRow.add(1);
            res.add(newRow);
        }
        return res;
    }
}
