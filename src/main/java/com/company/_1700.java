package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        return 0;
    }

    @Test
    public void test() {
        assertEquals(0, countStudents(new int[]{1,1,0,0}, new int[]{0,1,0,1}));
        assertEquals(3, countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}));
    }
}
