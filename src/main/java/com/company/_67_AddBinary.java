package com.company;

import org.junit.Test;

import java.math.BigInteger;
import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/add-binary/
public class _67_AddBinary {

    /*public String addBinary(String a, String b) {

        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int max = Math.max(aChars.length, bChars.length);
        int min = Math.min(aChars.length, bChars.length);
        char[] cChars = new char[max+1];
        *//*for (int i = ; i < ; i++) {

        }*//*
    }*/

    private BigInteger strToInt(String a) {
        char[] chars = a.toCharArray();
        BigInteger res = BigInteger.ZERO;
        long pow = 0;
        for (int i = chars.length-1; i >= 0; i--) {
            res = res.add((chars[i]=='1'?BigInteger.ONE:BigInteger.ZERO).
                    multiply(BigInteger.valueOf((long)(Math.pow(2,pow)))));
            pow++;
        }
        return res;
    }

    @Test
    public void testStrToInt() {
        assertEquals(1,strToInt("01"));
        assertEquals(2,strToInt("10"));
        assertEquals(3,strToInt("11"));
    }

    /*@Test
    public void test() {

        assertEquals("110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000"
                ,addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
                ,"110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));

        assertEquals("100",addBinary("11","1"));
        assertEquals("10101",addBinary("1010","1011"));
    }*/

    /*Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"*/

}
