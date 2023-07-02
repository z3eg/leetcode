package com.company;

public class _344_ReverseString {
    /*Runtime
    1 ms
    Beats
    85.68%*/
    public void reverseString(char[] s) {
        char tmp;
        for (int i = 0; i < s.length / 2; i++) {
            tmp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = tmp;
        }
    }
}
