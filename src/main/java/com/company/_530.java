package com.company;

import com.company.util.tree.bst.TreeNode;

public class _530 {

    /*Runtime
    97 ms
    Beats
    5.11%*/
    /*public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        getAll(root, list);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size()-1; i++) {
            min = Math.min(min,Math.abs(list.get(i)-list.get(i+1)));
        }
        return min;
    }

    public void getAll(TreeNode root, List<Integer> list) {
        if (root.left!=null)
            getAll(root.left, list);
        list.add(root.val);
        if (root.right!=null)
            getAll(root.right, list);
    }*/

    /*Runtime
    0 ms
    Beats
    100%*/
    int lastObserved = -1;
    int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        getAll(root);
        return minDiff;
    }

    public void getAll(TreeNode root) {
        if (root.left!=null)
            getAll(root.left);
        subtract(root.val);
        if (root.right!=null)
            getAll(root.right);
    }

    public void subtract(int last) {
        if (lastObserved!=-1) {
            minDiff = Math.min(minDiff, Math.abs(lastObserved - last));
        }
        lastObserved = last;
    }


}
