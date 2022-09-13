package com.company;

//https://leetcode.com/problems/maximum-69-number/
public class _1323_Maximum69Number {

    public int maximum69Number (int num) {
        String s = "";
        s+=num;
        s = s.replaceFirst("6","9");
        return Integer.parseInt(s);
    }
}
