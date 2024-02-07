package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _451 {

    /*3
    ms
            Beats
99.36%
    of users with Java*/
    public String frequencySort(String s) {
        int[] freq = new int[62];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= 57)
                freq[s.charAt(i)-'0']++;
            else if (s.charAt(i) <= 90)
                freq[10 + s.charAt(i)-'A']++;
            else
                freq[36 + s.charAt(i)-'a']++;
        }
        int[] letters = new int[62];
        for (int i = 0; i < 62; i++) {
            letters[i]=i;
        }
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < 61; i++) {
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
        for (int i = 0; i < 62; i++) {
            for (int j = counter; j < counter+freq[i]; j++) {
                chars[j] = '0';
                int offset = 0;
                if (letters[i]>35)
                    offset = 13;
                else if (letters[i]>9)
                    offset = 7;
                chars[j]+=(letters[i]+offset);
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
