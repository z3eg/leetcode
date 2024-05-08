package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _748 {

    /*4 ms
    Beats
    81.62%
    of users with Java*/
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[]  lPFreq = new int[26];
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if (c > 64 && c < 91) {
                lPFreq[c-'A']++;
            }
            if (c > 96 && c < 123) {
                lPFreq[c-'a']++;
            }
        }
        String shortest = "";
        for (String w : words) {
            int[] wFreq = new int[26];
            for (int i = 0; i < w.length(); i++) {
                wFreq[w.charAt(i) - 'a']++;
            }
            boolean isGood = true;
            for (int i = 0; i < 26; i++) {
                if (wFreq[i] < lPFreq[i]) {
                    isGood = false;
                    break;
                }
            }
            if (isGood && (shortest.equals("") || shortest.length() > w.length()))
                shortest = w;
        }
        return shortest;
    }

    @Test
    public void test() {
        assertEquals("steps", shortestCompletingWord("1s3 PSt", new String[]{"step","steps","stripe","stepple"}));
        assertEquals("pest", shortestCompletingWord("1s3 456", new String[]{"looks","pest","stew","show"}));
    }
}
