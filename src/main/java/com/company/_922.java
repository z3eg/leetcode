package com.company;

public class _922 {

    /*2
    ms
    Beats
    99.23%
    of users with Java*/
    public int[] sortArrayByParityII(int[] nums) {
        int[] odds = new int[nums.length/2];
        int[] evens = new int[nums.length/2];
        int oddc = 0;
        int evenc = 0;
        for (int n : nums) {
            if (n%2==0) {
                evens[evenc]=n;
                evenc++;
            }
            else {
                odds[oddc]=n;
                oddc++;
            }
        }
        for (int i = 0; i < nums.length / 2; i++) {
            nums[2*i] = evens[i];
            nums[2*i+1] = odds[i];
        }
        return nums;
    }
}
