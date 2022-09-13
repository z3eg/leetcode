package com.company;

//https://leetcode.com/problems/count-the-number-of-consistent-strings/
public class _1684_CountTheNumberOfConsistentStrings {
    //optimize TODO
    /*public int countConsistentStrings(String allowed, String[] words) {
        int counter = 0;
        outer: for (String w : words) {
            char[] chars = w.toCharArray();
            for (char c : chars) {
                if (allowed.indexOf(c)==-1)
                    continue outer;
            }
            counter++;
        }
        return counter;
    }*/

    public int countConsistentStrings(String allowed, String[] words) {
        int counter = 0;
        for (String w : words) {
            boolean isConsistent = true;
            char[] chars = w.toCharArray();
            for (char c : chars) {
                if (allowed.indexOf(c)==-1) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent)
                counter++;
        }
        return counter;
    }
}
