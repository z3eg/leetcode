package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class _648 {
    /*45
    ms
    Beats
    37.50%
    of users with Java*/
    public String replaceWords(List<String> dictionary, String sentence) {
        dictionary.sort(Comparator.comparingInt(String::length));
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (String dword : dictionary) {
                if (words[i].startsWith(dword)) {
                    words[i] = dword;
                    break;
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        sb.append(words[0]);
        for (int i = 1; i < words.length - 1; i++) {
            sb.append(" ");
            sb.append(words[i]);
        }
        if (words.length > 1) {
            sb.append(" ");
            sb.append(words[words.length-1]);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        assertEquals("the cat was rat by the bat", replaceWords(Arrays.asList("cat","bat","rat"), "the cattle was rattled by the battery"));
        assertEquals("a a b c", replaceWords(Arrays.asList("a","b","c"), "aadsfasf absbs bbab cadsfafs"));
    }

}
