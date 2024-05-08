package com.company;

import com.company.util.tree.bst.TreeNode;

public class _129 {

    /*0
    ms
    Beats
    100.00%
    of users with Java*/
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0, 0);
    }

    private int dfs(TreeNode root, int curSum, int curNum) {
        if (root!=null) {
            curNum+=root.val;
            if (root.left == null && root.right == null) {
                curSum+=curNum;
            }
            else {
                curNum*=10;
                if (root.left!=null) {
                    curSum = dfs(root.left, curSum, curNum);
                }
                if (root.right!=null) {
                    curSum = dfs(root.right, curSum, curNum);
                }
            }
        }
        return curSum;
    }
}
