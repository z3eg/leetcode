package com.company;

import java.util.LinkedList;
import java.util.List;

public class _1424 {

    /*Wrong Answer
26 / 56 testcases passed*/
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> resList = new LinkedList<>();
        int numSize = nums.size();
        for (int i = 0; i < numSize; i++) {
            for (int j = 0; j <= i; j++) {
                List<Integer> list = nums.get(i-j);
                if (list.size()>j)
                    resList.add(list.get(j));
            }
        }
        for (int c = 1; c < nums.get(numSize - 1).size(); c++) {
            for (int r = 0; r < numSize; r++) {
                List<Integer> list = nums.get(numSize-1-r);
                int cc = c+r;
                if (list.size()>cc)
                    resList.add(list.get(cc));
            }
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}
