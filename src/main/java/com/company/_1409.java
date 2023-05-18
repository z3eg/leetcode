package com.company;

/*
https://leetcode.com/problems/queries-on-a-permutation-with-key/
        1409. Queries on a Permutation With Key
*/

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertArrayEquals;

public class _1409 {
    //beats 31.87%
    /*public int[] processQueries(int[] queries, int m) {
        LinkedList<Integer> integers = new LinkedList<>();
        LinkedList<Integer> resList = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            integers.add(i);
        }
        for (int query : queries) {
            int pos = integers.indexOf(query);
            resList.add(pos);
            integers.remove(pos);
            integers.addFirst(query);
        }
//        return resList.stream().mapToInt(i->i).toArray();
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }*/

    public int[] processQueries(int[] queries, int m) {
        int maxPointer = 0;
        int[] res = new int[queries.length];
        int[] numsPositions = new int[m];
        for (int i = 0; i < numsPositions.length; i++) {
            numsPositions[i] = i;
        }
        for (int i = 0; i < queries.length; i++) {
            res[i] = numsPositions[queries[i]-1];
            maxPointer = Math.max(maxPointer, numsPositions[queries[i]-1]);
            for (int j = 0; j < maxPointer; j++) {
                if (numsPositions[j]<=queries[i]-1)
                    numsPositions[j]++;
            }
            numsPositions[queries[i]] = 0;
        }
        /*for (int i = 0; i < res.length; i++) {
            res[i]--;
        }*/
        return res;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{2,1,2,1}, processQueries(new int[]{3,1,2,1},5));
        assertArrayEquals(new int[]{3,1,2,0}, processQueries(new int[]{4,1,2,2},4));
        assertArrayEquals(new int[]{6,5,0,7,5}, processQueries(new int[]{7,5,5,8,3},8));
    }
}
