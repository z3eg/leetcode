package com.company;

import com.company.util.tree.bst.TreeNode;

public class _110 {
    /*public boolean isBalanced(TreeNode root) {
        int[] minAndMax = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        dfs(root, 0, minAndMax);
        int diff = minAndMax[1] - minAndMax[0];
        return diff ==1 || diff ==0;
    }

    private void dfs(TreeNode root, int curDepth, int[] minAndMax) {
        if (root!=null) {
            if (root.left==null && root.right==null) {
                minAndMax[0] = Math.min(minAndMax[0], curDepth);
                minAndMax[1] = Math.max(minAndMax[1], curDepth);
            }
            else {
                dfs(root.left, curDepth+1, minAndMax);
                dfs(root.right, curDepth+1, minAndMax);
            }
        }
    }*/


    /*203 / 228 testcases passed*/
    /*public boolean isBalanced(TreeNode root) {
        if (root==null)
            return true;
        return Math.abs(depth(root.left, 0) - depth(root.right, 0)) < 2;
    }

    private int depth(TreeNode root, int curDep) {
        if (root == null)
            return curDep-1;
        return Math.max(depth(root.left, curDep+1), depth(root.right, curDep+1));
    }*/

    /*public boolean isBalanced(TreeNode root) {
        if (root==null)
            return true;
        if ((root.left==null && hasKids(root.right)) || (root.right==null && hasKids(root.left)))
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    boolean hasKids(TreeNode root) {
        return root!=null && (root.left!=null || root.right!= null);
    }*/

    /*0ms
    Beats 100.00%of users with Java*/
    public boolean isBalanced(TreeNode root) {
        if (root==null)
            return true;
        return max(root, 0, -20) != -10;
    }

    int max(TreeNode root, int cur, int max) {
        if (root == null)
            return cur-1;
        int mLeft = max(root.left, cur+1, max);
        int mRight = max(root.right, cur+1, max);
        int diff = Math.abs(mRight - mLeft);
        if (mRight==-10 || mRight==-10 || diff >1)
            return -10;
        return Math.max(max, Math.max(mLeft, mRight));
    }

}
