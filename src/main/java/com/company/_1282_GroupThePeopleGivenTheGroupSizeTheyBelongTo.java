package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
public class _1282_GroupThePeopleGivenTheGroupSizeTheyBelongTo {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int curGroupSize = groupSizes[i];
            List<Integer> dest = map.get(curGroupSize);
            if (dest==null) {
                dest = new LinkedList<>();
                dest.add(i);
                if (dest.size()== curGroupSize)
                    res.add(dest);
                else
                    map.put(curGroupSize, dest);
            }
            else {
                dest.add(i);
                if (dest.size()== curGroupSize) {
                    res.add(dest);
                    map.remove(curGroupSize);
                }
            }
        }
        return res;
    }

}
