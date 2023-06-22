package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*2710. Remove Trailing Zeros From a String
        https://leetcode.com/problems/remove-trailing-zeros-from-a-string/*/
public class _2710 {

    /*Runtime
    2 ms
    Beats
    71.66%
    */
    /*public String removeTrailingZeros(String num) {
        int pos = num.length()-1;
        while (num.charAt(pos)=='0') {
            pos--;
        }
        return num.substring(0,pos+1);
    }*/

    public String removeTrailingZeros(String num) {
        char[] chars = num.toCharArray();
        int pos = num.length()-1;
        while (chars[pos]=='0') {
            pos--;
        }
        return num.substring(0,pos+1);
    }

    @Test
    public void test() {
        assertEquals("512301", removeTrailingZeros("51230100"));
        assertEquals("123", removeTrailingZeros("123"));
    }

}
