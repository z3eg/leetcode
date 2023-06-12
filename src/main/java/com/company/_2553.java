package com.company;

import java.util.LinkedList;
import java.util.Stack;

/*2553. Separate the Digits in an Array
        https://leetcode.com/problems/separate-the-digits-in-an-array/*/
public class _2553 {

    /*Runtime
    64 ms
    Beats
    5.7%*/
    /*public int[] separateDigits(int[] nums) {
        LinkedList<Integer> digs = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int n : nums) {
            while (n>=1) {
                stack.push(n%10);
                n/=10;
            }
            while (!stack.isEmpty())
                digs.add(stack.pop());
        }
        int size = digs.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = digs.get(i);
        }
        return res;
    }*/

    public int[] separateDigits(int[] nums) {
        int splits[][] = new int[nums.length][];
        int totNum = 0;
        for (int i = 0; i < nums.length; i++) {
            splits[i] = split(nums[i]);
            totNum+=splits[i].length;
        }
        int idx = 0;
        int[] res = new int[totNum];
        for (int i = 0; i < splits.length; i++) {
            for (int j = splits[i].length-1; j >= 0; j--) {
                res[idx] = splits[i][j];
                idx++;
            }
        }
        return res;
    }

    public int[] split(int num) {
        int len;
        if (num==100000)
            len = 6;
        else if (num>9999)
            len = 5;
        else if (num>999)
            len = 4;
        else if (num>99)
            len = 3;
        else if (num>9)
            len = 2;
        else
            len = 1;
        int[] res = new int[len];
        int idx = 0;
        while (num>=1) {
            res[idx] = num%10;
            num/=10;
            idx++;
        }
        return res;
    }
}
