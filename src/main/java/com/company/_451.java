package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _451 {
    /*Runtime Error
    8 / 33 testcases passed*/

//    WE HAVE NUMBERS THERE NO WAY WTF
    public String frequencySort(String s) {
        int[] freq = new int[52];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= 90)
                freq[s.charAt(i)-'A']++;
            else
                freq[26 + s.charAt(i)-'a']++;
        }
        int[] letters = new int[52];
        for (int i = 0; i < 52; i++) {
            letters[i]=i;
        }
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < 51; i++) {
                if (freq[i]<freq[i+1]) {
                    sorted = false;
                    int tmp = freq[i];
                    freq[i] = freq[i+1];
                    freq[i+1] = tmp;
                    tmp = letters[i];
                    letters[i] = letters[i+1];
                    letters[i+1] = tmp;
                }
            }
        }
        char[] chars = new char[s.length()];
        int counter = 0;
        for (int i = 0; i < 52; i++) {
            for (int j = counter; j < counter+freq[i]; j++) {
                chars[j] = 'A';
                chars[j]+=(letters[i]<=25)?letters[i]:(letters[i]+6);
            }
            counter+=freq[i];
        }
        return new String(chars);
    }

    @Test
    public void test() {
        assertEquals("bbAa", frequencySort("Aabb"));
        assertEquals("eert", frequencySort("tree"));
    }
}
