package com.company;

import java.util.Arrays;

public class _1816_TruncateSentence {

    public String truncateSentence(String s, int k) {
        String[] sArr = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            stringBuilder.append(sArr[i]);
            stringBuilder.append(" ");
        }
        String res = stringBuilder.toString();
        return res.substring(0,res.length()-1);
    }
}
