package com.company.util.tree;

import com.company.util.StringToArrayConverter;
import org.junit.Test;

public class TreeBuilder {

    public static TreeNode convert(String str) {
        return buildTreeFromArray(StringToArrayConverter.convert(str), 1);
    }

    public static TreeNode buildTreeFromArray(String[] array, int number) {
        if (number-1<array.length) {
            String val = array[number-1];
            if (!"null".equals(val)) {
                TreeNode curNode = new TreeNode(Integer.parseInt(val));
                curNode.left = buildTreeFromArray(array, number*2);
                curNode.right = buildTreeFromArray(array, number*2+1);
                return curNode;
            }
        }
        return null;
    }

    public static TreeNode generateSampleTree() {
        //    https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
        TreeNode four = new TreeNode(4);
        TreeNode one = new TreeNode(1);
        four.left = one;
        TreeNode six = new TreeNode(6);
        four.right = six;
        TreeNode zero = new TreeNode(0);
        one.left = zero;
        TreeNode minusOne = new TreeNode(-1);
        zero.left = minusOne;
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
