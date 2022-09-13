package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
public class _1281_SubtractTheProductAndSumOfDigitsOfAnInteger {

    public int subtractProductAndSum(int n) {
        int sum = 0;
        int prod = 1;
        while (n>=1) {
            sum+=n%10;
            prod*=n%10;
            n/=10;
        }
        return prod-sum;
    }

    @Test
    public void test() {
        assertEquals(15, subtractProductAndSum(234));
        assertEquals(21, subtractProductAndSum(4421));
        assertEquals(-2, subtractProductAndSum(114));
    }

    /*Example 1:

Input: n = 234
Output: 15
Explanation:
Product of digits = 2 * 3 * 4 = 24
Sum of digits = 2 + 3 + 4 = 9
Result = 24 - 9 = 15
Example 2:

Input: n = 4421
Output: 21
Explanation:
Product of digits = 4 * 4 * 2 * 1 = 32
Sum of digits = 4 + 4 + 2 + 1 = 11
Result = 32 - 11 = 21


Constraints:

1 <= n <= 10^5*/
}
