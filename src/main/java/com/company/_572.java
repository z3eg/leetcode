package com.company;

import com.company.util.tree.bst.TreeNode;

public class _572 {

    /*Wrong Answer
164 / 185 testcases passed*/

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        TreeNode foundSubRoot = findSubroot(root, subRoot);
        if (foundSubRoot==null)
            return false;
        return areEqual(foundSubRoot,subRoot);
    }

    TreeNode findSubroot(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return null;
        if (subRoot == null)
            return null;
        if (root.val == subRoot.val)
            return root;
        TreeNode left = findSubroot(root.left, subRoot);
        if (left!= null)
            return left;
        TreeNode right = findSubroot(root.right, subRoot);
        if (right!=null)
            return right;
        return null;
    }

    boolean areEqual(TreeNode root, TreeNode root2) {
        if (root == null && root2 == null)
            return true;
        if (root != null && root2 == null)
            return false;
        if (root == null && root2 != null)
            return false;
        if (root.val!=root2.val)
            return false;
        return areEqual(root.left, root2.left) && areEqual(root.right, root2.right);
    }
}
