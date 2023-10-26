package com.company;

import com.company.util.tree.bst.TreeNode;

public class _100 {

    /*1ms
    Beats 100.00%of users with Java*/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p,q) && isSame(q,p);
    }

    public boolean isSame(TreeNode p, TreeNode q) {
        if (p==null)
            return q==null;
        if (q==null)
            return false;
        if (p.val!=q.val)
            return false;
        boolean leftMatches = true;
        boolean rightMatches = true;
        if (p.left!=null) {
            if (q.left==null)
                return false;
            leftMatches = isSameTree(p.left, q.left);
        }
        if (p.right!=null) {
            if (q.right==null)
                return false;
            rightMatches = isSameTree(p.right, q.right);
        }
        return leftMatches && rightMatches;
    }

}
