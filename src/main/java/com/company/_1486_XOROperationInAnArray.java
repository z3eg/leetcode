package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/xor-operation-in-an-array/
public class _1486_XOROperationInAnArray {
    //1ms, not optimal enough
    /*public int xorOperation(int n, int start) {
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = start + 2 * i;
        }
        int res = ints[0];
        for (int i = 1; i < n; i++) {
            res^=ints[i];
        }
        return res;
    }*/
    public int xorOperation(int n, int start) {
        int res = start;
        for (int i = 1; i < n; i++) {
            res^=start+2*i;
        }
        return res;
    }


    @Test
    public void test() {
        assertEquals(8, xorOperation(5,0));
        assertEquals(8, xorOperation(4,3));
    }

    /*Example 1:

Input: n = 5, start = 0
Output: 8
Explanation: Array nums is equal to [0, 2, 4, 6, 8] where (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8.
Where "^" corresponds to bitwise XOR operator.
Example 2:

Input: n = 4, start = 3
Output: 8
Explanation: Array nums is equal to [3, 5, 7, 9] where (3 ^ 5 ^ 7 ^ 9) = 8.*/
}
