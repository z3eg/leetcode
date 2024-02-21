package com.company;

import com.company.util.tree.bst.TreeNode;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class _783 {

    /*Wrong Answer
31 / 49 testcases passed*/
    /*public int minDiffInBST(TreeNode root) {
        return dfs(root, Integer.MAX_VALUE);
    }

    private int dfs(TreeNode root, int min) {
        if (root!=null) {
            if (root.left!=null) {
                min = Math.min(min, Math.abs(root.val - root.left.val));
                min = Math.min(min, dfs(root.left, min));
            }
            if (root.right!=null) {
                min = Math.min(min, Math.abs(root.val - root.right.val));
                min = Math.min(min, dfs(root.right, min));
            }
        }
        return min;
    }*/

    /*1
    ms
    Beats
    21.66%
    of users with Java*/
    public int minDiffInBST(TreeNode root) {
        TreeSet<Integer> integers = new TreeSet<>();
        dfs(root, integers);
        int min = Integer.MAX_VALUE;
        Iterator<Integer> iterator = integers.iterator();
        Integer first = iterator.next();
        Integer next = iterator.next();
        while (iterator.hasNext()) {
            min = Math.min(min, next-first);
            first = next;
            next = iterator.next();
        }
        min = Math.min(min, next-first);
        return min;
    }

    void dfs(TreeNode root, Set<Integer> set) {
        if (root!=null) {
            set.add(root.val);
            dfs(root.left, set);
            dfs(root.right, set);
        }
    }
}
