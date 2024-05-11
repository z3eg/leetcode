package com.company;

public class _917 {
    /*
Runtime Error 5 / 115 testcases passed */
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = s.length()-1;
        while (l < r) {
            while (!isLetter(chars[l]))
                l++;
            while (!isLetter(chars[r]))
                r--;
            if (l < r) {
                char tmp = chars[l];
                chars[l] = chars[r];
                chars[r] = tmp;
            }
            l++;
            r--;
        }
        return new String(chars);
    }

    boolean isLetter(char c) {
        return (c<91 && c>64) || (c<123 && c>96);
    }
}
