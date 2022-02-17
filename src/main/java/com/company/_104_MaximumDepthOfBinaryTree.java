package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class _104_MaximumDepthOfBinaryTree {

    public static int NULL_PLACEHOLDER = 0;

    private class TreeNode {
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


    private void getDepths(TreeNode root, Set<Integer> lengths, int curLen) {
        if (root != null) {
            if (root.left != null) {
                curLen++;
                getDepths(root.left, lengths, curLen);
            } else if (root.right != null) {
                curLen++;
                getDepths(root.right, lengths, curLen);
            } else {
                lengths.add(curLen);
            }
        }
    }

    public int maxDepth(TreeNode root) {
        HashSet<Integer> lengths = new HashSet<>();
        getDepths(root, lengths, 0);
        return Collections.max(lengths);
    }

    private void buildATree(TreeNode root, Queue<Integer> vals) {
        if (!vals.isEmpty() && root!=null && root.val!=NULL_PLACEHOLDER) {
            if (root.left==null) {
                Integer integer = vals.poll();
                TreeNode newNode = new TreeNode(integer == null ? NULL_PLACEHOLDER : integer);
                root.left = newNode;
                buildATree(newNode, vals);
            }
            else if (root.right==null) {
                Integer integer = vals.poll();
                TreeNode newNode = new TreeNode(integer == null ? NULL_PLACEHOLDER : integer);
                root.right = newNode;
                buildATree(newNode, vals);
            }
            else {
                buildATree(root.left, vals);
            }
        }
    }

    @Test
    public void test() {
        List<Integer> integers = Arrays.asList(3, 9, 20, null, null, 15, 7);
        Queue<Integer> integersQueue = new LinkedList<Integer>(integers);
        TreeNode treeRoot = new TreeNode(integersQueue.poll());
        buildATree(treeRoot, integersQueue);
        System.out.println(treeRoot);
    }

}
