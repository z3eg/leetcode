package com.company;

import com.company.util.tree.bst.TreeNode;

public class _222 {

    /*0
ms
Beats
100.00%
of users with Java*/
    public int countNodes(TreeNode root) {
        return countNodes(root, 0);
    }

    public int countNodes(TreeNode root, int counter) {
        if (root == null)
            return counter;
        counter++;
        counter = countNodes(root.left, counter);
        counter = countNodes(root.right, counter);
        return counter;
    }

}
