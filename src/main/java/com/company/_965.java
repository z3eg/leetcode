package com.company;

import com.company.util.tree.bst.TreeNode;

public class _965 {

    /*0
        ms
        Beats
        100.00%
        of users with Java*/
    public boolean isUnivalTree(TreeNode root) {
        return isUnival(root);
    }

    boolean isUnival(TreeNode root) {
        if (root==null)
            return true;
        if (root.left==null && root.right==null)
            return true;
        boolean isUnival = true;
        if (root.left!=null)
            isUnival = isUnival(root.left) && root.val == root.left.val; //could be improved with fast-failing on
        // root.val == root.left.val before invoking recursion but u can't go lower than 0 ms
        if (root.right!=null)
            isUnival = isUnival && isUnival(root.right) && root.val == root.right.val;
        return isUnival;
    }
}
