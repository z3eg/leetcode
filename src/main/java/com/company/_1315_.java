package com.company;

import com.company.util.TreeNode;

//https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
//1315. Sum of Nodes with Even-Valued Grandparent
public class _1315_ {
    public int sumEvenGrandparent(TreeNode root) {
        int sum = 0;
        if (root.left!= null) {
            sum+= sumEvenGrandparent(root.left);
            if (root.val%2==0) {
                if (root.left.left!=null)
                    sum+=root.left.left.val;
                if (root.left.right!=null)
                    sum+=root.left.right.val;
            }
        }
        if (root.right!= null) {
            sum+= sumEvenGrandparent(root.right);
            if (root.val%2==0) {
                if (root.right.left!=null)
                    sum+=root.right.left.val;
                if (root.right.right!=null)
                    sum+=root.right.right.val;
            }
        }
        return sum;
    }

}
