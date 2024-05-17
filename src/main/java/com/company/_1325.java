package com.company;

import com.company.util.tree.bst.TreeNode;

public class _1325 {

    /*Wrong Answer
49 / 50 testcases passed*/
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        /*boolean leafsFound = true;
        while (leafsFound) {
            leafsFound = false;

        }*/
        deleteLeaves(root, target);
        return root;
    }

    void deleteLeaves(TreeNode root, int target) {
        if (root!=null) {
            deleteLeaves(root.left, target);
            deleteLeaves(root.right, target);
            if (root.left!=null) {
                if (root.left.left==null && root.left.right==null && root.left.val==target) {
                    root.left = null;
                }
            }
            if (root.right!=null) {
                if (root.right.left==null && root.right.right==null && root.right.val==target) {
                    root.right = null;
                }
            }
        }
    }
}
