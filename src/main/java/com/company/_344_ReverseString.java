package com.company;

public class _344_ReverseString {
    /*Runtime
    0
    ms
    Beats
    100.00%
    of users with Java*/
    public void reverseString(char[] s) {
        char tmp;
        for (int i = 0; i < s.length / 2; i++) {
            tmp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = tmp;
        }
    }
}
