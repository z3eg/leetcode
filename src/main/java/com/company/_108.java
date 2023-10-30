package com.company;

import com.company.util.tree.bst.TreeNode;
import org.junit.jupiter.api.Test;

public class _108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==1)
            return new TreeNode(nums[0]);
        int mid = nums.length/2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = root;
        TreeNode right = root;
        int l = mid-1;
        int r = mid+1;
        while (l>=0) {
            left.left = new TreeNode(nums[l]);
            l--;
            left = left.left;
        }
        while (r < nums.length) {
            right.right = new TreeNode(nums[r]);
            r++;
            right = right.right;
        }
        return root;
    }

    @Test
    public void test() {
        TreeNode treeNode;
        treeNode = sortedArrayToBST(new int[]{-10});
        treeNode = sortedArrayToBST(new int[]{-10,2,3});
        treeNode = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        treeNode = sortedArrayToBST(new int[]{-10,2});
        treeNode = sortedArrayToBST(new int[]{0,1,2,3,4,5});
        System.out.println();
    }
}
