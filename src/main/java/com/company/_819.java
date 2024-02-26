package com.company;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class _819 {

    /*Wrong Answer
47 / 48 testcases passed*/
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("\\.","").replaceAll("!","").replaceAll("'","")
                .replaceAll("\\?","").replaceAll(",","").replaceAll(";","").toLowerCase();
        String[] split = paragraph.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        int mostFreq = 0;
        String mostComWord = "";
        Set<String> bannedSet = Set.of(banned);
        for (String word : split) {
            Integer freq = map.get(word);
            if (freq == null)
                freq = 0;
            freq++;
            map.put(word, freq);
            if (freq > mostFreq && !bannedSet.contains(word)) {
                mostFreq = freq;
                mostComWord = word;
            }
        }
        return mostComWord;
    }

    @Test
    public void test() {
        assertEquals("ball", mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
        assertEquals("a", mostCommonWord("a.", new String[]{}));
    }
}
