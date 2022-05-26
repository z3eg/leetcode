package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/excel-sheet-column-number/
public class _171_ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int num = 0;
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            int curCharNum = chars[length-i-1]-64;
            num+=Math.pow(26,i)*curCharNum;
        }
        return num;
    }

    @Test
    public void test() {
        assertEquals(1,titleToNumber("A"));
        assertEquals(28,titleToNumber("AB"));
        assertEquals(701,titleToNumber("ZY"));
    }
}

/*Example 1:

        Input: columnTitle = "A"
        Output: 1
        Example 2:

        Input: columnTitle = "AB"
        Output: 28
        Example 3:

        Input: columnTitle = "ZY"
        Output: 701*/
