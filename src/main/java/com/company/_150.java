package com.company;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class _150 {
    /*9
    ms
            Beats
17.97%
    of users with Java*/
    /*public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a = 0;
        int b = 0;
        for (String t : tokens) {
            if (!stack.isEmpty())
                b = stack.pop();
            if (!stack.isEmpty())
                a = stack.pop();
            switch (t) {
                case "+" -> stack.push(a+b);
                case "-" -> stack.push(a-b);
                case "*" -> stack.push(a*b);
                case "/" -> stack.push(a/b);
                default -> {
                    stack.push(a);
                    stack.push(b);
                    stack.push(Integer.valueOf(t));
                }
            }
        }
        return stack.pop();
    }*/

    /*5
    ms
            Beats
97.05%
    of users with Java*/
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String t : tokens) {
            switch (t) {
                case "+" -> {
                    int b = stack.pop();
                    stack.push(stack.pop() + b);
                }
                case "-" -> {
                    int b = stack.pop();
                    stack.push(stack.pop()-b);
                }
                case "*" -> {
                    int b = stack.pop();
                    stack.push(stack.pop()*b);
                }
                case "/" -> {
                    int b = stack.pop();
                    stack.push(stack.pop()/b);
                }
                default -> stack.push(Integer.valueOf(t));
            }
        }
        return stack.pop();
    }

    @Test
    public void test() {
        assertEquals(9, evalRPN(new String[]{"2","1","+","3","*"}));
        assertEquals(6, evalRPN(new String[]{"4","13","5","/","+"}));
        assertEquals(22, evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
