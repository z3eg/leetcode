package com.company;

import com.company.util.tree.bst.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class _653 {

    /*24
    ms
            Beats
5.24%
    of users with Java*/
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k, new LinkedList<>());
    }

    boolean dfs(TreeNode root, int k, List<Integer> lf) {
        if (root!=null) {
            if (lf.contains(root.val))
                return true;
            lf.add(k-root.val);
            if (dfs(root.left, k, lf))
                return true;
            if (dfs(root.right, k, lf))
                return true;
        }
        return false;
    }
}
