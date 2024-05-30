package com.company;

import com.company.util.tree.bst.TreeNode;

public class _993 {

    /*0
    ms
    Beats
    100.00%
    of users with Java*/
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] res = new int[]{0,0};
        boolean b = find(root, 0, x, y, res);
        if (!b)
            return false;
        return (res[0]==res[1] && res[0]!=0);
    }

    boolean find(TreeNode root, int curDep, int x, int y, int[] res) {
        if (root!=null) {
            if ((root.left!=null && root.right!=null) && ((root.left.val==x && root.right.val==y) || (root.left.val==y && root.right.val==x)))
                return false;
            if (res[0] == 0) {
                if (root.val == x) {
                    res[0] = curDep;
                } else {
                    find(root.left, curDep + 1, x, y, res);
                    find(root.right, curDep + 1, x, y, res);
                }
            }
            if (res[1] == 0) {
                if (root.val == y) {
                    res[1] = curDep;
                }
                else {
                    find(root.left, curDep +1, x, y, res);
                    find(root.right, curDep +1, x, y, res);
                }
            }
        }
        return res[0]==res[1] && res[0]!=0;
    }
}
