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
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber >=1) {
            sb.append((char) (64 + (columnNumber % 26)));
            columnNumber/=26;
        }
        return sb.reverse().toString();
    }

    @Test
    public void test() {
        assertEquals("ZY",convertToTitle(701));
        assertEquals("A",convertToTitle(1));
        assertEquals("AB",convertToTitle(28));
    }

    /*Example 1:

    Input: columnNumber = 1
    Output: "A"
    Example 2:

    Input: columnNumber = 28
    Output: "AB"*/
}
