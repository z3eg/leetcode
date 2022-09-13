package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/sorting-the-sentence/
public class _1859_SortingTheSentence {
    public String sortSentence(String s) {
        String[] split = s.split(" ");
        String[] reconstructed = new String[split.length];
        for (String item : split) {
            int index = item.charAt(item.length() - 1) - '0';
            reconstructed[index - 1] = item.substring(0, item.length() - 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String value : reconstructed) {
            stringBuilder.append(value);
            stringBuilder.append(" ");
        }
        String res = stringBuilder.toString();
        return res.substring(0,res.length()-1);
    }

    @Test
    public void test() {
        assertEquals("This is a sentence", sortSentence("is2 sentence4 This1 a3"));
        assertEquals("Me Myself and I", sortSentence("Myself2 Me1 I4 and3"));
    }

    /*Example 1:

Input: s = "is2 sentence4 This1 a3"
Output: "This is a sentence"
Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.
Example 2:

Input: s = "Myself2 Me1 I4 and3"
Output: "Me Myself and I"
Explanation: Sort the words in s to their original positions "Me1 Myself2 and3 I4", then remove the numbers.*/
}
