package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

//https://leetcode.com/problems/decode-xored-array/
public class _1720_DecodeXORedArray {

    //TODO optimize
    public int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length+1];
        res[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            res[i+1] = res[i]^encoded[i];
        }
        return res;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{1,0,2,1}, decode(new int[]{1,2,3},1));
        assertArrayEquals(new int[]{4,2,0,7,4}, decode(new int[]{6,2,7,3},4));
    }

    /*Example 1:

Input: encoded = [1,2,3], first = 1
Output: [1,0,2,1]
Explanation: If arr = [1,0,2,1], then first = 1 and encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
Example 2:

Input: encoded = [6,2,7,3], first = 4
Output: [4,2,0,7,4]


Constraints:

2 <= n <= 104
encoded.length == n - 1
0 <= encoded[i] <= 105
0 <= first <= 105*/
}
