package com.company;

import com.company.util.tree.BSTNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*1027. Longest Arithmetic Subsequence
        https://leetcode.com/problems/longest-arithmetic-subsequence/*/
public class _1027 {
    public int longestArithSeqLength(int[] nums) {
        int numLen = nums.length;
        if (numLen==2)
            return 2;
        return 1;
    }

    public void buildATree(BSTNode root, int[] nums, int curPos) {
        for (int i = 0; i < curPos; i++) {

        }
    }

    @Test
    public void test() {
        assertEquals(2, longestArithSeqLength(new int[]{83,20,17,43,52,78,68,45}));
        assertEquals(4, longestArithSeqLength(new int[]{3,6,9,12}));
        assertEquals(3, longestArithSeqLength(new int[]{9,4,7,2,10}));
        assertEquals(4, longestArithSeqLength(new int[]{20,1,15,3,10,5,8}));
    }
}
