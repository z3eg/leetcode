package com.company;

import com.company.util.tree.bst.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class _1457 {

    /*Time Limit Exceeded
53 / 56 testcases passed*/
    public int pseudoPalindromicPaths (TreeNode root) {
        List<List<Integer>> paths = new LinkedList<>();
        gatherPaths(root, new LinkedList<>(), paths);
        int counter = 0;
        for (List<Integer>  path: paths) {
            if (isPP(path))
                counter++;
        }
        return counter;
    }

    void gatherPaths(TreeNode root, List<Integer> curPath /*TODO try stack here*/, List<List<Integer>> paths) {
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
    }

    @Test
    public void testIsPP() {
        List<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(1);
        list.add(1);
        assertTrue(isPP(list));

        list = new LinkedList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        assertTrue(isPP(list));

        list = new LinkedList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        assertTrue(isPP(list));

        list = new LinkedList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        assertFalse(isPP(list));

        list = new LinkedList<>();
        list.add(1);
        assertTrue(isPP(list));
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
