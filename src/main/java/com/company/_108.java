package com.company;

import com.company.util.tree.bst.TreeNode;
import org.junit.jupiter.api.Test;

public class _108 {
//    5 / 31 testcases passed
    /*public TreeNode sortedArrayToBST(int[] nums) {
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
    }*/

    /*0ms
    Beats 100.00%of users with Java*/
    public TreeNode sortedArrayToBST(int[] nums) {
        return getSubtree(nums, -1, nums.length);
    }

    TreeNode getSubtree(int[] nums, int l, int r) {
        int mid = (l+r)/2;
        if (mid!=l && mid!=r) {
            TreeNode subtree = new TreeNode(nums[mid]);
            subtree.left = getSubtree(nums, l, mid);
            subtree.right = getSubtree(nums, mid, r);
            return subtree;
        }
        else
            return null;
    }

    @Test
    public void test() {
        TreeNode treeNode;
        treeNode = sortedArrayToBST(new int[]{-10});
        treeNode = sortedArrayToBST(new int[]{-10,2,3});
        treeNode = sortedArrayToBST(new int[]{-10,2});
        treeNode = sortedArrayToBST(new int[]{0,1,2,3,4,5});
        treeNode = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println();
    }
}
