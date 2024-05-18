package com.company;

public class _944 {

    /*8
    ms
    Beats
    67.55%
    of users with Java*/
    public int minDeletionSize(String[] strs) {
        int counter = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length-1; j++) {
                if (strs[j].charAt(i)>strs[j+1].charAt(i)) {
                    counter++;
                    break;
                }

            }
        }
        return counter;
    }
}
