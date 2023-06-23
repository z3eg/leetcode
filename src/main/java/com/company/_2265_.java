package com.company;

import com.company.util.tree.TreeBuilder;
import com.company.util.tree.BSTNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
//Count Nodes Equal to Average of Subtree
public class _2265_ {

    public int averageOfSubtree(BSTNode root) {
        int res = 0;
        if (root.left!=null) {
            res+=averageOfSubtree(root.left);
        }
        if (root.right!=null) {
            res+=averageOfSubtree(root.right);
        }
        if (root.val==average(root)) {
            res++;
        }
        return res;
    }

    public int average(BSTNode root) {
        int sum = root.val;
        int num = 1;
        if (root.left!=null) {
            sum+=average(root.left);
            num++;
        }
        if (root.right!=null) {
            sum+=average(root.right);
            num++;
        }
        return (int) Math.floor((double) sum/num);
    }


    @Test
    public void test() throws InterruptedException {
        BSTNode tree = TreeBuilder.convert("1,null,3,null,1,null,3");
//        draw(tree);
        assertEquals(1, averageOfSubtree(tree));
        assertEquals(5, averageOfSubtree(TreeBuilder.convert("4,8,5,0,1,null,6")));
    }
}
