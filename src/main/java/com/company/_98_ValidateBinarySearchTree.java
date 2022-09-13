package com.company;

import java.util.LinkedList;

//TODO
//https://leetcode.com/problems/validate-binary-search-tree/
public class _98_ValidateBinarySearchTree {

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

    private class Node {
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public boolean isValidBST(TreeNode root, Node maxLeft) {
        if (root.val < maxLeft.val) {
            return false;
        }
        boolean result = true;
        TreeNode left = root.left;
        if (left !=null) {
            if (left.val>=root.val)
                return false;
            else {
                result = isValidBST(left, maxLeft);
                maxLeft.val = Math.max(maxLeft.val, left.val);
            }
        }
        if (result) {
            TreeNode right = root.right;
            if (right !=null) {
                if (right.val<=root.val)
                    return false;
                else
                    result = isValidBST(right, maxLeft);
            }
        }
        return result;
    }

    public boolean isValidBST(TreeNode root) {
        int maxLeft = Integer.MIN_VALUE;
        return isValidBST(root, new Node(maxLeft));
    }

    /*public boolean checkNode(TreeNode root) {
        TreeNode left = root.left;
        if (left !=null) {
            if (left.val>root.val)
                return false;
            else
                return checkNode(left);
        }
        TreeNode right = root.right;
        if (right !=null) {
            if (right.val<root.val)
                return false;
            else
                return checkNode(right);
        }
        return true;
    }*/
}
