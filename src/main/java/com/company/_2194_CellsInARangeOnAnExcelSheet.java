package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet/
public class _2194_CellsInARangeOnAnExcelSheet {


    //TODO optimize
    public List<String> cellsInRange(String s) {
        LinkedList<String> res = new LinkedList<>();
        char start = s.charAt(0);
        char end = s.charAt(3);
        int iStart = s.charAt(1)-'0';
        int iEnd = (int) s.charAt(4)-'0';
        for (char c = start; c <= end; c++) {
            for (int i = iStart; i <= iEnd; i++) {
                res.add(String.valueOf(c)+i);
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(List.of("K1","K2","L1","L2"), cellsInRange("K1:L2"));
        assertEquals(List.of("A1","B1","C1","D1","E1","F1"), cellsInRange("A1:F1"));
    }

    /*Input: s = "K1:L2"
Output: ["K1","K2","L1","L2"]
Explanation:
The above diagram shows the cells which should be present in the list.
The red arrows denote the order in which the cells should be presented.*/
}
