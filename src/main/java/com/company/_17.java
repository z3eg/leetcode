package com.company;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*17. Letter Combinations of a Phone Number
https://leetcode.com/problems/letter-combinations-of-a-phone-number/*/
public class _17 {

    /*7ms
    Beats 11.76%of users with Java*/
    public List<String> letterCombinations(String digits) {
        Set<String> tmpRes = new HashSet<>();
        Set<String> curVals = new HashSet<>();
        curVals.add("");
        addToList(digits, curVals, tmpRes, digits.length());
        return new LinkedList<>(tmpRes);
    }

    public void addToList(String digits, Set<String> curVals, Set<String> res, int totalLen) {
        if (digits.length()>0) {
            Set<String> newVals = new HashSet<>();
            for (String val : curVals) {
                char[] digLets = getLetsFromDig(digits.charAt(0));
                for (char c : digLets) {
                    String s = val + c;
                    newVals.add(s);
                    if (s.length()==totalLen)
                        res.add(s);
                }
                addToList(digits.substring(1), newVals, res, totalLen);
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
