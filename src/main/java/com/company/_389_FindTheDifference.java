package com.company;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/find-the-difference/
public class _389_FindTheDifference {

    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (sMap.get(s.charAt(i)) == null) {
                sMap.put(s.charAt(i),0);
            }
            else {
                sMap.put(s.charAt(i),(sMap.get(s.charAt(i))+1));
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (tMap.get(t.charAt(i)) == null) {
                tMap.put(t.charAt(i),0);
            }
            else {
                tMap.put(t.charAt(i),(tMap.get(t.charAt(i))+1));
            }
        }
        Iterator<Map.Entry<Character, Integer>> iterator = tMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> next = iterator.next();
            Character letter = next.getKey();
            Integer times = next.getValue();
            if (!Objects.equals(sMap.get(letter), times)) {
                return letter;
            }
        }
        return 'a';
    }

    @Test
    public void test() {
        assertEquals('e', findTheDifference("abcd", "abcde"));
        assertEquals('y', findTheDifference("", "y"));
    }
}
