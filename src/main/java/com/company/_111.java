package com.company;


import com.company.util.tree.bst.TreeNode;

public class _111 {
    public int minDepth(TreeNode root) {
        return traverse(root, 1);
    }

    //DFS solution.
    // TODO BFS would probs be better for this but later
    private int traverse(TreeNode root, int depth) {
        if (root == null)
            return 0;
        if (root.left==null && root.right==null)
            return depth;
        int left = depth;
        int right = depth;
        if (root.left!=null)
            left = traverse(root.left, depth+1);
        if (root.right!=null)
            right = traverse(root.right, depth+1);
        if (left==depth)
            left = Integer.MAX_VALUE;
        if (right==depth)
            right = Integer.MAX_VALUE;
        return Math.min(left, right);
    }
}
