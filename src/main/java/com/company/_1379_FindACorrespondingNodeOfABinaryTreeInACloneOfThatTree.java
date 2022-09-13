package com.company;

//https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
public class _1379_FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode res = null;
        if (original == target)
            return cloned;
        if (original!=null) {
            res = getTargetCopy(original.left, cloned.left, target);
            if (res!=null)
                return res;
            res = getTargetCopy(original.right, cloned.right, target);
        }
        return res;
    }
}
