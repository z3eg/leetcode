package com.company;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//https://leetcode.com/problems/valid-parentheses/
public class _20_ValidParentheses {
    public boolean isValid(String s) {
        if (s.length()%2==1) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char charac : chars) {
            if (charac=='(' || charac=='[' || charac=='{') {
                stack.push(charac);
            }
            else {
                Character openingBracket = stack.poll();
                if (openingBracket==null || (openingBracket!=charac-1 && openingBracket!=charac-2)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test() {
        assertFalse(isValid("[["));
        assertFalse(isValid("["));
        assertFalse(isValid("([)]"));
        assertTrue(isValid("()"));
        assertTrue(isValid("()[]{}"));
        assertFalse(isValid("(]"));
    }
}
