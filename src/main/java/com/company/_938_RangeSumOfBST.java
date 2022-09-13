package com.company;

//https://leetcode.com/problems/range-sum-of-bst/
public class _938_RangeSumOfBST {

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

    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        vrangeSumBST(root,low,high);
        return sum;
    }

    public void vrangeSumBST(TreeNode root, int low, int high) {
        if (root!=null) {
            if (root.val >= low && root.val <= high) {
                sum += root.val;
            }
            vrangeSumBST(root.left, low, high);
            vrangeSumBST(root.right, low, high);
        }
    }
}
