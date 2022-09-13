package com.company;

//https://leetcode.com/problems/determine-color-of-a-chessboard-square/
public class _1812_DetermineColorOfAChessboardSquare {

    public boolean squareIsWhite(String coordinates) {
        char c = coordinates.charAt(1);
        int i = coordinates.charAt(0)-'0';
        int j = c - 'a' +1;
        return (i+j)%2==1;
    }
}
