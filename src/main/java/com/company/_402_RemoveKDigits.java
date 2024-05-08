package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/remove-k-digits/
public class _402_RemoveKDigits {

//    5%/5%
    //TLE
    /*public String removeKdigits(String num, int k) {
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
    }*/

    /*public String removeKdigits(String num, int k) {
        //lose as many positions on 0s as possible
        int k1 = k;
        int i = 0;
        int lpos = 0;
        while (k1>0 && i < num.length()) {
            if (num.charAt(lpos)!='0') {
                k1--;
            }
            lpos++;
        }
        if (k1==0)
            return "0";
        if (k!=k1) {
            k = k1;
            num = num.substring(lpos);
        }

    }*/

    /*public String removeKdigits(String num, int k) {
        if (k>=num.length())
            return "0";
        int zeroes = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i)=='0')
                zeroes++;
        }
        if (zeroes >= num.length()-k)
            return "0";
        int pos = 0;
        char[] chars = num.toCharArray();
        char [] finChars = new char[chars.length - k];
        int finCharsPos = 0;
        while (k >= 0 && pos < num.length()-1) {
            if (chars[pos+1]=='0') {
                k-=(chars[pos]=='0')?0:1;
                pos+=2;
            }
            if (pos+1 < num.length() && finCharsPos < finChars.length && chars[pos]<=chars[pos+1]) {
                finChars[finCharsPos] = chars[pos];
                finCharsPos++;
            }
            if (pos+1 >= num.length() && pos < num.length() && finCharsPos < finChars.length) {
                finChars[finCharsPos] = chars[pos];
            }
            pos++;
        }
        while (pos < num.length() && finCharsPos < finChars.length) {
            finChars[finCharsPos] = num.charAt(pos);
            finCharsPos++;
            pos++;
        }
        return new String(finChars);
    }*/

    public String removeKdigits(String num, int k) {
        List<Character> list = new LinkedList<>();
        int i = 0;
        while (i < num.length()-1 && k > 0) {
            if (num.charAt(i + 1) == '0') {
                k -= (num.charAt(i) == '0') ? 0 : 1;
                i+=2;
            } else {
                if (num.charAt(i)<=num.charAt(i+1)) {
                    list.add(num.charAt(i));
                }
                else {
                    k--;
                }
                i++;
            }
        }
        if (i < num.length()) {
            k--;
        }
        if (k > 0)
            return "0";
        while (i < num.length()) {
            list.add(num.charAt(i));
            i++;
        }
        StringBuilder sb = new StringBuilder();
        list.stream().forEach(sb::append);
        return sb.toString();
    }

    @Test
    public void test() {
        assertEquals("11", removeKdigits("112", 1));
        assertEquals("1219", removeKdigits("1432219", 3));
        assertEquals("200", removeKdigits("10200", 1));
        assertEquals("0", removeKdigits("10001", 4));
        assertEquals("0", removeKdigits("10", 1));
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
