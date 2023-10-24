package com.company;

import com.company.util.tree.bst.TreeNode;

import java.util.LinkedList;
import java.util.List;

/*515. Find Largest Value in Each Tree Row
        https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/?envType=daily-question&envId=2023-10-24*/
public class _515 {

    /*2ms
    Beats 82.84%of users with Java*/
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        dfs(root, res, 0);
        return res;
    }

    void dfs(TreeNode root, List<Integer> res, int depth) {
        if (root == null)
            return;
        if (res.size() <= depth)
            res.add(root.val);
        else {
            if (res.get(depth) < root.val) {
                res.remove(depth);
                res.add(depth, root.val);
            }
        }
        dfs(root.left, res, depth+1);
        dfs(root.right, res, depth+1);
    }
}
