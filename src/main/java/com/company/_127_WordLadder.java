package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

//https://leetcode.com/problems/word-ladder/
public class _127_WordLadder {

    private int stringDiff(String s1, String s2) {
        if (s1.length()!=s2.length()) {
            return -1;
        }
        else {
            int diff = 0;
            for (int i = 0; i < s1.length(); i++) {
                diff+=Math.abs(s1.charAt(i)-s2.charAt(i));
            }
            return diff;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        String curWord = beginWord;
        int times = 0;
        while (!Objects.equals(curWord, endWord)) {
            wordList.sort((o1, o2) -> {
                return Integer.compare(stringDiff(o2, beginWord) + stringDiff(o2,
                        endWord), stringDiff(o1, beginWord) + stringDiff(o1, endWord));
            });
            curWord = wordList.get(0);
            wordList.remove(0);
            times++;
        }
        return times;
    }

    /*private int countMatches(String s1, String s2) {
        if (s1.length()!=s2.length()) {
            return 0;
        }
        int matchCounter = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i)==s2.charAt(i)) {
                matchCounter++;
            }
        }
        return matchCounter;
    }

    private boolean wordsCanTransit(String s1, String s2) {
        return (countMatches(s1,s2)==s1.length()-1);
    }

    @Test
    public void testWordsCanTransit() {
        assertTrue(wordsCanTransit("miss","mist"));
        assertTrue(wordsCanTransit("mist","miss"));
        assertTrue(wordsCanTransit("hit","hot"));
        assertTrue(wordsCanTransit("hot","dot"));
        assertTrue(wordsCanTransit("dog","dot"));
        assertFalse(wordsCanTransit("dog","lot"));
        assertTrue(wordsCanTransit("dog","log"));
        assertTrue(wordsCanTransit("dog","cog"));
        assertTrue(wordsCanTransit("log","cog"));
    }*/

    @Test
    public void test() {
//        assertNotEquals(3,ladderLength("hot","dog", new ArrayList<>(Arrays.asList("hot","dog","vay"))));
        //TLE
        /*HashSet<String> stringsSet = new HashSet<>(stringsList);
        assertEquals(stringsSet.size(),stringsList.size());*/
        /*ArrayList<String> wordList = new ArrayList<>(Arrays.asList("si"
                , "go", "se", "cm", "so", "ph", "mt", "db", "mb"
                , "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo"
                , "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt"
                , "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz"
                , "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc"
                , "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq"
                , "ye"));*/
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList("sq"
                , "go", "se", "cm", "so", "ph", "mt", "db", "mb"
                , "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo"
                , "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re"/*, "or", "rn", "au", "ur", "rh", "sr", "tc", "lt"
                , "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz"
                , "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc"
                , "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq"
                , "ye"*/));
        System.out.println(wordList.size());
        assertNotEquals(987, ladderLength("qa", "sq", wordList));
        assertEquals(6,ladderLength("leet","code",
                new ArrayList<>(Arrays.asList("lest","leet","lose","code","lode","robe","lost"))));
        assertEquals(4,ladderLength("lost","miss",
                new ArrayList<>(Arrays.asList("most","mist","miss","lost","fist","fish"))));
        assertEquals(2,ladderLength("a","c", new ArrayList<>(Arrays.asList("a","b","c"))));
        assertEquals(3,ladderLength("hot","dog", new ArrayList<>(Arrays.asList("hot","dog","dot"))));
        assertEquals(5,ladderLength("hit","cog", new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
        assertEquals(0,ladderLength("hit","cog", new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"))));
    }
}
