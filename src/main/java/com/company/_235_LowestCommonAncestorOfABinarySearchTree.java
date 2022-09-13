package com.company;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class _235_LowestCommonAncestorOfABinarySearchTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val <= p.val && root.val >= q.val) || (root.val >= p.val && root.val <= q.val) ) {
            return root;
        }
        if ((root.val > p.val && root.val > q.val)) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if ((root.val < p.val && root.val < q.val)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }*/

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int rootVal = root.val;
        int qVal = q.val;
        int pVal = p.val;
        if ((rootVal <= pVal && rootVal >= qVal) || (rootVal >= pVal && rootVal <= qVal) ) {
            return root;
        }
        if (rootVal > pVal) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return lowestCommonAncestor(root.right, p, q);
    }

}
