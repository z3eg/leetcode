package com.company;

import com.company.util.tree.bst.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class _2385 {

    int depthOfStart;

    /*Wrong Answer
46 / 80 testcases passed*/
    /*public int amountOfTime(TreeNode root, int start) {
        List<List<Integer>> paths = new LinkedList<>();
        bfs(root, new LinkedList<>(), paths, start);
        int max = 0;
        for (List<Integer> path : paths) {
            if (path.contains(start)) {
                max = Math.max(max, (path.size()-1)-depthOfStart);
            }
            else max = Math.max(max, (path.size()-1) + depthOfStart);
        }
        return max;
    }

    private void bfs(TreeNode root, LinkedList<Integer> curPath, List<List<Integer>> paths, int start) {
        if (root != null) {
            curPath.add(root.val);
            if (root.val == start) {
                depthOfStart = curPath.size()-1;
            }
            if (root.right==null && root.left == null) {
                paths.add(new LinkedList<>(curPath));
            }
            else {
                bfs(root.left, curPath, paths, start);
                bfs(root.right, curPath, paths, start);
            }
            curPath.remove(Integer.valueOf(root.val));
        }
    }*/

    /*Wrong Answer
56 / 80 testcases passed*/
    /*public int amountOfTime(TreeNode root, int start) {
        List<List<Integer>> paths = new LinkedList<>();
        bfs(root, new LinkedList<>(), paths, start);
        int max = 0;
        for (List<Integer> path : paths) {
            if (path.contains(start))
                max = Math.max(max, (path.size()-1)-depthOfStart);
            else max = Math.max(max, (path.size()-1) + depthOfStart);
        }
        max = Math.max(max, depthOfStart);
        return max;
    }

    private void bfs(TreeNode root, LinkedList<Integer> curPath, List<List<Integer>> paths, int start) {
        if (root != null) {
            curPath.add(root.val);
            if (root.val == start) {
                depthOfStart = curPath.size()-1;
            }
            if (root.right==null && root.left == null) {
                paths.add(new LinkedList<>(curPath));
            }
            else {
                bfs(root.left, curPath, paths, start);
                bfs(root.right, curPath, paths, start);
            }
            curPath.remove(Integer.valueOf(root.val));
        }
    }*/

    /*class GNode {
        public List<GNode> neighbours;
    }

    public int amountOfTime(TreeNode root, int start) {

    }

    private void convertToGraph(TreeNode root, int start) {

    }*/
}
