package com.company;

import org.junit.jupiter.api.Test;
import scala.util.parsing.combinator.testing.Str;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

//6921. Split Strings by Separator
//https://leetcode.com/contest/weekly-contest-355/problems/split-strings-by-separator/
public class W_355_1 {


    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new LinkedList<>();
        for (String word : words) {
            split(word, res, separator);
        }
        return res;
    }

    void split (String s, List<String> res, char separator) {
        int lastSep = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==separator) {
                String substring = s.substring(lastSep, i);
                if (substring.length()>0) {
                    res.add(substring);
                }
                lastSep = i+1;
            }
        }
        String substring =s.substring(lastSep);
        if (substring.length()>0)
            res.add(substring);
    }

    @Test
    public void test() {
        List<String> a = new LinkedList<>();
        a.add("one.two.three");
        a.add("four.five");
        a.add("six");
        splitWordsBySeparator(a, '.');
    }
}
