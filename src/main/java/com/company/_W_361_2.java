package com.company;

import org.junit.jupiter.api.Test;
import scala.util.parsing.combinator.testing.Str;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class _W_361_2 {

        class Node {
            public int depth;
            public String str;

            public Node(int depth, String str) {
                this.depth = depth;
                this.str = str;
            }
        }
        public int minimumOperations(String num) {
            if (Double.parseDouble(num)%25==0)
                return 0;
            Queue<Node> q = new LinkedList<>();
            return minOps(num, 0, q);
        }

        int minOps(String num, int cur, Queue<Node> q) {
            if ("".equals(num))
                return cur;
            if (Double.parseDouble(num) % 25 == 0)
                return cur;
            if (num.length()<3)
                if (num.contains("0"))
                    return cur + num.length()-1;
                else
                    return cur + num.length();
            if (num.length()>=3) {
                if (num.lastIndexOf("0")==-1 && num.lastIndexOf("5")==-1) {
                    q.offer(new Node(cur + num.length(), ""));
                }
                else if (num.lastIndexOf("0")==num.indexOf("0") && !num.contains("2") && !num.contains("7")) {
                    q.offer(new Node(cur + num.length(), ""));
                }
                else if (num.lastIndexOf("5") < num.indexOf("2") && num.lastIndexOf("5") < num.indexOf("7")) {
                    q.offer(new Node(cur + num.length(), ""));
                }
                else {
                    char[] numArr = num.toCharArray();
                    for (int i = num.length() - 1; i >= 0; i--) {
                        char[] newArr = new char[numArr.length - 1];
                        for (int j = 0; j < i; j++) {
                            newArr[j] = numArr[j];
                        }
                        for (int j = i; j < newArr.length; j++) {
                            newArr[j] = numArr[j + 1];
                        }
                        q.offer(new Node(cur + 1, new String(newArr)));
                    }
                }
            }

            Node poll = q.poll();
            if (poll == null) {
                return cur;
            }
            return minOps(poll.str, poll.depth, q);
        }


    @Test
    public void test() {
        assertEquals(9, minimumOperations("6525479784667"));
        assertEquals(3, minimumOperations("333"));
        assertEquals(59, minimumOperations("99999999999999999999999999999999999999999999999999999999999"));
        assertEquals(2, minimumOperations("2245047"));
        assertEquals(0, minimumOperations("250"));
        assertEquals(0, minimumOperations("25"));
        assertEquals(0, minimumOperations("00"));
        assertEquals(2, minimumOperations("11"));
        assertEquals(1, minimumOperations("1"));
        assertEquals(0, minimumOperations("0"));
        assertEquals(3, minimumOperations("2908305"));
        assertEquals(1, minimumOperations("10"));
        assertEquals(1, minimumOperations("01"));
        assertEquals(1, minimumOperations("0000001"));
        assertEquals(1, minimumOperations("00000010"));
    }
}
