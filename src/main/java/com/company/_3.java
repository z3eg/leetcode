package com.company;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class _3 {

    /*73
ms
Beats
19.33%*/
    public int lengthOfLongestSubstring(String s) {
        int sLen = s.length();
        if (sLen == 0)
            return 0;
        if (sLen == 1)
            return 1;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        char[] arr = s.toCharArray();
        while (r < sLen) {
            while (l<r && map.getOrDefault(arr[r],0)>0) {
                //shrink window
                map.merge(arr[l],-1,Integer::sum);
                l++;
            }
            map.merge(arr[r],1,Integer::sum);
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }

    @Test
    public void test() {
        assertEquals(4, lengthOfLongestSubstring("1R1T7"));
        assertEquals(2, lengthOfLongestSubstring("mq"));
        assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, lengthOfLongestSubstring("pwwkew"));
    }

}
