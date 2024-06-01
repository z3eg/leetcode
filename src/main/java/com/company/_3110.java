package com.company;

public class _3110 {

    /*1
    ms
    Beats
    99.87%
    of users with Java*/
    public int scoreOfString(String s) {
        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            res+=Math.abs(s.charAt(i)-s.charAt(i+1));
        }
        return res;
    }
}
