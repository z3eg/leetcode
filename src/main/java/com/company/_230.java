package com.company;

public class _230 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*0
ms
Beats
100.00%
*/
    public int kthSmallest(TreeNode root, int k) {
        int []res = dive (root, k, new int[]{0,-1});
        return res[1];
    }

    int[] dive (TreeNode root, int k, int[] cAv) {
        if (cAv[1]!=-1)
            return cAv;
        if (root == null)
            return cAv;
        cAv = dive(root.left,k,cAv);
        cAv[0]++;
        if (k==cAv[0])
        {
            cAv[1] = root.val;
            return cAv;
        }
        cAv = dive(root.right,k,cAv);
        return cAv;
    }
}
