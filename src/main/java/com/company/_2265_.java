package com.company;

import com.company.util.tree.TreeBuilder;
import com.company.util.tree.bst.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
//Count Nodes Equal to Average of Subtree
public class _2265_ {

    /*public int averageOfSubtree(TreeNode root) {
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

    public int average(TreeNode root) {
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
    }*/

//    1ms
//    Beats 48.09%of users with Java
    public int averageOfSubtree(TreeNode root) {
        int[] res = new int[1];
        avg(root, res);
        return res[0];
    }

    int[] avg(TreeNode root, int[] res) {
        int[] countAndSum = new int[2];
        countAndSum[0] = 1;
        countAndSum[1] = root.val;
        if (root.left!=null) {
            int[] leftCAS = avg(root.left, res);
            countAndSum[0] += leftCAS[0];
            countAndSum[1] += leftCAS[1];
        }
        if (root.right!=null) {
            int[] rightCAS = avg(root.right, res);
            countAndSum[0] += rightCAS[0];
            countAndSum[1] += rightCAS[1];
        }
        double avg = Math.floor((double) countAndSum[1] /countAndSum[0]);
        if (root.val == avg)
            res[0]++;
        return countAndSum;
    }


    @Test
    public void test() throws InterruptedException {
        TreeNode tree = TreeBuilder.convert("1,null,3,null,1,null,3");
//        draw(tree);
        assertEquals(1, averageOfSubtree(tree));
        assertEquals(5, averageOfSubtree(TreeBuilder.convert("4,8,5,0,1,null,6")));
    }
}
