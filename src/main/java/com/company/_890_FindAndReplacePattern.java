package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/find-and-replace-pattern/
public class _890_FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        LinkedList<String> res = new LinkedList<>();
        int patternLen = pattern.length();
        char[] patternChars = pattern.toCharArray();
        for (String word : words) {
            if (word.length()==patternLen) {
                Map<Character, Character> map = new HashMap<>();
                char[] chars = word.toCharArray();
                boolean fitsPattern = true;
                for (int i = 0; i < chars.length; i++) {
                    if (!map.containsKey(patternChars[i])) {
                        if (map.containsValue(chars[i])) {
                            fitsPattern = false;
                            break;
                        }
                        map.put(patternChars[i],chars[i]);
                    }
                    else {
                        if (map.get(patternChars[i])!=chars[i]) {
                            fitsPattern = false;
                            break;
                        }
                    }
                }
                if (fitsPattern)
                    res.add(word);
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(Arrays.asList("mee","aqq"),findAndReplacePattern(new String[]{"ccc","abc","deq","mee","aqq","dkd"}, "abb"));
        assertEquals(Arrays.asList("a","b","c"),findAndReplacePattern(new String[]{"a","b","c"}, "a"));
    }
}
