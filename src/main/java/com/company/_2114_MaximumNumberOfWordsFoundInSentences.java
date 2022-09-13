package com.company;

//https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
public class _2114_MaximumNumberOfWordsFoundInSentences {

    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String s : sentences) {
            max = Math.max(max,s.split(" ").length);
        }
        return max;
    }


}
