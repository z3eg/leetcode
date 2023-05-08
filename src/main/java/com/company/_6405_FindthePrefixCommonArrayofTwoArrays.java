package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

//https://leetcode.com/contest/biweekly-contest-103/problems/find-the-prefix-common-array-of-two-arrays/
public class _6405_FindthePrefixCommonArrayofTwoArrays {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int commonNow = 0;
        int[] res = new int[A.length];
        HashSet<Integer> common = new HashSet<>();
        HashSet<Integer> As = new HashSet<>();
        HashSet<Integer> Bs = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (common.contains(A[i])) {
                commonNow++;
            }
            else {
                if (Bs.contains(A[i])) {
                    common.add(A[i]);
                    commonNow++;
                }
            }
            As.add(A[i]);
            if (common.contains(B[i])) {
                commonNow++;
            }
            else {
                if (As.contains(B[i])) {
                    common.add(B[i]);
                    commonNow++;
                }
            }
            Bs.add(B[i]);
            res[i]=commonNow;
        }
        return res;
    }

    @Test
    public void test() {
        int[] a = new int[]{1,3,2,4};
        int[] b = new int[]{3,1,2,4};
        Assert.assertArrayEquals(new int[]{0,2,3,4}, findThePrefixCommonArray(a, b));
        a = new int[]{2,3,1};
        b = new int[]{3,1,2};
        Assert.assertArrayEquals(new int[]{0,1,3}, findThePrefixCommonArray(a, b));
    }
}
