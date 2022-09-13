package com.company;

import java.util.HashSet;

//https://leetcode.com/problems/unique-morse-code-words/
public class _804_UniqueMorseCodeWords {

    public int uniqueMorseRepresentations(String[] words) {
        String[] alphabet = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--",
                "-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> strings = new HashSet<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : chars) {
                int index = c - 'a';
                stringBuilder.append(alphabet[index]);
            }
            strings.add(stringBuilder.toString());
        }
        return strings.size();
    }
}
