package com.company;

import java.util.HashSet;

public class _1791_FindCenterOfStarGraph {

    public int findCenter(int[][] edges) {
        HashSet<Integer> integers = new HashSet<>();
        for (int[] edge : edges) {
            for (int i : edge) {
                if (!integers.add(i))
                    return i;
            }
        }
        return 0;
    }
}
