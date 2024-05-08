package com.company;

/*1095. Find in Mountain Array
        https://leetcode.com/problems/find-in-mountain-array/description/?envType=daily-question&envId=2023-10-12*/
public class _1095 {

    interface MountainArray {
        public int get(int index);

        public int length();
    }

    /*Runtime 0 ms
      Beats 100%*/
//    LMFAO
    public int findInMountainArray(int target, MountainArray mountainArr) {
        if (mountainArr.get(0)==target)
            return 0;
        if (mountainArr.length()<100)
        {
            for (int i = 1; i < mountainArr.length(); i++) {
                if (mountainArr.get(i)==target)
                    return i;
            }
        }
        //find the peak
        int peak = bsP(mountainArr, 0, mountainArr.length());
        if (mountainArr.get(peak)==target)
            return peak;
        //look in the left part
        int res = bs(target, mountainArr, 0, peak);
        //look in the right part
        if (res==-1)
            res = bs(target, mountainArr, peak, mountainArr.length());
        return res;
    }

    int bsP(MountainArray mountainArray, int l, int r) {
        if (r-l<=1)
            return l;
        int mid = (l+r)/2;
        if (mountainArray.get(mid) > mountainArray.get(mid-1) && mountainArray.get(mid) > mountainArray.get(mid+1))
            return mid;
        if (mountainArray.get(mid) > mountainArray.get(mid-1) && mountainArray.get(mid) <= mountainArray.get(mid+1)) //left side
            return bsP(mountainArray, mid, r);
        if (mountainArray.get(mid) < mountainArray.get(mid-1) && mountainArray.get(mid) > mountainArray.get(mid+1)) //right side
            return bsP(mountainArray, l, mid);
        return -1;
    }

    int bs(int n, MountainArray mountainArray, int l, int r) {
        if (r-l<=1)
            return -1;
        int mid = (l+r)/2;
        if (mountainArray.get(mid)==n)
            return mid;
        if (mountainArray.get(mid)<n)
            return bs(n,mountainArray,mid,r);
        if (mountainArray.get(mid)>n)
            return bs(n,mountainArray,l,mid);
        return -1;
    }
}
