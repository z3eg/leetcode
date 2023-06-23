package com.company;

import com.company.util.tree.TreeBuilder;
import com.company.util.tree.BSTNode;
import com.company.util.tree.TreeVisualizer;
import org.junit.Test;

//https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
public class _1038_BinarySearchTreeToGreaterSumTree {

    public BSTNode bstToGst(BSTNode root) {
        sum(root, 0);
        return root;
    }

    public int sum(BSTNode curNode, int curSum) {
        if (curNode.right!=null) {
            curSum =sum(curNode.right, curSum);
        }
        curSum+=curNode.val;
        curNode.val = curSum;
        if (curNode.left!=null) {
            return sum(curNode.left, curSum);
        }
        return curSum;
    }

    @Test
    public void test() throws InterruptedException {
        BSTNode root = TreeBuilder.convert("[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]");
        BSTNode newRoot = bstToGst(root);
        TreeVisualizer.draw(newRoot);
    }


}
