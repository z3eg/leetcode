package com.company;

//https://leetcode.com/problems/reverse-words-in-a-string-iii/
public class _557_ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            char[] chars = w.toCharArray();
            int worLen = chars.length;
            char[] newChars = new char[worLen];
            for (int i = 0; i < worLen; i++) {
                newChars[i] = chars[worLen-1-i];
            }
            sb.append(newChars);
            sb.append(" ");
        }
        String res = sb.toString();
        return res.substring(0,res.length()-1);
    }
}
