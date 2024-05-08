package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

//6926. Sort Vowels in a String
public class _BW_109_2 {
    public String sortVowels(String s) {
        char[] vowels = new char[s.length()];
        int[] positions = new int[s.length()];
        char[] chars = s.toCharArray();
        int curI = 0;
        for (int i = 0; i < chars.length; i++) {
            if (isVowel(chars[i])) {
                vowels[curI] = chars[i];
                positions[curI] = i;
                curI++;
            }
        }
        char[] onlyVowels = Arrays.copyOf(vowels, curI);
        Arrays.sort(onlyVowels);
        for (int i = 0; i < curI; i++) {
            chars[positions[i]] = onlyVowels[i];
        }
        return new String(chars);
    }

    boolean isVowel(char c) {
        return (c=='A' || c== 'E' || c=='I' || c == 'O' || c=='U' ||
                c=='a' || c== 'e' || c=='i' || c == 'o' || c=='u');
    }

    @Test
    public void test() {
        assertEquals("lEOtcede", sortVowels("lEetcOde"));
        assertEquals("lYmpH", sortVowels("lYmpH"));
    }
}
