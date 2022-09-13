package com.company;

//https://leetcode.com/problems/evaluate-boolean-binary-tree/
public class _2331_EvaluateBooleanBinaryTree {
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

    public boolean evaluateTree(TreeNode root) {
        if (root.left==null || root.right==null) {
            return root.val==1;
        }
        else
            switch (root.val) {
                case 2 -> {
                    return (evaluateTree(root.left) || evaluateTree(root.right));
                }
                case 3 -> {
                    return (evaluateTree(root.left) && evaluateTree(root.right));
                }
            }
        return false;
    }

    private boolean intToBool(int i) {
        return i==1;
    }


}
