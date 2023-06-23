package com.company;

import com.company.util.tree.BSTNode;

//https://leetcode.com/problems/increasing-order-search-tree/
public class _897_IncreasingOrderSearchTree {

    public BSTNode increasingBST(BSTNode root) {
        BSTNode newRoot = new BSTNode();
        append(newRoot, root);
        return newRoot.right;
    }

    public BSTNode append(BSTNode appender, BSTNode root) {
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
