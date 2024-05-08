package com.company;

import com.company.util.tree.bst.TreeNode;

//https://leetcode.com/problems/invert-binary-tree/
public class _226_InvertBinaryTree {

    /*-ms
    Beats 100.00%of users with Java*/
    public TreeNode invertTree(TreeNode root) {
        if (root!=null)
            invert(root);
        return root;
    }

    void invert(TreeNode root) {
        if (root.left!=null) {
            invert(root.left);
        }
        if (root.right!=null) {
            invert(root.right);
        }
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
    }

}
