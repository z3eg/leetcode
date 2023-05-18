package com.company;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/all-paths-from-source-to-target/
public class _797_AllPathsFromSourceToTarget {

    //probs don't need tree at all
    /*private class Node {
        public int val;
        public List<Node> nextNodes;

        public Node(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //building a tree
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            Node node = map.get(i);
            if (node==null) {
                Node newNode = new Node(i);
                map.put(i, newNode);
                node = newNode;
            }
            for (int j = 0; j < graph[i].length; j++) {
                Node childNode = map.get(graph[i][j]);
                if (childNode==null) {
                    Node newNode = new Node(graph[i][j]);
                    map.put(graph[i][j], newNode);
                    childNode = newNode;
                }
                node.nextNodes.add(childNode);
            }
        }
        //recursively traversing tree

    }*/

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();
        checkNode(graph, res, new LinkedList<>(), 0, graph.length-1);
        return res;
    }

    public void checkNode(int[][] graph, List<List<Integer>> res, List<Integer> curChain, int node, int target) {
        if (node == target) {
            res.add(new LinkedList<>(curChain));
        }
        else {
            for (int i = 0; i < graph[node].length; i++) {
                curChain.add(node);
                checkNode(graph, res, curChain, graph[node][i], target);
            }
        }
    }

    @Test
    public void test() {
        List<List<Integer>> lists = allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}});
//        List<List<Integer>> lists = allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}});
    }
}
