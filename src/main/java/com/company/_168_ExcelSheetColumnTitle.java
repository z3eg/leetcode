package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/excel-sheet-column-title/
public class _168_ExcelSheetColumnTitle {
    /*Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

    For example:

    A -> 1
    B -> 2
    C -> 3
            ...
    Z -> 26
    AA -> 27
    AB -> 28
            ...*/
    /*public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber>=26) {
            char c = 'A';
            c+=columnNumber%26;
            columnNumber/=26;
            res.insert(0, c);
        }
        char fC = '@';
        fC+=columnNumber;
        if (fC>='A')
            res.insert(0, fC);
        return res.toString();
    }*/

    /*public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        char c = '@';
        int endingShift = columnNumber % 26;
        if (endingShift==0)
            c = 'Z';
        else {
            c+=endingShift;
        }
        res.insert(0, c);
        columnNumber-=endingShift==0?26:endingShift;
        while (columnNumber> 0) {
            c = '@';
            endingShift = columnNumber / 26;
            if (endingShift==0)
                c = 'Z';
            else {
                c+=endingShift;
            }
            res.insert(0, c);
            columnNumber-=endingShift*26;
        }
        return res.toString();
    }*/

    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber> 0) {
            columnNumber--;
            char c = 'A';
            int endingShift = columnNumber % 26;
            c+=endingShift;
            res.insert(0, c);
            columnNumber/=26;
        }
        return res.toString();
    }

    @Test
    public void test() {
        assertEquals("FXSHRXW",convertToTitle(2147483647));
        assertEquals("ZY",convertToTitle(701));
        assertEquals("AB",convertToTitle(28));
        assertEquals("A",convertToTitle(1));
        assertEquals("B",convertToTitle(2));
        assertEquals("AA",convertToTitle(27));
        assertEquals("ZZ",convertToTitle(702));
    }

    /*Example 1:

    Input: columnNumber = 1
    Output: "A"
    Example 2:

    Input: columnNumber = 28
    Output: "AB"*/
}
