package com.company;

import com.company.util.TreeNode;

//https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
public class _1038_BinarySearchTreeToGreaterSumTree {


    public TreeNode bstToGst(TreeNode root) {
        return sum(root);
    }

    public TreeNode sum(TreeNode curNode) {
        if (curNode.right!=null) {
            curNode.val += sum(curNode.right).val;
        }
        if (curNode.left!=null) {
            curNode.left.val+=curNode.val;
            sum(curNode.left);
        }
        return curNode;
    }


}
