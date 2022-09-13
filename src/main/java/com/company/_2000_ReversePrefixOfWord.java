package com.company;

//https://leetcode.com/problems/reverse-prefix-of-word/
public class _2000_ReversePrefixOfWord {

    public String reversePrefix(String word, char ch) {
        char[] chars = word.toCharArray();
        int index = word.indexOf(ch);
        if (index == -1)
            return word;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = index; i >= 0; i--) {
            stringBuilder.append(chars[i]);
        }
        stringBuilder.append(word.substring(index+1));
        return stringBuilder.toString();
    }
}
