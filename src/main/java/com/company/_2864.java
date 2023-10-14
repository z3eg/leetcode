package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*2864. Maximum Odd Binary Number
        https://leetcode.com/problems/maximum-odd-binary-number/description/*/
public class _2864 {
    /*2ms
    Beats 76.57%of users with Java*/
    public String maximumOddBinaryNumber(String s) {
        if (!s.contains("0") || s.length()==1)
            return s;
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '1') {
                chars[i] = '0';
                chars[0] = '1';
                break;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = chars.length-1; i >=0; i--) {
            res.append(chars[i]);
        }
        return res.toString();
    }

    @Test
    public void test() {
        assertEquals("1", maximumOddBinaryNumber("1"));
        assertEquals("111", maximumOddBinaryNumber("111"));
        assertEquals("001", maximumOddBinaryNumber("010"));
        assertEquals("1001", maximumOddBinaryNumber("0101"));
    }
}
