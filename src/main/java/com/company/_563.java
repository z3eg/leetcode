package com.company;

import com.company.util.tree.bst.TreeNode;

public class _563 {

    int tilt;

    /*0
    ms
            Beats
100.00%
    of users with Java*/
    public int findTilt(TreeNode root) {
        tilt = 0;
        sum(root);
        return tilt;
    }

    public int sum(TreeNode root) {
        if (root!=null) {
            int sum = root.val;
            int leftSum = sum(root.left);
            int rightSum = sum(root.right);
            tilt+=Math.abs(rightSum-leftSum);
            sum+= leftSum;
            sum+= rightSum;
            return sum;
        }
        return 0;
    }
}
