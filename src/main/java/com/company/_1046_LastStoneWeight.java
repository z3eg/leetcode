package com.company;

import org.junit.Test;

import java.util.LinkedList;

//https://leetcode.com/problems/last-stone-weight
public class _1046_LastStoneWeight {


    public int lastStoneWeight(int[] stones) {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(stones[0]);
        for (int i = 1; i < stones.length; i++) {
            int curStone = stones[i];
            addStone(integers, curStone);
        }
        while (integers.size()>1) {
            int first = integers.getFirst();
            int second = integers.get(1);
            integers.remove(0);
            integers.remove(0);
            addStone(integers, Math.abs(first-second));
        }
        return integers.get(0);
    }

    private void addStone(LinkedList<Integer> integers, int curStone) {
        boolean added = false;
        for (int j = 0; j < integers.size(); j++) {
            if (curStone > integers.get(j)) {
                integers.add(j, curStone);
                added = true;
                break;
            }
        }
        if (!added)
            integers.add(curStone);
    }

    @Test
    public void test() {
        lastStoneWeight(new int[]{2,7,4,1,8,1});
    }
}
