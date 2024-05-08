package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class _506 {

    /*Runtime: 106 ms, faster than 9.80% of Java online submissions for Relative Ranks.*/
    public String[] findRelativeRanks(int[] score) {
        String[] res = new String[score.length];
        String[] prizePlaces = new String[]{"Gold Medal","Silver Medal","Bronze Medal"};
        int[] sortedScore = Arrays.copyOf(score, score.length);
        sortedScore = Arrays.stream(sortedScore).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        for (int i = 0; i < score.length; i++) {
            int s = score[i];
            for (int j = 0; j < sortedScore.length; j++) {
                if (s == sortedScore[j]) {
                    res[i] = (j<3)?prizePlaces[j]:String.valueOf(j+1);
                }
            }
        }
        return res;
    }
}
