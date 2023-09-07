package com.company;

import com.company.util.tree.bst.TreeNode;

/*2415. Reverse Odd Levels of Binary Tree
        https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/*/
public class _2415 {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root.left==null)
            return root;
        reverse(root.left, root.right,1);
        return root;
    }

    private void reverse(TreeNode left, TreeNode right, int depth) {
        if (depth%2==0 && left.left!=null) {
            int tmp = left.left.val;
            left.left.val = right.left.val;
            right.left.val = tmp;
            tmp = left.right.val;
            left.right.val = right.right.val;
            right.right.val = tmp;
            reverse(left.left, right.left, depth+1);
            reverse(left.right, right.right, depth+1);
        }
    }
}
