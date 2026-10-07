package com.company;

import com.company.util.tree.bst.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102 {

    /*1
ms
Beats
96.26%*/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root==null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> curLev = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node!=null) {
                    curLev.add(node.val);
                    if (node.left!=null)
                        q.add(node.left);
                    if (node.right!=null)
                        q.add(node.right);
                }
            }
            res.add(curLev);
        }
        return res;
    }
}
