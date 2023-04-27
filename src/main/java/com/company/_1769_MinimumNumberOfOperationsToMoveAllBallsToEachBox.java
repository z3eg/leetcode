package com.company;

//https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
public class _1769_MinimumNumberOfOperationsToMoveAllBallsToEachBox {

    public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < boxes.length(); j++) {
                if (boxes.charAt(j)=='1') {
                    res[i]+=Math.abs(j-i);
                }
            }
        }
        return res;
    }


}
