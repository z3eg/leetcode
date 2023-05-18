package com.company;

/*https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
1557. Minimum Number of Vertices to Reach All Nodes*/

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class _1557 {
    //96%
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        boolean[] verticeVisited = new boolean[n];
        for (List<Integer> edge : edges) {
            verticeVisited[edge.get(1)] = true;
        }
        for (int i = 0; i < verticeVisited.length; i++) {
            if (!verticeVisited[i])
                res.add(i);
        }
        return res;
    }

    @Test
    public void test() {
        /*List<List<Integer>> list = new LinkedList<>();
        LinkedList<Integer> subList;
        subList = new LinkedList<>();
        subList.add(0);
        subList.add(1);
        list.add(subList);
        subList = new LinkedList<>();
        subList.add(0);
        subList.add(2);
        list.add(subList);
        subList = new LinkedList<>();
        subList.add(2);
        subList.add(5);
        list.add(subList);
        subList = new LinkedList<>();
        subList.add(3);
        subList.add(4);
        list.add(subList);
        subList = new LinkedList<>();
        subList.add(4);
        subList.add(2);
        list.add(subList);*/

//        assertArrayEquals(new int[]{0,3}, findSmallestSetOfVertices(6, list));
    }
}
