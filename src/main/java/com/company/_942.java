package com.company;

import org.junit.jupiter.api.Test;

/*942. DI String Match
        https://leetcode.com/problems/di-string-match/*/
public class _942 {
    public int[] diStringMatch(String s) {
        int[] res = new int[s.length()+1];
        res[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='I')
                res[i+1] = res[i]+1;
            else
                res[i+1] = res[i]-1;
        }
        return res;
    }

}
