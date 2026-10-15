package com.company;

import java.util.HashSet;
import java.util.List;

public class _2913 {

    /*108
    ms
    Beats
    8.75%*/
    public int sumCounts(List<Integer> nums) {
        int l = 0;
        int r = 0;
        int sum = 0;
        boolean goingLeft = false;
        while (r-l<nums.size()) {
            //calculating the window square bs
            HashSet<Integer> curWindow = new HashSet<>();
            for (int i = l; i <= r; i++) {
                curWindow.add(nums.get(i));
            }
            sum+= curWindow.size()*curWindow.size();
            //updating pointers
            if (!goingLeft) {
                if (r==nums.size()-1)
                {
                    goingLeft = true;
                    l--;
                }
                else {
                    l++;
                    r++;
                }
            }
            else {
                if (l==0) {
                    goingLeft = false;
                    r++;
                }
                else {
                    l--;
                    r--;
                }
            }
        }
        return sum;
    }

}
