package com.company;

import org.junit.Test;

import java.math.BigInteger;
import java.util.BitSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
public class _1461_CheckIfAStringContainsAllBinaryCodesOfSizeK {

    public boolean hasAllCodes(String s, int k) {
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < s.length()-k+1; i++) {
            String substring = s.substring(i, i + k);
            strings.add(substring);
            if (strings.size() == Math.pow(2,k)) {
                return true;
            }
        }
        return false;
    }


    //tried "cutting" into 32-bit ints and bitwise but perhaps bigint is a better option
    /*public boolean hasAllCodes(String s, int k) {
        LinkedList<Integer> integers = new LinkedList<>();
        while (s.length() > 0) {
            integers.add(Integer.valueOf(s.substring(0,32)));
            s = s.substring(32);
        }
        for (int i = 0; i <Math.pow(2,k); i++) {
            StringBuilder binaryString = new StringBuilder(Integer.toBinaryString(i));
            while (binaryString.length() < k) {
                binaryString.insert(0, "0");
            }
        }
        for (int i = 0; i < integers.size(); i++) {
            Integer integer = integers.get(i);
            for (int j = 0; j <Math.pow(2,k); j++) {

            }
        }


        }
    }*/

    //TLE on huge strings
    /*public boolean hasAllCodes(String s, int k) {
        for (int i = 0; i <Math.pow(2,k); i++) {
            StringBuilder binaryString = new StringBuilder(Integer.toBinaryString(i));
            while (binaryString.length()<k) {
                binaryString.insert(0, "0");
            }
            if (!s.contains(binaryString.toString())) {
                return false;
            }
        }
        return true;
    }*/

    @Test
    public void test() {
        assertTrue(hasAllCodes("00110",2));
        assertTrue(hasAllCodes("00110110", 2));
        assertTrue(hasAllCodes("0110", 1));
        assertFalse(hasAllCodes("0110", 2));
    }

    /*Given a binary string s and an integer k, return true if every binary code of length k is a substring of s. Otherwise, return false.

Example 1:

Input: s = "00110110", k = 2
Output: true
Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found as substrings at indices 0, 1, 3 and 2 respectively.
Example 2:

Input: s = "0110", k = 1
Output: true
Explanation: The binary codes of length 1 are "0" and "1", it is clear that both exist as a substring.
Example 3:

Input: s = "0110", k = 2
Output: false
Explanation: The binary code "00" is of length 2 and does not exist in the array.


Constraints:

1 <= s.length <= 5 * 105
s[i] is either '0' or '1'.
1 <= k <= 20*/
}
