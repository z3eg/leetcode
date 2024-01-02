package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class _500 {

    /*0
    ms
            Beats
100.00%
    of users with Java*/
    public String[] findWords(String[] words) {
        String[] rows = new String[]{
                "QWERTYUIOPqwertyuiop",
                "ASDFGHJKLasdfghjkl",
                "ZXCVBNMzxcvbnm"
        };
        List<String> list = new LinkedList<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            String row;
            if (rows[0].indexOf(chars[0])!=-1)
                row = rows[0];
            else if (rows[1].indexOf(chars[0])!=-1)
                row = rows[1];
            else
                row = rows[2];
            boolean goodWord = true;
            for (int i = 1; i < word.length(); i++) {
                if (row.indexOf(chars[i])==-1) {
                    goodWord = false;
                    break;
                }
            }
            if (goodWord)
                list.add(word);

        }
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
