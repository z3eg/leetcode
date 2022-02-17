package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/combination-sum/
public class _39_CombinationSum {

    private class Node {
        Node parent;
        int val;
        List<Node> children;

        public Node(int val, Node parent) {
            this.val = val;
            this.parent = parent;
            this.children = new LinkedList<>();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> candidatesList = getCandidatesList(candidates);
        Node root = new Node(0, null);
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        buildATree(root,candidatesList,0,target,set);
        return set.stream().toList();
    }

    public void buildATree(Node root, List<Integer> candidates, int curSum, int target, Set<List<Integer>> resultSet) {
        if (!candidates.isEmpty()) {
            ListIterator<Integer> iterator = candidates.listIterator(candidates.size());
            while (iterator.hasPrevious()) {
                Integer candidate = iterator.previous();
                if (curSum+candidate > target) {
                    iterator.remove();
                }
                else if (curSum+candidate == target) {
                    Node node = new Node(candidate, root);
                    root.children.add(node);
                    LinkedList<Integer> thisBranch = new LinkedList<>();
                    while (node.parent!=null) {
                        thisBranch.add(node.val);
                        node = node.parent;
                    }
                    thisBranch.sort(Comparator.naturalOrder());
                    resultSet.add(thisBranch);
                }
                else {
                    Node node = new Node(candidate, root);
                    buildATree(node, new LinkedList<Integer>(candidates), curSum+candidate, target, resultSet);
                }
            }
        }
    }

    private List<Integer> getCandidatesList(int[] candidates) {
        List<Integer> integers = new LinkedList<>();
        for (int candidate : candidates) {
            integers.add(candidate);
        }
        return integers;
    }

    @Test
    public void testTree() {
        int target = 7;
        int[] candidates = {2,3,6,7};
        List<Integer> candidatesList = getCandidatesList(candidates);
        Node root = new Node(0, null);
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        buildATree(root,candidatesList,0,target,set);
        System.out.println(set);
    }

    @Test
    public void test() {
        //example 1
        List<List<Integer>> ex1res = new LinkedList<>();
        ex1res.add(Arrays.asList(2,2,3));
        ex1res.add(List.of(7));
        assertEquals(ex1res, combinationSum(new int[]{2,3,6,7},7));
        LinkedList<List<Integer>> ex2res = new LinkedList<>();
        ex2res.add(Arrays.asList(2,2,2,2));
        ex2res.add(Arrays.asList(2,3,3));
        ex2res.add(List.of(3,5));
        assertEquals(ex2res, combinationSum(new int[]{2,3,5},8));
        assertEquals(new LinkedList<>(), combinationSum(new int[]{2},1));
    }
}
