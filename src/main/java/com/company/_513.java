package com.company;

import com.company.util.tree.bst.TreeNode;

public class _513 {
    /*Wrong Answer
49 / 77 testcases passed*/
    public int findBottomLeftValue(TreeNode root) {
        int[] res = new int[2];
        dfs(root, 0, res);
        return res[1];
    }

    void dfs(TreeNode root, int depth, int[] res) {
        if (root!=null) {
            if (root.left!=null) {
                if (depth+1 > res[0]) {
                    res[0] = depth+1;
                    res[1] = root.left.val;
                }
            }
            dfs(root.left, depth+1, res);
            dfs(root.right, depth+1, res);
        }
    }
}
