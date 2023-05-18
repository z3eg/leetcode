package com.company;

import com.company.util.tree.TreeNode;

//https://leetcode.com/problems/increasing-order-search-tree/
public class _897_IncreasingOrderSearchTree {

    public TreeNode increasingBST(TreeNode root) {
        TreeNode newRoot = new TreeNode();
        append(newRoot, root);
        return newRoot.right;
    }

    public TreeNode append(TreeNode appender, TreeNode root) {
        if (root.left!=null) {
            appender = append(appender, root.left);
            root.left = null;
        }
        appender.right = root;
        appender = appender.right;
        if (root.right!=null)
            appender = append(appender, root.right);
        return appender;
    }
}
