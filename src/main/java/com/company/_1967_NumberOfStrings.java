package com.company;

//https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/
public class _1967_NumberOfStrings {
    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for (String s : patterns) {
            if (word.contains(s))
                res++;
        }
        return res;
    }
}
