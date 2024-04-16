package com.company;

import com.company.util.tree.bst.TreeNode;

public class _623 {

    /*Wrong Answer
100 / 109 testcases passed*/
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        addRow(root, val, depth, 2);
        return root;
    }

    private void addRow(TreeNode root, int val, int depth, int curDepth) {
        if (root!=null) {
            if (depth == curDepth) {
                TreeNode l = new TreeNode(val);
                l.left = root.left;
                root.left = l;
                TreeNode r = new TreeNode(val);
                r.right = root.right;
                root.right = r;
            }
            else {
                addRow(root.left, val, depth, curDepth+1);
                addRow(root.right, val, depth, curDepth+1);
            }
        }
    }
}
