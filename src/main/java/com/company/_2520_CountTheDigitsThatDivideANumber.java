package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class _2520_CountTheDigitsThatDivideANumber {
    public int countDigits(int num) {
        int numCopy = num;
        List<Integer> digits = new LinkedList<>();
        while (num>=1) {
            digits.add(num%10);
            num/=10;
        }
        int counter = 0;
        for (Integer digit : digits) {
            if (numCopy%digit==0)
                counter++;
        }
        return counter;
    }

    @Test
    public void test() {
        countDigits(123);
    }
}
