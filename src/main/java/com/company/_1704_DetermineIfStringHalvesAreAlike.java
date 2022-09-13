package com.company;

//https://leetcode.com/problems/determine-if-string-halves-are-alike/
public class _1704_DetermineIfStringHalvesAreAlike {

    public boolean halvesAreAlike(String s) {
        int sLen = s.length();
        int halfLen = sLen / 2;
        int fc = 0;
        for (int i = 0; i < halfLen; i++) {
            switch (s.charAt(i)) {
                case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> fc++;
            }
        }
        int sc = 0;
        for (int i = halfLen; i < sLen; i++) {
            switch (s.charAt(i)) {
                case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> sc++;
            }
        }
        return fc==sc;
    }
}
