package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
public class _1309_DecryptStringfromAlphabettoIntegerMapping {
    public String freqAlphabets(String s) {
        String[] split = s.split("#");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i< split.length-1; i++){
            while (split[i].length()>2) {
                stringBuilder.append(mapInt(split[i].charAt(0)-'0'));
                split[i] = split[i].substring(1);
            }
            if (split[i].length()>0)
                stringBuilder.append(mapInt(Integer.parseInt(split[i])));
        }
        String end = split[split.length-1];
        int edge = 0;
        if (s.endsWith("#"))
            edge=2;
        while (end.length()>edge) {
            stringBuilder.append(mapInt(end.charAt(0)-'0'));
            end = end.substring(1);
        }
        if (end.length()>0)
            stringBuilder.append(mapInt(Integer.parseInt(end)));
        return stringBuilder.toString();
    }

    private char mapInt(int i) {
        return (char)('a'-1+i);
    }

    @Test
    public void test() {
        assertEquals("abcdefghijklmnopqrstuvwxyz", freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
        assertEquals("jkab", freqAlphabets("10#11#12"));
        assertEquals("acz", freqAlphabets("1326#"));

    }

    /*You are given a string s formed by digits and '#'. We want to map s to English lowercase characters as follows:

Characters ('a' to 'i') are represented by ('1' to '9') respectively.
Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
Return the string formed after mapping.

The test cases are generated so that a unique mapping will always exist.



Example 1:

Input: s = "10#11#12"
Output: "jkab"
Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
Example 2:

Input: s = "1326#"
Output: "acz"


Constraints:

1 <= s.length <= 1000
s consists of digits and the '#' letter.
s will be a valid string such that mapping is always possible.*/

}
