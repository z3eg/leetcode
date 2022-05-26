package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/remove-k-digits/
public class _402_RemoveKDigits {

//    5%/5%
    public String removeKdigits(String num, int k) {
        if (k>=num.length()) {
            return "0";
        }
        while (k>0) {
            num = removeBiggest(num);
            k--;
        }
        return normalize(num);
    }

    private String removeBiggest(String num) {
        for (int i = 0; i < num.length()-1; i++) {
            if (num.charAt(i) > num.charAt(i+1)) {
                return num.replaceFirst(String.valueOf(num.charAt(i)),"");
            }
        }
        for (int i = 9; i >= 0; i--) {
            String iString = Integer.toString(i);
            if (num.contains(iString)) {
                return num.replaceFirst(iString,"");
            }
        }
        return num;
    }

    private String normalize(String num) {
        while (num.startsWith("0")) {
            num = num.replaceFirst("0","");
        }
        return num.equals("")?"0":num;
    }

    @Test
    public void test() {
        assertEquals("0", removeKdigits("10001", 4));
        assertEquals("1219", removeKdigits("1432219", 3));
        assertEquals("11", removeKdigits("112", 1));
        assertEquals("0", removeKdigits("10", 1));
        assertEquals("200", removeKdigits("10200", 1));
        assertEquals("0", removeKdigits("10", 2));
    }

    /*Example 1:

    Input: num = "1432219", k = 3
    Output: "1219"
    Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
    Example 2:

    Input: num = "10200", k = 1
    Output: "200"
    Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
            Example 3:

    Input: num = "10", k = 2
    Output: "0"
    Explanation: Remove all the digits from the number and it is left with nothing which is 0.*/
}
