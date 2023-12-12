package com.company;

public class _374 {

    /*Runtime Error
14 / 25 testcases passed*/
    public int guessNumber(int n) {
        return bs(1,n);
    }

    int bs(int l, int r) {
        if (guess(l)==0)
            return l;
        if (guess(r)==0)
            return r;
        int mid = (l+r)/2;
        int res = guess(mid);
        if (res == 0)
            return mid;
        else if (res == -1)
            return bs(l,mid);
        else
            return bs(mid,r);
    }

    int guess(int n) {
        return 0;
    }

}
