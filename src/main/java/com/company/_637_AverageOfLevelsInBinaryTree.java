package com.company;

import javax.print.attribute.standard.MediaSize;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/average-of-levels-in-binary-tree/
public class _637_AverageOfLevelsInBinaryTree {


    private class TreeNode {
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

    /*public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<TreeNode> res = new LinkedList<>();
        while (root!=null) {

        }
    }

    public double averageOfChildren(TreeNode root, List<Double> list) {
        if (root.left==null && root.right==null)
            return 0;
        if (root.left==null)
            return
    }*/
}
