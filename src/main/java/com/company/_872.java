package com.company;

import com.company.util.tree.bst.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class _872 {

    /*0
    ms
            Beats
100.00%
    of users with Java*/
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new LinkedList<>();
        List<Integer> l2 = new LinkedList<>();
        dfs(root1, l1);
        dfs(root2, l2);
        if (l1.size() != l2.size())
            return false;
        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i)!=l2.get(i))
                return false;
        }
        return true;
    }

    public void dfs(TreeNode root, List<Integer> seq) {
        if (root!=null) {
            if (root.left == null && root.right == null) {
                seq.add(root.val);
            }
            dfs(root.left, seq);
            dfs(root.right, seq);
        }
    }
}
