package com.company;

public class _617_MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1==null && root2!=null)
            return root2;
        if (root1!=null && root2!=null) {
            root1.val += root2.val;
            if (root1.left==null && root2.left!=null) {
                root1.left = root2.left;
                root2.left = null;
            }
            if (root1.right==null && root2.right!=null) {
                root1.right = root2.right;
                root2.right = null;
            }
            mergeTrees(root1.left, root2.left);
            mergeTrees(root1.right, root2.right);
        }
        return root1;
    }
}
