package com.company;

//https://leetcode.com/problems/robot-return-to-origin/
public class _657 {

    /*5ms
    Beats 96.23%of users with Java*/
    public boolean judgeCircle(String moves) {
        int vd = 0;
        int hd = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'U' -> vd++;
                case 'D' -> vd--;
                case 'R' -> hd++;
                case 'L' -> hd--;
            }
        }
        return vd==0 && hd==0;
    }

}
