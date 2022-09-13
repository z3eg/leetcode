package com.company;

import java.util.HashSet;

//https://leetcode.com/problems/first-letter-to-appear-twice/
public class _2351_FirstLetterToAppearTwice {

    public char repeatedCharacter(String s) {
        char[] chars = s.toCharArray();
        HashSet<Character> characters = new HashSet<>();
        for (char c : chars) {
            if (characters.contains(c)) {
                return c;
            }
            characters.add(c);
        }
        return 'a';
    }

}
