package com.company;

import com.company.util.tree.bst.TreeNode;

import java.util.LinkedList;
import java.util.List;

/*637. Average of Levels in Binary Tree
        https://leetcode.com/problems/average-of-levels-in-binary-tree/description/*/
public class _637 {

    /*5ms
    Beats 6.74%of users with Java*/
    /*public List<Double> averageOfLevels(TreeNode root) {
        List<Double> sums = new LinkedList<>();
        List<Integer> counts = new LinkedList<>();
        dfs(root, 0, sums, counts);
        for (int i = 0; i < sums.size(); i++) {
            Double sum = sums.get(i);
            sum/=counts.get(i);
            sums.set(i, sum);
        }
        return sums;
    }

    public void dfs(TreeNode root, int depth, List<Double> sums, List<Integer> counts) {
        if (root!=null) {
            Double sum;
            Integer count;
            if (depth>=sums.size()) {
                sums.add(0d);
                counts.add(0);
                sum = 0d;
                count = 0;
            }
            else {
                sum = sums.get(depth);
                count = counts.get(depth);
            }
            sum+=root.val;
            count++;
            sums.set(depth,sum);
            counts.set(depth,count);
            dfs(root.left,depth+1,sums,counts);
            dfs(root.right,depth+1,sums,counts);
        }
    }*/


    /*1ms
    Beats 100.00%of users with Java*/
    public List<Double> averageOfLevels(TreeNode root) {
        double[] sums = new double[10000];
        int[] counts = new int[10000];
        int maxDepth = dfs(root, 0, sums, counts, 0);
        List<Double> res = new LinkedList<>();
        for (int i = 0; i <= maxDepth; i++) {
            res.add(sums[i]/counts[i]);
        }
        return res;
    }

    public int dfs(TreeNode root, int depth, double[] sums, int[] counts, int maxDepth) {
        if (root!=null) {
            sums[depth]+=root.val;
            counts[depth]++;
            maxDepth = Math.max(depth, maxDepth);
            maxDepth = Math.max(depth, dfs(root.left,depth+1,sums,counts, maxDepth));
            maxDepth = Math.max(depth, dfs(root.right,depth+1,sums,counts, maxDepth));
        }
        return maxDepth;
    }
}
