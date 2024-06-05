package com.company;

import java.util.LinkedList;
import java.util.List;

public class _1002 {

    /*3
    ms
    Beats
    88.56%
    of users with Java*/
    public List<String> commonChars(String[] words) {
        int[] freqs = freqMap(words[0]);
        for (int i = 1; i < words.length; i++) {
            int[] curFreqs = freqMap(words[i]);
            for (int j = 0; j < freqs.length; j++) {
                freqs[j] = Math.min(freqs[j], curFreqs[j]);
            }
        }
        List<String> res = new LinkedList<>();
        for (int i = 0; i < freqs.length; i++) {
            char c = 'a';
            c+=i;
            for (int j = 0; j < freqs[i]; j++) {
                res.add(String.valueOf(c));
            }
        }
        return res;
    }

    int[] freqMap(String word) {
        int[] res = new int[26];
        for (char c : word.toCharArray()) {
            res[c-'a']++;
        }
        return res;
    }
}
