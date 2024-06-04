package com.company;

public class _999 {

    /*0
    ms
    Beats
    100.00%
    of users with Java*/
    public int numRookCaptures(char[][] board) {
        int res = 0;
        boolean canGoLeft = true;
        boolean canGoRight = true;
        boolean canGoUp = true;
        boolean canGoDown = true;
        int r = -1;
        int c = -1;
        foo: for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    r = i;
                    c = j;
                    break foo;
                }
            }
        }
        int cr = r;
        while (canGoUp) {
            cr--;
            if (cr<0)
                canGoUp = false;
            else {
                if (board[cr][c]!='.') {
                    canGoUp = false;
                    res+=(board[cr][c]=='p')?1:0;
                }
            }
        }
        cr = r;
        while (canGoDown) {
            cr++;
            if (cr>= board.length)
                canGoDown = false;
            else {
                if (board[cr][c]!='.') {
                    canGoDown = false;
                    res+=(board[cr][c]=='p')?1:0;
                }
            }
        }
        int cc = c;
        while (canGoLeft) {
            cc--;
            if (cc < 0)
                canGoLeft = false;
            else {
                if (board[r][cc]!='.') {
                    canGoLeft = false;
                    res+=(board[r][cc]=='p')?1:0;
                }
            }
        }
        cc = c;
        while (canGoRight) {
            cc++;
            if (cc >= board.length)
                canGoRight = false;
            else {
                if (board[r][cc]!='.') {
                    canGoRight = false;
                    res+=(board[r][cc]=='p')?1:0;
                }
            }
        }
        return res;
    }
}
