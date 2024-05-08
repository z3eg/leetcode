package com.company;

public class _1582 {

    /*2
    ms
            Beats
88.89%
    of users with Java*/
    public int numSpecial(int[][] mat) {
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    boolean isAlone = true;
                    for (int k = 0; k < mat.length; k++) {
                        if (mat[k][j]==1 && k!=i) {
                            isAlone = false;
                            break;
                        }
                    }
                    if (isAlone) {
                        for (int k = 0; k < mat[i].length; k++) {
                            if (mat[i][k]==1 && k!=j) {
                                isAlone = false;
                                break;
                            }
                        }
                    }
                    if (isAlone)
                        res++;
                }
            }
        }
        return res;
    }
}
