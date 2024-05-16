package com.company;

import com.company.util.tree.bst.TreeNode;

//https://leetcode.com/problems/evaluate-boolean-binary-tree/
public class _2331_EvaluateBooleanBinaryTree {

    /*0
    ms
    Beats
    100.00%
    of users with Java*/
    public boolean evaluateTree(TreeNode root) {
        if (root.left==null || root.right==null) {
            return root.val==1;
        }
        else
            switch (root.val) {
                case 2 -> {
                    return (evaluateTree(root.left) || evaluateTree(root.right));
                }
                case 3 -> {
                    return (evaluateTree(root.left) && evaluateTree(root.right));
                }
            }
        return false;
    }


}
