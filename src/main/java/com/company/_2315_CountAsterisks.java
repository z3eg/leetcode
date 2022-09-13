package com.company;

//https://leetcode.com/problems/count-asterisks/
public class _2315_CountAsterisks {

    public int countAsterisks(String s) {
        int counter = 0;
        boolean open = true;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            switch (c) {
                case '|' -> open=!open;
                case '*' -> {
                    if (open)
                        counter++;
                }
            }
        }
        return counter;
    }
}
