package com.company;

import com.company.util.tree.bst.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class _144 {

    /*0
    ms
            Beats
100.00%
    of users with Java*/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        traverse(root, res);
        return res;
    }

    void traverse(TreeNode root, List<Integer> res) {
        if (root!=null) {
            res.add(root.val);
            traverse(root.left, res);
            traverse(root.right, res);
        }
    }
}
