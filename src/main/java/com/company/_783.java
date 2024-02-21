package com.company;

import com.company.util.tree.bst.TreeNode;

public class _783 {

    /*Wrong Answer
31 / 49 testcases passed*/
    public int minDiffInBST(TreeNode root) {
        return dfs(root, Integer.MAX_VALUE);
    }

    private int dfs(TreeNode root, int min) {
        if (root!=null) {
            if (root.left!=null) {
                min = Math.min(min, Math.abs(root.val - root.left.val));
                min = Math.min(min, dfs(root.left, min));
            }
            if (root.right!=null) {
                min = Math.min(min, Math.abs(root.val - root.right.val));
                min = Math.min(min, dfs(root.right, min));
            }
        }
        return min;
    }
}
