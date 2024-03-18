package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _824 {
    /*1
    ms
    Beats
    100.00%
    of users with Java*/
    public String toGoatLatin(String sentence) {
        String[] split = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            stringBuilder.append(toGoat(split[i], i+1));
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    private String toGoat(String s, int i) {
        StringBuilder stringBuilder = new StringBuilder(s);
        if (!(s.startsWith("a") || s.startsWith("e") || s.startsWith("i") || s.startsWith("o") || s.startsWith("u") ||
        s.startsWith("A") || s.startsWith("E") || s.startsWith("I") || s.startsWith("O") || s.startsWith("U"))) {
            stringBuilder.append(stringBuilder.charAt(0));
            stringBuilder.deleteCharAt(0);
        }
        stringBuilder.append("ma");
        for (int j = 0; j < i; j++) {
            stringBuilder.append("a");
        }
        return stringBuilder.toString();
    }

    @Test
    public void test() {
        assertEquals("iTmaa", toGoatLatin("Ti"));
        assertEquals("Itmaa", toGoatLatin("It"));
        assertEquals("Tmaa", toGoatLatin("T"));
        assertEquals("Imaa", toGoatLatin("I"));
        assertEquals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa", toGoatLatin("I speak Goat Latin"));
        assertEquals("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa", toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }
}
