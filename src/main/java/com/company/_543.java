package com.company;

import com.company.util.tree.bst.TreeNode;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class _543 {

    /*2
    ms
            Beats
    18.53%
    of users with Java*/
    public int diameterOfBinaryTree(TreeNode root) {
        TreeSet<Integer> diams = new TreeSet<>(Comparator.reverseOrder());
        depth(root, 0, diams);
        return diams.first();
    }

    int depth(TreeNode root, int curDepth, Set<Integer> diameters) {
        if (root==null)
            return curDepth-1;
        else {
            int leftDepth = depth(root.left, curDepth + 1, diameters);
            int rightDepth = depth(root.right, curDepth + 1, diameters);
            diameters.add(leftDepth -curDepth + rightDepth -curDepth);
            return Math.max(leftDepth,rightDepth);
        }
    }
}
