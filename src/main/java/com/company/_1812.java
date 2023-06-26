package com.company;

import org.junit.Test;

/*1812. Determine Color of a Chessboard Square
        https://leetcode.com/problems/determine-color-of-a-chessboard-square/*/
public class _1812 {
    public boolean squareIsWhite(String coordinates) {
        return (coordinates.charAt(0) + coordinates.charAt(1))%2 != 0;
    }
}
