package com.company;

import org.junit.jupiter.api.Test;

/*942. DI String Match
        https://leetcode.com/problems/di-string-match/*/
public class _942 {
    public int[] diStringMatch(String s) {
        int low = 0;
        int high = s.length();
        int[] res = new int[s.length()+1];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='I') {
                res[i] = low;
                low++;
            }
            else {
                res[i] = high;
                high--;
            }
        }
        res[s.length()] = high;
        return res;
    }

}
