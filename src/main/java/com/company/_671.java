package com.company;

import com.company.util.tree.bst.TreeNode;

public class _671 {

    /*Wrong Answer
    22 / 39 testcases passed*/
    /*public int findSecondMinimumValue(TreeNode root) {
        return dfs(root, -1);
    }

    int dfs(TreeNode root, int cur) {
        if (root!=null) {
            if (root.left!=null && root.val < root.right.val) {
                cur = Math.max(cur, root.left.val);
            }
            cur = Math.max(cur, dfs(root.left, cur));
            cur = Math.max(cur, dfs(root.right, cur));
        }
        return cur;
    }*/

    /*Wrong Answer
25 / 39 testcases passed*/
    /*public int findSecondMinimumValue(TreeNode root) {
        int dfs = dfs(root, root.val);
        return dfs ==root.val?-1:dfs;
    }

    int dfs(TreeNode root, int cur) {
        if (root!=null) {
            if (root.left!=null) {
                cur = Math.max(cur, root.left.val);
            }
            cur = Math.max(cur, dfs(root.left, cur));
            cur = Math.max(cur, dfs(root.right, cur));
        }
        return cur;
    }*/

    public int findSecondMinimumValue(TreeNode root) {
        return dfs(root, -1);
    }

    int dfs(TreeNode root, int cur) {
        if (root!=null) {
            if (root.right!=null && root.val < root.right.val) {
                cur = root.val;
            }
            cur = Math.max(cur, dfs(root.left, cur));
            cur = Math.max(cur, dfs(root.right, cur));
        }
        return cur;
    }
}
