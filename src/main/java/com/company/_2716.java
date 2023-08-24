package com.company;

import java.util.HashSet;
import java.util.Set;

/*2716. Minimize String Length
        https://leetcode.com/problems/minimize-string-length/*/
public class _2716 {
    /*7ms
    Beats 77.67%of users with Java*/
    public int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray())
            set.add(c);
        return set.size();
    }
}
