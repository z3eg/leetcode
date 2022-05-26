package com.company;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Spliterator;
import java.util.TreeMap;

//https://leetcode.com/problems/deepest-leaves-sum/
public class _1302_DeepestLeavesSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int deepestLeavesSum(TreeNode root) {
        Map<Integer, Integer> indexToSumMap = new TreeMap<>(Comparator.reverseOrder());
        indexToSumMap = deepestLeavesSum(root,0,indexToSumMap);
        return indexToSumMap.entrySet().iterator().next().getValue();
    }

    public Map<Integer, Integer> deepestLeavesSum(TreeNode root, int curIndex, Map<Integer, Integer> indexToSumMap) {
        if (root.left==null && root.right==null) {
            indexToSumMap.put(curIndex, (indexToSumMap.get(curIndex)!=null)?indexToSumMap.get(curIndex)+root.val:root.val);
        }
        else {
            if (root.left!=null) {
                deepestLeavesSum(root.left, curIndex+1, indexToSumMap);
            }
            if (root.right!=null) {
                deepestLeavesSum(root.right, curIndex+1, indexToSumMap);
            }
        }
        return indexToSumMap;
    }

}
