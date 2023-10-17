package com.company;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*1361. Validate Binary Tree Nodes
        https://leetcode.com/problems/validate-binary-tree-nodes/description/?envType=daily-question&envId=2023-10-17*/
public class _1361 {
//    37 / 44 testcases passed
    /*public boolean sol1(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> lefts = new HashSet<>();
        Set<Integer> rights = new HashSet<>();
        for (int c : leftChild) {
            if (c==0)
                return false;
            if (c!=-1 && lefts.contains(c))
                return false;
            lefts.add(c);
        }
        for (int c : rightChild) {
            if (c==0)
                return false;
            if (c!=-1 && (lefts.contains(c) || rights.contains(c)))
                return false;
            rights.add(c);
        }
        for (int c : leftChild) {
            if (c != -1 && rights.contains(c))
                return false;
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (leftChild[i]==j && leftChild[j]==i)
                    return false;
                if (rightChild[i]==j && rightChild[j]==i)
                    return false;
            }
        }
        return true;
    }*/

    /*31ms
    Beats 10.75%of users with Java*/
    public int getRoot(int n, int[] leftChild, int[] rightChild) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (leftChild[i]!=-1) {
                if (map.containsKey(leftChild[i]) || (map.get(i)!=null && map.get(i) == leftChild[i]))
                    return -1;
                map.put(leftChild[i], i);
                set.add(leftChild[i]);
            }
            if (rightChild[i]!=-1) {
                if (map.containsKey(rightChild[i]) || (map.get(i)!=null && map.get(i) == rightChild[i]))
                    return -1;
                map.put(rightChild[i], i);
                set.add(rightChild[i]);
            }
            if (leftChild[i]!=-1 || rightChild[i]!=-1)
                set.add(i);
        }
        if (set.size()-map.size()!=1)
            return -1;
        set.removeAll(map.keySet());
        return set.iterator().next();
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        if (n==1)
            return leftChild[0]==-1 && rightChild[0]==-1;
        int root = getRoot(n, leftChild, rightChild);
        if (root==-1)
            return false;
        int rootNodes = countNodes(root, leftChild, rightChild, 0);
        return rootNodes==n;
    }

    int countNodes(int root, int[] leftChild, int[] rightChild, int curNodes) {
        curNodes++;
        if (leftChild[root]!=-1)
            curNodes = countNodes(leftChild[root], leftChild, rightChild, curNodes);
        if (rightChild[root]!=-1)
            curNodes = countNodes(rightChild[root], leftChild, rightChild, curNodes);
        return curNodes;
    }

    @Test
    public void test() {
        assertTrue(validateBinaryTreeNodes(4, new int[]{3,-1,1,-1}, new int[]{-1,-1,0,-1}));
        assertFalse(validateBinaryTreeNodes(6, new int[]{1,2,0,4,-1,-1}, new int[]{-1,-1,-1,5,-1,-1}));
        assertTrue(validateBinaryTreeNodes(1, new int[]{-1}, new int[]{-1}));
        assertFalse(validateBinaryTreeNodes(4, new int[]{1,0,3,-1}, new int[]{-1,-1,-1,-1}));
        assertTrue(validateBinaryTreeNodes(4, new int[]{1,-1,3,-1}, new int[]{2,-1,-1,-1}));
        assertFalse(validateBinaryTreeNodes(4, new int[]{1,-1,3,-1}, new int[]{2,3,-1,-1}));
        assertFalse(validateBinaryTreeNodes(2, new int[]{1,0}, new int[]{-1,-1}));
        assertFalse(validateBinaryTreeNodes(3, new int[]{1,2,0}, new int[]{-1,-1,-1}));
        assertFalse(validateBinaryTreeNodes(6, new int[]{1,-1,-1,4,-1,-1}, new int[]{2,-1,-1,5,-1,-1}));
    }
}
