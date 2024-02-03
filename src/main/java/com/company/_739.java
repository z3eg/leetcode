package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertArrayEquals;

public class _739 {
    //naive n^2
    /*Time Limit Exceeded
47 / 48 testcases passed*/
    /*public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i+1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }*/

    /*Wrong Answer
20 / 48 testcases passed*/
    /*public int[] dailyTemperatures(int[] temperatures) {
        List<Integer>[] listArr = new LinkedList[72];
        for (int i = 0; i < listArr.length; i++) {
            listArr[i] = new LinkedList<>();
        }
        for (int i = 0; i < temperatures.length; i++) {
            listArr[temperatures[i]-30].add(i);
        }
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int curTemp = temperatures[i];
            b: for (int k = 0; k < 10000; k++) {
                for (int j = curTemp-29; j < listArr.length; j++) {
                    if (listArr[j].size() > k) {
                        if (listArr[j].get(k)>i) {
                            res[i] = listArr[j].get(k) - i;
                            break b;
                        }
                    }
                }
            }
        }
        return res;
    }*/

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = temperatures.length-1; i > 0; i--) {
            stack.push(temperatures[i]);
        }
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int curTemp = temperatures[i];
            int counter = 1;
            while (!stack.isEmpty()) {
                int nextTemp = stack.pop();
                stack2.push(nextTemp);
                if (nextTemp <= curTemp) {
                    counter++;
                }
                else {
                    res[i] = counter;
                    while (!stack2.isEmpty())
                        stack.push(stack2.pop());
                    break;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{1,1,4,2,1,1,0,0}, dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));
        assertArrayEquals(new int[]{1,1,1,0}, dailyTemperatures(new int[]{30,40,50,60}));
        assertArrayEquals(new int[]{1,1,0}, dailyTemperatures(new int[]{30,60,90}));
    }
}
