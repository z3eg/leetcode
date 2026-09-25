package com.company;

import org.junit.Test;

import java.math.BigInteger;
import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/add-binary/
public class _67_AddBinary {

    /*1 ms
Beats
99.97%
*/
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int sLen;
        int lLen;
        String sStr;
        String lStr;
        if (aLen <= bLen) {
            sLen = aLen;
            lLen = bLen;
            sStr = a;
            lStr = b;
        }
        else {
            sLen = bLen;
            lLen = aLen;
            sStr = b;
            lStr = a;
        }
        return propagate(sLen, lLen, sStr, lStr);

    }

    public String propagate(int sLen, int lLen, String sStr, String lStr) {
        boolean carryOver = false;
        char[] sChars = sStr.toCharArray();
        char[] lChars = lStr.toCharArray();
        int sPos = sLen;
        int lPos = lLen;
        char charS;
        char charL;
        int sum;
        while (lPos>0) {
            sum = 0;
            sPos--;
            lPos--;
            if (sPos>=0)
                charS = sChars[sPos];
            else
                charS = '0';
            charL = lChars[lPos];
            if (carryOver)
                sum++;
            if (charL=='1')
                sum++;
            if (charS=='1')
                sum++;
            lChars[lPos] = (sum % 2 == 0)?'0':'1';
            carryOver = sum>1;
        }
        String s = new String(lChars);
        if (carryOver) {
            return "1"+ s;
        }
        return s;
    }

    @Test
    public void test() {


        assertEquals("110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000"
                ,addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
                        ,"110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
        assertEquals("10101",addBinary("1010","1011"));
        assertEquals("100",addBinary("11","1"));
    }

    /*Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"*/

}
