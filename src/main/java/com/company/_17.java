package com.company;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*17. Letter Combinations of a Phone Number
https://leetcode.com/problems/letter-combinations-of-a-phone-number/*/
public class _17 {

    /*5ms
Beats 50.30%of users with Java*/
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        addToList(digits, 0,"", res, digits.length());
        return res;
    }

    public void addToList(String digits, int pos, String curS, List<String> res, int totalLen) {
        if (digits.length()>pos) {
            char[] digLets = getLetsFromDig(digits.charAt(pos));
            for (char c : digLets) {
                String s = curS + c;
                if (s.length()==totalLen)
                    res.add(s);
                else {
                    addToList(digits, pos+1, s, res, totalLen);
                }
            }
        }
    }

    private char[] getLetsFromDig(char c) {
        switch (c) {
            case '2' -> {
                return new char[]{'a','b','c'};
            }
            case '3' -> {
                return new char[]{'d','e','f'};
            }
            case '4' -> {
                return new char[]{'g','h','i'};
            }
            case '5' -> {
                return new char[]{'j','k','l'};
            }
            case '6' -> {
                return new char[]{'m','n','o'};
            }
            case '7' -> {
                return new char[]{'p','q','r','s'};
            }case '8' -> {
                return new char[]{'t','u','v'};
            }
            case '9' -> {
                return new char[]{'w','x','y','z'};
            }
            default -> {
                return null;
            }
        }
    }

}
