package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/subsets/
public class _78_Subsets {

    /*private class CustomList extends ArrayList<Integer> {

        public int hashCode() {
            int hashCode = 1;
            for (Integer e : super)
                hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
        }
    }*/

    private class Node {
        public int val;
        public Node parent;
        public List<Node> children;
        public List<Integer> nums;

        public Node(int number, List<Integer> nums, Node parent) {
            this.val = number;
            this.nums = nums;
            this.parent = parent;
            this.children = new LinkedList<>();
        }

        public Node(List<Integer> nums, Node parent) {
            this.nums = nums;
            this.parent = parent;
            this.children = new LinkedList<>();
//            this.children.hashCode()
        }
    }

    public void buildATree(Node root, Set<List<Integer>> allRoutes) {
//        List<Integer> nums = new LinkedList<>(root.nums);
        List<Integer> nums = root.nums;
        nums.removeAll(List.of(root.val));
        List<Node> children = root.children;
        children.add(new Node(0,new LinkedList<>(), root));
        if (!nums.isEmpty()) {
            for (int i = 0; i < nums.size(); i++) {
                Node childNode = new Node(nums.get(i), nums, root);
                children.add(childNode);
            }
            for (Node childNode : children)
                buildATree(childNode, allRoutes);
        }
        else {
            LinkedList<Integer> thisRoute = new LinkedList<>();
            while (root.val!=-1) {
                if (root.val!=0)
                    thisRoute.add(root.val);
                root = root.parent;
            }
            allRoutes.add(thisRoute);
        }

    }

    @Test
    public void testBuildATree() {
        List<Integer> numsList = new LinkedList<>(Arrays.asList(1, 2, 3));
        Node root = new Node(-1, numsList, null);
        HashSet<List<Integer>> routes = new HashSet<>();
        buildATree(root,routes);
        System.out.println(root);
    }

    /*public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> numsList = new LinkedList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        Node root = new Node(numsList);
        buildATree(root);
        Set<List<Integer>> res = new HashSet<List<Integer>>();
//        return res;
        return null;
    }*/
}
