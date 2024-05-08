package com.company;

import com.company.util.tree.bst.TreeNode;

public class _404 {

    public int sumOfLeftLeaves(TreeNode root) {

        return sum(root, 0);
    }

    /*0
    ms
    Beats
    100.00%
    of users with Java*/
    int sum(TreeNode root, int curSum) {
        if (root!=null) {
            if (root.left!=null && (root.left.left == null && root.left.right == null))
                    {curSum+=root.left.val;
            }
            curSum = sum(root.left, curSum);
            curSum = sum(root.right, curSum);
        }
        return curSum;
    }


//    29 / 100 testcases passed
    /*int sum(TreeNode root, int curSum) {
        if (root!=null) {
            if (root.left!=null) {
                curSum+=root.left.val;
            }
            curSum = sum(root.left, curSum);
            curSum = sum(root.right, curSum);
        }
        return curSum;
    }*/


}
