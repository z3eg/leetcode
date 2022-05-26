package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/longest-common-prefix/
public class _14_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length==1) {
            return strs[0];
        }
        int shortest = Integer.MAX_VALUE;
        for (String s: strs) {
            if (s.length()==0) {
                return "";
            }
            shortest = Math.min(shortest,s.length());
        }
        int len = shortest;
        if (allStartWith(strs, strs[0])) {
            return strs[0];
        }
        while (!allStartWith(strs, strs[0].substring(0,len))) {
            len/=2;
            if (len==0) {
                return "";
            }
        }
        while (allStartWith(strs, strs[0].substring(0,len)) && len*1.5<shortest) {
            len+=Math.ceil((float)len/2);
        }
        while (!allStartWith(strs, strs[0].substring(0,len))) {
            len--;
        }
        return strs[0].substring(0,len);
    }

    public boolean allStartWith(String[] strs, String pref) {
        for (String s : strs) {
            if (!s.startsWith(pref)) {
                return false;
            }
        }
        return true;
    }

    /*Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.*/

    @Test
    public void test() {
        assertEquals("abc", longestCommonPrefix(new String[]{"abca","abc"}));
        assertEquals("flower", longestCommonPrefix(new String[]{"flower","flower","flower","flower"}));
        assertEquals("", longestCommonPrefix(new String[]{"",""}));
        assertEquals("", longestCommonPrefix(new String[]{""}));
        assertEquals("fl", longestCommonPrefix(new String[]{"flower","flow","flight"}));
        assertEquals("", longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
