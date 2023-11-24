package com.company;

import com.company.util.tree.bst.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class _145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        traverse(root, res);
        return res;
    }

    /*Wrong Answer
33 / 68 testcases passed*/
    /*void traverse(TreeNode root, List<Integer> res) {
        if (root!=null) {
            traverse(root.right, res);
            traverse(root.left, res);
            res.add(root.val);
        }
    }*/

    /*0
    ms
    Beats
    100.00%
    of users with Java*/
    void traverse(TreeNode root, List<Integer> res) {
        if (root!=null) {
            traverse(root.left, res);
            traverse(root.right, res);
            res.add(root.val);
        }
    }
}
