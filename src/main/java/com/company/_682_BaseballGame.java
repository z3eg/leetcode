package com.company;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/baseball-game/
public class _682_BaseballGame {

    //5ms, can do better
    /*public int calPoints(String[] ops) {
        int res = 0;

        Deque<Integer> integers = new LinkedList<>();
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "C" : {
                    integers.poll();
                    break;
                }
                case "D" : {
                    Integer peek = integers.peek();
                    integers.push(peek*2);
                    break;
                }
                case "+" : {
                    Integer last = integers.poll();
                    Integer beforeLast = integers.peek();
                    integers.push(last);
                    integers.push(last+beforeLast);
                    break;
                }
                default: {
                    integers.push(Integer.parseInt(ops[i]));
                    break;
                }
            }
        }
        while (!integers.isEmpty()) {
            res+=integers.poll();
        }
        return res;
    }*/

    /*@Test
    public void test() {
        assertEquals(30, calPoints(new String[]{"5","2","C","D","+"}));
        assertEquals(27, calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
        assertEquals(1, calPoints(new String[]{"1"}));
    }*/

    /*Example 1:

    Input: ops = ["5","2","C","D","+"]
    Output: 30
    Explanation:
            "5" - Add 5 to the record, record is now [5].
            "2" - Add 2 to the record, record is now [5, 2].
            "C" - Invalidate and remove the previous score, record is now [5].
            "D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
            "+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
    The total sum is 5 + 10 + 15 = 30.
    Example 2:

    Input: ops = ["5","-2","4","C","D","9","+","+"]
    Output: 27
    Explanation:
            "5" - Add 5 to the record, record is now [5].
            "-2" - Add -2 to the record, record is now [5, -2].
            "4" - Add 4 to the record, record is now [5, -2, 4].
            "C" - Invalidate and remove the previous score, record is now [5, -2].
            "D" - Add 2 * -2 = -4 to the record, record is now [5, -2, -4].
            "9" - Add 9 to the record, record is now [5, -2, -4, 9].
            "+" - Add -4 + 9 = 5 to the record, record is now [5, -2, -4, 9, 5].
            "+" - Add 9 + 5 = 14 to the record, record is now [5, -2, -4, 9, 5, 14].
    The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.
    Example 3:

    Input: ops = ["1"]
    Output: 1*/

}
