package com.company;

import java.util.HashSet;

//https://leetcode.com/problems/check-if-the-sentence-is-pangram/
public class _1832_CheckIfTheSentenceIsPangram {

    //TODO optimize?
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> characters = new HashSet<>();
        char[] chars = sentence.toCharArray();
        for (char c : chars) {
            characters.add(c);
        }
        return characters.size()==26;
    }
}
