package com.company;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/decode-the-message/
public class _2325_DecodeTheMessage {

    //11ms, 45%
    /*public String decodeMessage(String key, String message) {
        HashMap<Character, Character> characterCharacterHashMap = new HashMap<>();
        List<Character> characters = new LinkedList<>();
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c!=' ' && !characters.contains(c)) {
                characters.add(c);
            }
        }
        Iterator<Character> iterator = characters.iterator();
        int counter = 0;
        while (iterator.hasNext()) {
            characterCharacterHashMap.putIfAbsent(iterator.next(),(char) ('a'+counter));
            counter++;
        }
        characterCharacterHashMap.put(' ', ' ');
        char[] decodedChars = new char[message.length()];
        for (int i = 0; i < message.length(); i++) {
            decodedChars[i] = characterCharacterHashMap.get(message.charAt(i));
        }
        return new String(decodedChars);
    }*/

    //TODO seems faster but needs fixing
    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> map = new HashMap<>();
        int counter = 0;
        map.put(' ', ' ');
        int pos = 0;
        int i = 0;
        while (pos < key.length()) {
            char curChar = key.charAt(pos);
            while (map.containsKey(curChar)) {
                pos++;
                curChar = key.charAt(pos);
            }
            map.put(curChar,(char) ('a'+i));
            pos++;
            i++;
        }
        char[] decodedChars = new char[message.length()];
        for (i = 0; i < message.length(); i++) {
            decodedChars[i] = map.get(message.charAt(i));
        }
        return new String(decodedChars);
    }

    @Test
    public void test() {
        assertEquals("this is a secret", decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
        assertEquals("the five boxing wizards jump quickly", decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"));
    }

    /*Input: key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv"
Output: "this is a secret"
Explanation: The diagram above shows the substitution table.
It is obtained by taking the first appearance of each letter in "the quick brown fox jumps over the lazy dog"

Input: key = "eljuxhpwnyrdgtqkviszcfmabo", message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb"
Output: "the five boxing wizards jump quickly".*/

}
