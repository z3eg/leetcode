package com.company;

import com.company.util.tree.TreeNode;

import java.util.Arrays;

/*https://leetcode.com/problems/maximum-binary-tree/
654. Maximum Binary Tree*/
public class _654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxPos = i;
            }
        }
        TreeNode root = new TreeNode(max);
        if (maxPos > 0) {
            int[] leftPart = Arrays.copyOfRange(nums, 0, maxPos);
            root.left = constructMaximumBinaryTree(leftPart);
        }
        if (maxPos< nums.length-1) {
            int[] rightPart = Arrays.copyOfRange(nums, maxPos+1, nums.length);
            root.right = constructMaximumBinaryTree(rightPart);
        }
        return root;
    }
}
