package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/add-digits/
public class _258_AddDigits {

    public int addDigits(int num) {
        if (num<=9) {
            return num;
        }
        int sum = 0;
        while (num > 9) {
           sum = 0;
           while (num>=1) {
               sum+=num%10;
               num/=10;
           }
           num=sum;
        }
        return sum;
    }

    //works but not optimal
    /*public int addDigits(int num) {
        int sum = 0;
        List<Integer> numbers = getNumbers(num);
        sum = numbers.stream().mapToInt(n -> n).sum();
        if (numbers.size()>1) {
            return addDigits(sum);
        }
        else {
            return sum;
        }
    }

    private List<Integer> getNumbers(int num) {
        LinkedList<Integer> integers = new LinkedList<>();
        while (num >= 1) {
            integers.add(num%10);
            num/=10;
        }
        return integers;
    }*/

    @Test
    public void test() {
        assertEquals(2, addDigits(38));
        assertEquals(0, addDigits(0));
        assertEquals(1, addDigits(1));
    }
}
