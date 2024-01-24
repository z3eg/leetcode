package com.company;

import com.company.util.tree.bst.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class _1457 {

    /*Time Limit Exceeded
53 / 56 testcases passed*/
    /*public int pseudoPalindromicPaths (TreeNode root) {
        List<List<Integer>> paths = new LinkedList<>();
        gatherPaths(root, new LinkedList<>(), paths);
        int counter = 0;
        for (List<Integer>  path: paths) {
            if (isPP(path))
                counter++;
        }
        return counter;
    }

    void gatherPaths(TreeNode root, List<Integer> curPath *//*TODO try stack here*//*, List<List<Integer>> paths) {
        if (root!=null) {
            curPath.add(root.val);
            if (root.left == null && root.right == null) {
                paths.add(new LinkedList<>(curPath));
            }
            else {
                if (root.left!=null) {
                    gatherPaths(root.left, curPath, paths);
                }
                if (root.right!=null) {
                    gatherPaths(root.right, curPath, paths);
                }
            }
            curPath.remove(curPath.size()-1);
        }
    }

    boolean isPP(List<Integer> list) {
        int[] freqs = new int[10];
        for (Integer n : list) {
            freqs[n]++;
        }
        boolean oddFound = false;
        for (int i = 1; i < 10; i++) {
            if (freqs[i]%2==1) {
                if (oddFound)
                    return false;
                oddFound = true;
            }
        }
        return true;
    }*/

    /*11
    ms
            Beats
77.94%
    of users with Java*/
    int counter;

    public int pseudoPalindromicPaths (TreeNode root) {
        counter = 0;
        gatherPaths(root, new int[10]);
        return counter;
    }

    void gatherPaths(TreeNode root, int[] freqs) {
        if (root!=null) {
            freqs[root.val]++;
            if (root.left == null && root.right == null) {
                if (isPP(freqs))
                    counter++;
            }
            else {
                if (root.left!=null) {
                    gatherPaths(root.left, freqs);
                }
                if (root.right!=null) {
                    gatherPaths(root.right, freqs);
                }
            }
            freqs[root.val]--;
        }
    }

    boolean isPP(int[] freqs) {
        boolean oddFound = false;
        for (int i = 1; i < 10; i++) {
            if (freqs[i]%2==1) {
                if (oddFound)
                    return false;
                oddFound = true;
            }
        }
        return true;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        assertEquals(2, pseudoPalindromicPaths(root));

        root = new TreeNode(2);
        assertEquals(1, pseudoPalindromicPaths(root));

        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(1);
        assertEquals(1, pseudoPalindromicPaths(root));
    }
}
