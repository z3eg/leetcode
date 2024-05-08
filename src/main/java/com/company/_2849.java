package com.company;

public class _2849 {
    /*1ms
    Beats 95.30%of users with Java*/
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        return (t>=Math.max(Math.abs(fx-sx),Math.abs(fy-sy))) && !(sx==fx && sy==fy && t==1);
    }
}
