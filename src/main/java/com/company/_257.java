package com.company;

import com.company.util.tree.bst.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class _257 {

    /*156
    ms
            Beats
7.84%
    of users with Java*/
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        binaryTreePaths(root, new LinkedList<>(), res);
        return res;
    }

    public void binaryTreePaths(TreeNode root, List<Integer> cur, List<String> res) {
        if (root!=null) {
            cur.add(root.val);
            if (root.left==null && root.right==null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < cur.size()-1; i++) {
                    stringBuilder.append(cur.get(i));
                    stringBuilder.append("->");
                }
                stringBuilder.append(cur.get(cur.size()-1));
                res.add(stringBuilder.toString());
            }
            binaryTreePaths(root.left, cur, res);
            binaryTreePaths(root.right, cur, res);
            cur.remove(cur.size()-1);
        }
    }
}
