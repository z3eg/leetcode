package com.company;

import com.company.util.tree.bst.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/*1022. Sum of Root To Leaf Binary Numbers
        https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/*/
public class _1022 {

    /*1ms
    Beats 50.44%of users with Java*/
    public int sumRootToLeaf(TreeNode root) {
        return sum(0,root,new LinkedList<>());
    }

    int sum(int curSum, TreeNode root, List<Integer> curList) {
        if (root!=null) {
            curList.add(root.val);
            if (root.left==null && root.right==null) {
                int num = 0;
                for (int i = curList.size()-1; i>=0; i--) {
                    num+=curList.get(i)*Math.pow(2,(curList.size()-1-i));
                }
                curSum+=num;
            }
            else {
                if (root.left!=null) {
                    curSum = sum(curSum, root.left, curList);
                }
                if (root.right!=null) {
                    curSum = sum(curSum, root.right, curList);
                }
            }
            curList.remove(curList.size()-1);
        }
        return curSum;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(0);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(0);
        System.out.println(sumRootToLeaf(root));
    }
}
