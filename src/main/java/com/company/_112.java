package com.company;

import com.company.util.tree.bst.TreeNode;

public class _112 {

    /*Wrong Answer
    105 / 117 testcases passed*/
    /*public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return hasPath(root, targetSum, 0);
    }

    boolean hasPath(TreeNode root, int targetSum, int curSum) {
        if (root == null)
            return curSum==targetSum;
        else {
            return (hasPath(root.left, targetSum, curSum+root.val) ||
                    hasPath(root.right, targetSum, curSum+root.val));
        }
    }*/

    /*0 ms
    Beats
    100.00%
    of users with Java*/
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPath(root, targetSum, 0);
    }

    boolean hasPath(TreeNode root, int targetSum, int curSum) {
        if (root == null)
            return false;
        else {
            curSum+=root.val;
            if (root.left == null && root.right == null)
                return targetSum == curSum;
            else {
                return hasPath(root.left, targetSum, curSum) ||
                        hasPath(root.right, targetSum, curSum);
            }
        }
    }

}
