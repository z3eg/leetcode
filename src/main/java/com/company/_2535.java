package com.company;

/*https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/
2535. Difference Between Element Sum and Digit Sum of an Array*/
public class _2535 {
    public int differenceOfSum(int[] nums) {
        int numSum = 0;
        int digSum = 0;
        int sum;
        for (int n : nums) {
            numSum+=n;
            sum=0;
            while (n>=1) {
                sum+=n%10;
                n/=10;
            }
            digSum+=sum;
        }
        return Math.abs(numSum-digSum);
    }

    /*int getDigSum(int num) {
        int sum = 0;
        while (num>=1) {
            sum+=num%10;
            num/=10;
        }
        return sum;
    }*/
}
