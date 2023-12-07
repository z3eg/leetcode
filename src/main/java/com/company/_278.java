package com.company;

public class _278 {

    public int firstBadVersion(int n) {
        return bs(0,n);
    }

    int bs(int l, int r) {
        if (l==0 && isBadVersion(l))
            return 0;
        int mid = (r+l)/2;
        if (mid==1 && isBadVersion(mid))
            return 1;
        if (isBadVersion(mid) && !isBadVersion(mid-1))
            return mid;
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
