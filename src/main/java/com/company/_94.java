package com.company;

import com.company.util.tree.bst.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class _94 {

    /*0ms
    Beats 100.00%of users with Java*/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root!=null) {
            dfs(root.left, res);
            res.add(root.val);
            dfs(root.right, res);
        }
    }

}
