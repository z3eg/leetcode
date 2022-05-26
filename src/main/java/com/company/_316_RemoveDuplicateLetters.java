package com.company;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;


//https://leetcode.com/problems/remove-duplicate-letters/
public class _316_RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        Map<Character, List<Integer>> charToIndexesMap = new TreeMap<>();
        Map<Integer, Character> indexToCharMap = new TreeMap<>();
        char[] chars = s.toCharArray();
        //forming the map
        for (int i = 0; i < chars.length; i++) {
            char curChar = chars[i];
            List<Integer> positions = charToIndexesMap.get(chars[i]);
            if (positions == null)
                positions = new LinkedList<>();
            positions.add(i);
            charToIndexesMap.put(curChar, positions);
        }
        //after that removing the dupes
        Character key = charToIndexesMap.entrySet().iterator().next().getKey();
        int prevIndex = s.indexOf(key);
//        int prevIndex = s.indexOf('a');
        charToIndexesMap.forEach( (k,v) -> {
            indexToCharMap.put(removeDupes(v, prevIndex),k);
        });
        AtomicReference<String> res = new AtomicReference<>("");
        indexToCharMap.forEach((k,v) -> {
            res.updateAndGet(v1 -> v1 + v);
        });
        return res.get();
    }

    private int removeDupes(List<Integer> list, int border) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > border) {
                return list.get(i);
            }
        }
        return list.get(0);
    }

    @Test
    public void testRemoveDupes() {
        LinkedList<Integer> i1 = new LinkedList<>();
        i1.add(1);
        i1.add(3);
        i1.add(5);
        assertEquals(3, removeDupes(i1,2));
    }

    @Test
    public void test() {
        assertEquals("adbc", removeDuplicateLetters("cdadabcc"));
        assertEquals("abc", removeDuplicateLetters("bcabc"));
        assertEquals("acdb", removeDuplicateLetters("cbacdcbc"));
    }
}
