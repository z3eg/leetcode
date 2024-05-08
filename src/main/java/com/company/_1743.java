package com.company;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;

public class _1743 {

    /*260ms
    Beats 5.26%of users with Java*/
    /*public int[] restoreArray(int[][] adjacentPairs) {
        int[][] map = new int[200001][2];
        Set<Integer> set = new HashSet<>();
        for (int[] pair :adjacentPairs) {
            int i = pair[0]+100000;
            if (map[i][0]==0)
                map[i][0] = pair[1];
            else
                map[i][1] = pair[1];

            i = pair[1]+100000;
            if (map[i][0]==0)
                map[i][0] = pair[0];
            else
                map[i][1] = pair[0];

            if (set.contains(pair[0]))
                set.remove(pair[0]);
            else
                set.add(pair[0]);
            if (set.contains(pair[1]))
                set.remove(pair[1]);
            else
                set.add(pair[1]);
        }
        Iterator<Integer> iterator = set.iterator();
        int start = iterator.next();
        int end = iterator.next();
        int[] res = new int[adjacentPairs.length+1];
        res[0] = start;
        res[res.length-1] = end;
        int counter = 1;
        int prev = Integer.MIN_VALUE;
        int[] next;
        int nextNum;
        while (start!=end && counter< res.length) {
            next = map[start+100000];
            nextNum = next[(next[0]==prev)?1:0];
            prev = start;
            start = nextNum;
            res[counter] = start;
            counter++;
        }
        return res;
    }*/

    public int[] restoreArray(int[][] adjacentPairs) {
        int[] res = new int[adjacentPairs.length+1];
        Map<Integer, int[]> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int[] pair: adjacentPairs) {
            int[] zpair = map.get(pair[0]);
            if (zpair == null) {
                zpair = new int[2];
                zpair[0] = pair[1];
            }
            else {
                zpair[1] = pair[1];
            }
            map.put(pair[0], zpair);

            int[] opair = map.get(pair[1]);
            if (opair == null) {
                opair = new int[2];
                opair[0] = pair[0];
            }
            else {
                opair[1] = pair[0];
            }
            map.put(pair[1], opair);

            if (set.contains(pair[0]))
                set.remove(pair[0]);
            else
                set.add(pair[0]);
            if (set.contains(pair[1]))
                set.remove(pair[1]);
            else
                set.add(pair[1]);
        }

        Iterator<Integer> iterator = set.iterator();
        res[0] = iterator.next();
        res[res.length-1] = iterator.next();

        for (int i = 1; i < res.length-1; i++) {
            int[] curPair = map.get(res[i - 1]);
            if (curPair[1]==0 || curPair[1]==res[i-2])
                res[i] = curPair[0];
            else
                res[i] = curPair[1];
        }

        return res;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{-10,4,-3,3,-1}, restoreArray(new int[][]{{4,-10},{-1,3},{4,-3},{-3,3}}));
        assertArrayEquals(new int[]{1,2,3,4}, restoreArray(new int[][]{{2,1},{3,4},{3,2}}));
        assertArrayEquals(new int[]{-2,4,1,-3}, restoreArray(new int[][]{{4,-2},{1,4},{-3,1}}));
        assertArrayEquals(new int[]{100000,-100000}, restoreArray(new int[][]{{100000,-100000}}));
    }


    /*public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] pair: adjacentPairs) {
            if (map.get(pair[0])==null) {
                HashSet<Object> objects = new HashSet<>();
            }
        }
    }*/
}
