package com.company.util;

import org.junit.Test;

public class ArrayToGraphConverter {

    /*public static TreeNode convert(String arrayString) {

    }*/

    public static TreeNode generateSampleTree() {
        //    https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
        TreeNode four = new TreeNode(4);
        TreeNode one = new TreeNode(1);
        four.left = one;
        TreeNode six = new TreeNode(6);
        four.right = six;
        TreeNode zero = new TreeNode(0);
        one.left = zero;
        TreeNode two = new TreeNode(2);
        one.right = two;
        TreeNode five = new TreeNode(5);
        six.left = five;
        TreeNode seven = new TreeNode(7);
        six.right = seven;
        TreeNode three = new TreeNode(3);
        two.right = three;
        TreeNode eight = new TreeNode(8);
        seven.right = eight;
        return four;
    }


    @Test
    public void test() {

    }
}
