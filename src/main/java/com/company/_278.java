package com.company;

public class _278 {

    public int firstBadVersion(int n) {
        return bs(1,n);
    }

    /*Wrong Answer
13 / 24 testcases passed*/
    /*int bs(int l, int r) {
        if (l==1 && isBadVersion(l))
            return 1;
        int mid = (r+l)/2;
        if (mid==1 && isBadVersion(mid))
            return 1;
        if (isBadVersion(mid) && !isBadVersion(mid-1))
            return mid;
        if (isBadVersion(mid+1) && !isBadVersion(mid))
            return mid+1;
        if (l-r < 2)
            return (isBadVersion(l)?l:isBadVersion(r)?r:r+1);
        if (isBadVersion(mid))
            return bs(l, mid);
        if (!isBadVersion(mid))
            return bs(mid, r);
        return 0;
    }*/

    /*Wrong Answer
13 / 24 testcases passed*/
    int bs(int l, int r) {
        if (l==1 && isBadVersion(l))
            return 1;
        int mid = l + (r-l)/2;
        if (mid==1 && isBadVersion(mid))
            return 1;
        if (isBadVersion(mid) && !isBadVersion(mid-1))
            return mid;
        if (isBadVersion(mid+1) && !isBadVersion(mid))
            return mid+1;
        if (l-r < 2)
            return (isBadVersion(l)?l:isBadVersion(r)?r:r+1);
        if (isBadVersion(mid))
            return bs(l, mid);
        if (!isBadVersion(mid))
            return bs(mid, r);
        return 0;
    }

    boolean isBadVersion(int version) {
        return true;
    }

}
