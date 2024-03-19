package com.company;

import org.junit.Test;
import scala.Char;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _621 {

    /*4
    ms
    Beats
    67.87%
    of users with Java*/
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        for (char c : tasks) {
            freq[c-'A']++;
            maxFreq = Math.max(maxFreq, freq[c-'A']);
        }
        int tasksWithMaxFreq = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == maxFreq)
                tasksWithMaxFreq++;
        }
        return Math.max(maxFreq*(n+1)-((n+1)-tasksWithMaxFreq), tasks.length);
    }

    @Test
    public void test() {
        assertEquals(9, leastInterval(new char[]{'A','A','A'}, 3));
        assertEquals(6, leastInterval(new char[]{'A','A','A','B','B','B'}, 0));
        assertEquals(6, leastInterval(new char[]{'A','A','A','B','B','B'}, 1));
        assertEquals(8, leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
        assertEquals(6, leastInterval(new char[]{'A','C','A','B','D','B'}, 1));
        assertEquals(10, leastInterval(new char[]{'A','A','A', 'B','B','B'}, 3));
    }
}
