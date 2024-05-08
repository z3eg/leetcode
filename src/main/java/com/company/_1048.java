package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*1048. Longest String Chain
        https://leetcode.com/problems/longest-string-chain/description/?envType=daily-question&envId=2023-09-23*/
public class _1048 {

    /*Time Limit Exceeded
    78 / 84 testcases passed*/
    /*public int longestStrChain(String[] words) {
        boolean[][] dp = new boolean[words.length][words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (isPredecessor(words[i],words[j])) {
                    dp[i][j] = true;
                }
            }
        }
        int max = 1;
        boolean[] used = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            used[i] = true;
            max = Math.max(max, dfs(words, i, used, 1,1, dp));
            used[i] = false;
        }
        return max;
    }

    int dfs(String[] words, int j, boolean[] used, int curLen, int maxLen, boolean[][] dp) {
        for (int i = 0; i < words.length; i++) {
            if (!used[i] && dp[j][i]) {
                used[i] = true;
                maxLen = Math.max(dfs(words, i, used, curLen+1, maxLen, dp),maxLen);
                used[i] = false;
            }
        }
        if (curLen > maxLen)
            maxLen = curLen;
        return maxLen;
    }*/

    /*145ms
    Beats 6.84%of users with Java*/
    public int longestStrChain(String[] words) {
        //sort words by len
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < words.length-1; i++) {
                if (words[i].length()<words[i+1].length()) {
                    sorted = false;
                    String tmp = words[i];
                    words[i] = words[i+1];
                    words[i+1] = tmp;
                }
            }
        }
        //
        boolean[][] dp = new boolean[words.length][words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (isPredecessor(words[i],words[j])) {
                    dp[i][j] = true;
                }
            }
        }
        int[] lCMap = new int[words.length];
        lCMap[0]= 1;
        int biggestLen = words[0].length();
        int i = 0;
        while (i < words.length && words[i].length()==biggestLen) {
            lCMap[i]= 1;
            i++;
        }
        int maxLen = 1;
        for (int j = i; j < words.length; j++) {
            int maxCurLen = 1;
            for (int k = j-1; k >= 0; k--) {
                int curLen = 1;
                if (dp[j][k]) {
                    int kLen = lCMap[k];
                    if (lCMap[k]==0) {
                        kLen = 1;
                        lCMap[k] = kLen;
                    }
                    maxCurLen = Math.max(curLen+kLen, maxCurLen);
                }
            }
            lCMap[j]=maxCurLen;
            maxLen = Math.max(maxLen, maxCurLen);
        }
        return maxLen;
    }

    boolean isPredecessor(String a, String b) {
        if ("".equals(a))
            return true;
        if (b.length()!=a.length()+1)
            return false;
        int i = 0;
        while (i < a.length() && a.charAt(i)==b.charAt(i))
            i++;
        while (i < a.length()) {
            if (a.charAt(i)!=b.charAt(i+1))
                return false;
            i++;
        }
        return true;
    }

    @Test
    public void testIsPredecessor() {
        assertTrue(isPredecessor("","aabc"));
        assertTrue(isPredecessor("abc","aabc"));
        assertTrue(isPredecessor("abc","abac"));
        assertTrue(isPredecessor("abc","abcd"));
        assertFalse(isPredecessor("cba","bcad"));
        assertFalse(isPredecessor("abc","abc"));
        assertFalse(isPredecessor("abc","abccc"));
    }

    @Test
    public void test() {
        assertEquals(7, longestStrChain(new String[]{"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"}));
        assertEquals(4, longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
        assertEquals(5, longestStrChain(new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"}));
        assertEquals(1, longestStrChain(new String[]{"abcd","dbqca"}));
        assertEquals(1, longestStrChain(new String[]{"abcd","a"}));
        assertEquals(2, longestStrChain(new String[]{"abcd","abc"}));
    }
}
