package com.company;

import com.company.util.tree.bst.TreeNode;

public class _104 {
    /*0ms
    Beats 100.00%of users with Java*/
    public int maxDepth(TreeNode root) {
        return maxD(root, 0, 0);
    }

    int maxD(TreeNode root, int cur, int max) {
        if (root==null)
            return cur;
        cur = Math.max(maxD(root.left, cur+1, max), maxD(root.right, cur+1, max));
        return Math.max(max, cur);
    }
}
