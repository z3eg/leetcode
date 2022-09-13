package com.company;

import org.junit.Test;

import java.util.LinkedList;

//https://leetcode.com/problems/remove-outermost-parentheses/
public class _1021_RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        int parStack = 0;
        int openingPos = 0;
//        boolean shouldDelete = false;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(' -> {
                    if (parStack==0) {
                        openingPos = i;
                    }
                   /* else {
                        shouldDelete = true;
                    }*/
                    parStack++;
                }
                case ')' -> {
                    parStack--;
                    if (parStack==0) {
                        chars[i] = '_';
                        chars[openingPos] = '_';
//                        shouldDelete = false;
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            if (c!='_')
                stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    @Test
    public void test() {
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }
}
