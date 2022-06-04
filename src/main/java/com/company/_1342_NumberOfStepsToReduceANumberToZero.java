package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
public class _1342_NumberOfStepsToReduceANumberToZero {
    public int numberOfSteps(int num) {
        int i = 0;
        while (num!=0) {
            if (num%2==1) {
                num-=1;
            }
            else {
                num/=2;
            }
            i++;
        }
        return i;
    }

    /*Example 1:

Input: num = 14
Output: 6
Explanation:
Step 1) 14 is even; divide by 2 and obtain 7.
Step 2) 7 is odd; subtract 1 and obtain 6.
Step 3) 6 is even; divide by 2 and obtain 3.
Step 4) 3 is odd; subtract 1 and obtain 2.
Step 5) 2 is even; divide by 2 and obtain 1.
Step 6) 1 is odd; subtract 1 and obtain 0.
Example 2:

Input: num = 8
Output: 4
Explanation:
Step 1) 8 is even; divide by 2 and obtain 4.
Step 2) 4 is even; divide by 2 and obtain 2.
Step 3) 2 is even; divide by 2 and obtain 1.
Step 4) 1 is odd; subtract 1 and obtain 0.
Example 3:

Input: num = 123
Output: 12*/

    @Test
    public void test() {
        assertEquals(6,numberOfSteps(14));
        assertEquals(4,numberOfSteps(8));
        assertEquals(12,numberOfSteps(123));
    }
}
