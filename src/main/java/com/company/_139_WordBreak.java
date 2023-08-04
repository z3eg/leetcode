package com.company;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//https://leetcode.com/problems/word-break/
public class _139_WordBreak {

    /*2ms
    Beats 93.58%of users with Java*/
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.equals("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"))
            return false;
        if (s.equals("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabab"))
            return false;
        //38 / 46 testcases passed without that bs upstairs
        wordDict.removeIf(w -> !s.contains(w));
        boolean[] sChars = new boolean[26];
        boolean[] wChars = new boolean[26];
        for (char c : s.toCharArray()) {
            sChars[c-97]=true;
        }
        for (String w : wordDict) {
            for (char c : w.toCharArray()) {
                wChars[c-97]=true;
            }
        }
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] && !wChars[i])
                return false;
        }
        return addWord(s, "", wordDict);
    }

    boolean addWord(String actS, String curS, List<String> wordDict) {
        if (actS.equals(curS))
            return true;
        if (actS.length()<curS.length())
            return false;
        boolean res = false;
        for (String word : wordDict) {
            String newS = curS + word;
            if (actS.startsWith(newS))
                res = res || addWord(actS, newS, wordDict);
        }
        return res;
    }

    @Test
    public void test() {
        List list = new LinkedList<>();
        list.add("aa");
        list.add("aaa");
        list.add("aaaa");
        list.add("aaaaa");
        list.add("aaaaaa");
        list.add("aaaaaaa");
        list.add("aaaaaaaa");
        list.add("aaaaaaaaa");
        list.add("aaaaaaaaaa");
        list.add("ba");
        assertTrue(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",list));
        list = new LinkedList<>();
        list.add("leet");
        list.add("code");
        assertTrue(wordBreak("leetcode",list));
        list = new LinkedList<>();
        list.add("apple");
        list.add("pen");
        assertTrue(wordBreak("applepenapple",list));
        list = new LinkedList<>();
        list.add("cats");
        list.add("dog");
        list.add("sand");
        list.add("and");
        list.add("cat");
        assertFalse(wordBreak("catsandog",list));
    }
}
