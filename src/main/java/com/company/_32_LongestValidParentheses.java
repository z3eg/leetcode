package com.company;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

//TODO not finished
//https://leetcode.com/problems/longest-valid-parentheses/
public class _32_LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s.length()==0) {
            return 0;
        }
        int longest = 0;
        int cur = 0;
        int globalCur = 0;
        int stackSize = 0;
        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(' -> {
                    stack.add(chars[i]);
                }
                case ')' -> {
                    if (!stack.isEmpty()) {
                        Character peeked = stack.peek();
                        if (peeked=='(') {
                            stack.pop();
                            cur+=2;
                            if (stack.size()==stackSize) {
                                globalCur += cur;
                                cur = 0;
                            }
                        }
                    }
                }
            }
        }
//        return Math.max(Math.max(longest, globalCur),cur);
        return Math.max(longest, globalCur);
    }



    /*public int longestValidParentheses(String s) {
        if (s.length()==0) {
            return 0;
        }
        int longest = 0;
        int cur = 0;
        int globalCur = 0;
        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            switch (aChar) {
                case '(' -> {
                    stack.push(aChar);
//                    cur=0;
                }
                case ')' -> {
                    if (!stack.isEmpty()) {
                        Character peeked = stack.peek();
                        if (peeked == '(') {
                            stack.poll();
                            cur += 2;
                            if (stack.isEmpty()) {
                                globalCur+=cur;
                                cur=0;
                            }
                        } else {
                            stack.push(')');
                        }
                    }
                    else {
                        longest = Math.max(longest, globalCur);
                        globalCur = 0;
                        cur = 0;
                    }
                }
            }
        }
//        return Math.max(Math.max(longest, globalCur),cur);
        return Math.max(longest, globalCur);
    }*/

    /*Example 1:

    Input: s = "(()"
    Output: 2
    Explanation: The longest valid parentheses substring is "()".
    Example 2:

    Input: s = ")()())"
    Output: 4
    Explanation: The longest valid parentheses substring is "()()".
    Example 3:

    Input: s = ""
    Output: 0*/

    @Test
    public void test() {
        assertEquals(2, longestValidParentheses("(()(((()"));
        assertEquals(4, longestValidParentheses("(()()"));
        assertEquals(2, longestValidParentheses("()(()"));
        assertEquals(2, longestValidParentheses("(()"));
        assertEquals(4, longestValidParentheses(")()())"));
        assertEquals(0, longestValidParentheses(""));
    }

}
