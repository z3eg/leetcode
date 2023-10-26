package com.company;

import com.company.util.tree.bst.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _823 {
    /*public int numFactoredBinaryTrees(int[] arr) {
        if (arr.length < 2)
            return 1;
        Arrays.sort(arr);
        int max = 1;
        int[] dp = new int[arr.length];
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, dp(i, dp, arr));
        }
        return max;
    }

    int dp(int pos, int[] dp, int[] arr) {
        if (dp[pos]!=0)
            return dp[pos];
        dp[pos] = 1;
        for (int i = pos-1; i >= 0; i--) {
            if (arr[pos]%arr[i]==0) {
                int other = arr[pos] / arr[i];
                int otherPos = bs(arr, other, 0, i);
                if (otherPos != -1) {
                    dp[pos] = Math.max(dp[pos], dp(i, dp, arr) + dp(otherPos, dp, arr)) % 1_000_000_007;
                }
            }
        }
        return dp[pos];
    }

    int bs(int[] arr, int n, int l, int r) {
        if (r-l<=1)
            return arr[l]==n?l:-1;
        int mid = (r+l)/2;
        if (arr[mid] == n)
            return mid;
        if (n < arr[mid])
            return bs(arr, n, l, mid);
        if (n > arr[mid])
            return bs(arr, n, mid, r);
        return -1;
    }

    int bs(int[] arr, int n) {
        return bs(arr, n, 0, arr.length);
    }

    @Test
    public void testBs() {
        assertEquals(1, bs(new int[]{1,2,3,4}, 2));
        assertEquals(2, bs(new int[]{1,10,100,1002}, 100));
        assertEquals(3, bs(new int[]{1,10,100,1002}, 1002));
        assertEquals(0, bs(new int[]{1,10,100,1002}, 1));
        assertEquals(-1, bs(new int[]{1,10,100,1002}, -1));
        assertEquals(-1, bs(new int[]{1,10,100,1002}, 15));
    }*/

    public int numFactoredBinaryTrees(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res++;
            res = maxTrees(arr, arr[i], res);
        }
        return res;
    }

    int maxTrees(int[] arr, int cur, int res) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i]*arr[j] == cur) {
                    res++;
                    res = maxTrees(arr, arr[i], res) % 1_000_000_007;
                    res = maxTrees(arr, arr[j], res) % 1_000_000_007;
                }
            }
        }
        return res;
    }


    @Test
    public void test() {
        assertEquals(3, numFactoredBinaryTrees(new int[]{2,4}));
        assertEquals(7, numFactoredBinaryTrees(new int[]{2,4,5,10}));
    }
}
