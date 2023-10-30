package com.company;

import com.company.util.tree.bst.TreeNode;
import org.junit.Test;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class _108_ConvertSortedArrayToBinarySearchTree {

    /*private class TreeNode {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        int rootPos = nums.length/2;
        TreeNode root = new TreeNode(nums[rootPos]);
        for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
            int num = nums[i];
            TreeNode curNode = root;
            TreeNode prevNode = curNode;
            while (curNode != null) {
                prevNode = curNode;
                if (num < curNode.val) {
                    curNode = curNode.left;
                } else if (num > curNode.val) {
                    curNode = curNode.right;
                }
                else {
                    break;
                }
            }
            if (num < prevNode.val) {
                prevNode.left = new TreeNode(num);
            } else if (num > prevNode.val) {
                prevNode.right = new TreeNode(num);
            }
        }
        return root;
    }*/


    @Test
    public void test() {
//        sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
}
