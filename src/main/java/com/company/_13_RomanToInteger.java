package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/roman-to-integer/
public class _13_RomanToInteger {

    /*Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000*/

    /*I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.*/

    public int romanToInt(String s) {
        int sum = 0;
        while (s.length()>0) {
            if (s.startsWith("IV")) {
                sum+=4;
                s=s.substring(2);
                continue;
            }
            if (s.startsWith("IX")) {
                sum+=9;
                s=s.substring(2);
                continue;
            }
            if (s.startsWith("XL")) {
                sum+=40;
                s=s.substring(2);
                continue;
            }
            if (s.startsWith("XC")) {
                sum+=90;
                s=s.substring(2);
                continue;
            }
            if (s.startsWith("CD")) {
                sum+=400;
                s=s.substring(2);
                continue;
            }
            if (s.startsWith("CM")) {
                sum+=900;
                s=s.substring(2);
            }
            else {
                switch(s.charAt(0)) {
                    case 'I' -> sum+=1;
                    case 'V' -> sum+=5;
                    case 'X' -> sum+=10;
                    case 'L' -> sum+=50;
                    case 'C' -> sum+=100;
                    case 'D' -> sum+=500;
                    case 'M' -> sum+=1000;
                }
                s=s.substring(1);
            }
        }
        return sum;
    }

    @Test
    public void test() {
        assertEquals(3, romanToInt("III"));
        assertEquals(58, romanToInt("LVIII"));
        assertEquals(1994, romanToInt("MCMXCIV"));
    }
}
