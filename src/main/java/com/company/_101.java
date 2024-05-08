package com.company;

import com.company.util.tree.bst.TreeNode;

public class _101 {
    /*0ms
    Beats 100.00%of users with Java*/
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    boolean dfs(TreeNode rootL, TreeNode rootR) {
        if (rootL==null && rootR!=null)
            return false;
        if (rootR==null && rootL!=null)
            return false;
        if (rootL == null && rootR == null)
            return true;
        if (rootL.val != rootR.val)
            return false;
        return dfs(rootL.left, rootR.right) && dfs(rootL.right, rootR.left);
    }
}
