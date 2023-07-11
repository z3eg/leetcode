package com.company;


import com.company.util.tree.bst.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _111 {
    //DFS solution
    /*Runtime
    11 ms
    Beats
    49.8%*/
    /*public int minDepth(TreeNode root) {
        return traverse(root, 1);
    }

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
    }*/

    //BFS
    /*Runtime
    0 ms
    Beats
    100%*/
    public int minDepth(TreeNode root) {
        if (root==null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        root.val = 1;
        while (!(root.left==null && root.right==null)) {
            if (root.left!=null) {
                root.left.val = root.val+1;
                q.add(root.left);
            }
            if (root.right!=null) {
                root.right.val = root.val+1;
                q.add(root.right);
            }
            root = q.poll();
        }
        return root.val;
    }
}
