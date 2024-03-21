package com.company;

import java.util.LinkedList;
import java.util.List;

public class _830 {

    /*Wrong Answer
137 / 202 testcases passed*/
    /*public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new LinkedList<>();
        int streak = 1;
        int streakStrart = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i)==s.charAt(i-1))
                streak++;
            else {
                if (streak > 2) {
                    List<Integer> list = new LinkedList<>();
                    list.add(streakStrart);
                    list.add(i-1);
                    res.add(list);
                }
                streak = 1;
                streakStrart = i;
            }
        }
        return res;
    }*/

    /*1
ms
Beats
100.00%
of users with Java*/
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new LinkedList<>();
        int streak = 1;
        int streakStrart = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i)==s.charAt(i-1))
                streak++;
            else {
                if (streak > 2) {
                    List<Integer> list = new LinkedList<>();
                    list.add(streakStrart);
                    list.add(i-1);
                    res.add(list);
                }
                streak = 1;
                streakStrart = i;
            }
        }
        if (streak > 2) {
            List<Integer> list = new LinkedList<>();
            list.add(streakStrart);
            list.add(s.length()-1);
            res.add(list);
        }
        return res;
    }
}
