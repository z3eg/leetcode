package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*2024. Maximize the Confusion of an Exam
        https://leetcode.com/problems/maximize-the-confusion-of-an-exam/*/
public class _2024 {

    //  TLE at 56th TC
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int ts = 0;
        int fs = 0;
        char[] chars = answerKey.toCharArray();
        if (chars[0] == 'T')
            ts++;
        if (chars[0] == 'F')
            fs++;
        int curStreak = 1;
        List<Integer> streaks = new LinkedList<>();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == 'T')
                ts++;
            if (chars[i] == 'F')
                fs++;
            if (chars[i] != chars[i-1]) {
                streaks.add(curStreak);
                curStreak=1;
            }
            else {
                curStreak++;
            }
        }
        if (k>=ts || k>=fs)
            return chars.length;
        int max = 0;
        streaks.add(curStreak);
        //left to right
        for (int i = 0; i < streaks.size(); i++) {
            int localK = k;
            curStreak = 0;
            for (int j = i; j < streaks.size(); j+=2) {
                curStreak+=streaks.get(j);
                if ((j+1) < streaks.size()) {
                    if (localK >= streaks.get(j+1)) {
                        localK-=streaks.get(j+1);
                        curStreak+=streaks.get(j+1);
                    }
                    else {
                        curStreak+=localK;
                        max = Math.max(max, curStreak);
                        break;
                    }
                }
                else {
                    max = Math.max(max, curStreak);
                    break;
                }
            }
            max = Math.max(max, curStreak);
        }
        //right to left
        for (int i = streaks.size()-1; i >= 0; i--) {
            int localK = k;
            curStreak = 0;
            for (int j = i; j >= 0; j-=2) {
                curStreak+=streaks.get(j);
                if ((j-1) >= 0) {
                    if (localK >= streaks.get(j-1)) {
                        localK-=streaks.get(j-1);
                        curStreak+=streaks.get(j-1);
                    }
                    else {
                        curStreak+=localK;
                        max = Math.max(max, curStreak);
                        break;
                    }
                }
                else {
                    max = Math.max(max, curStreak);
                    break;
                }
            }
            max = Math.max(max, curStreak);
        }
        return max;
    }

    @Test
    public void test() {


        assertEquals(3, maxConsecutiveAnswers("TFFT", 1));
        //54th test case:
        assertEquals(100, maxConsecutiveAnswers("TFFTFTTFTFFFFTFFTTFTFFTTFFTTFFFTFTTTFFTTFFTFFFFTFFTTTFFTFFTFFTTTFTFFFFTTTFFTTTTTTFFTTFTFTFTFFTFFTFFT", 48));
        assertEquals(8, maxConsecutiveAnswers("FFFTTFTTFT", 3));
        assertEquals(8, maxConsecutiveAnswers("TTTTTFTFFT", 2));
        assertEquals(10, maxConsecutiveAnswers("TFTFTFTTTTTFTTTTFTFTFTFT", 1));
        assertEquals(6, maxConsecutiveAnswers("TTFFTTFFTT", 2));
        assertEquals(6, maxConsecutiveAnswers("TFFTTFFT", 2));
        assertEquals(5, maxConsecutiveAnswers("TFTFT", 2));
        assertEquals(3, maxConsecutiveAnswers("FTF", 1));
        assertEquals(3, maxConsecutiveAnswers("TFT", 1));
        assertEquals(2, maxConsecutiveAnswers("TF", 1));
        assertEquals(1, maxConsecutiveAnswers("T", 1));
        assertEquals(5, maxConsecutiveAnswers("TFFTFFT", 1));
        assertEquals(5, maxConsecutiveAnswers("TFFTFFT", 1));
        assertEquals(4, maxConsecutiveAnswers("TTFF", 2));
        assertEquals(5, maxConsecutiveAnswers("TTFTTFTT", 1));
    }

    //potential optimization, hard to wrap my mind around it completely atm
        /*curStreak = streaks.get(0);
        int l = 0;
        int r = 0;
        while (r < streaks.size() && l < streaks.size()){
            while (k > streaks.get(r)) {
                k-=streaks.get(r);
                curStreak+=streaks.get(r);
                r++;
                curStreak+=streaks.get(r);
                r++;
                max = Math.max(max, curStreak);
            }
            while (k <= streaks.get(r)) {
                k+=streaks.get(l);
                curStreak-=streaks.get(l);
                l++;
                curStreak-=streaks.get(l);
                l--;
            }
        }*/
}
