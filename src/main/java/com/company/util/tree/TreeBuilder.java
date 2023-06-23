package com.company.util.tree;

import com.company.util.StringToArrayConverter;
import org.junit.Test;

public class TreeBuilder {

    public static BSTNode convert(String str) {
        return buildTreeFromArray(StringToArrayConverter.convert(str), 1);
    }

    public static BSTNode buildTreeFromArray(String[] array, int number) {
        if (number-1<array.length) {
            String val = array[number-1];
            if (!"null".equals(val)) {
                BSTNode curNode = new BSTNode(Integer.parseInt(val));
                curNode.left = buildTreeFromArray(array, number*2);
                curNode.right = buildTreeFromArray(array, number*2+1);
                return curNode;
            }
        }
        return null;
    }

    public static BSTNode generateSampleTree() {
        //    https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
        BSTNode four = new BSTNode(4);
        BSTNode one = new BSTNode(1);
        four.left = one;
        BSTNode six = new BSTNode(6);
        four.right = six;
        BSTNode zero = new BSTNode(0);
        one.left = zero;
        BSTNode minusOne = new BSTNode(-1);
        zero.left = minusOne;
        BSTNode two = new BSTNode(2);
        one.right = two;
        BSTNode five = new BSTNode(5);
        six.left = five;
        BSTNode seven = new BSTNode(7);
        six.right = seven;
        BSTNode three = new BSTNode(3);
        two.right = three;
        BSTNode eight = new BSTNode(8);
        seven.right = eight;
        return four;
    }


    @Test
    public void test() {

    }
}
