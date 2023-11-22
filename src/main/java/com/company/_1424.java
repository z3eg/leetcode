package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _1424 {

    /*Wrong Answer
26 / 56 testcases passed*/
    /*public int[] findDiagonalOrder(List<List<Integer>> nums) {
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
    }*/


    /*Time Limit Exceeded
    53 / 56 testcases passed*/
    /*public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int max = 0;
        List<Integer> resList = new LinkedList<>();
        int numSize = nums.size();
        for (int i = 0; i < numSize; i++) {
            max = Math.max(max, nums.get(i).size());
            for (int j = 0; j <= i; j++) {
                List<Integer> list = nums.get(i-j);
                if (list.size()>j)
                    resList.add(list.get(j));
            }
        }
        for (int c = 1; c < max; c++) {
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
    }*/

        /*Wrong Answer
    55 / 56 testcases passed*/
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int arrLen = 0;
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            arrLen+= list.size();
            for (int j = 0; j < list.size(); j++) {
                List<Integer> val = map.get(i + j);
                if (val==null) {
                    val = new LinkedList<>();
                }
                val.add(list.get(j));
                map.put(i+j, val);
            }
        }
        int[] arr = new int[arrLen];
        int index = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            for (int i = value.size()-1; i >= 0; i--) {
                arr[index] = value.get(i);
                index++;
            }
        }
        return arr;
    }
}
