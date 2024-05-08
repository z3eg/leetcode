package com.company;

public class _1897 {

    /*3
    ms
            Beats
58.49%
    of users with Java*/
    public boolean makeEqual(String[] words) {
        int[] freqs = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                freqs[c-'a']++;
            }
        }
        for (int f : freqs) {
            if (f%words.length!=0)
                return false;
        }
        return true;
    }
}
