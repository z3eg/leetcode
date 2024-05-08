package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class _412 {

    /*1
    ms
            Beats
99.65%
    of users with Java*/
    public List<String> fizzBuzz(int n) {
        List<String> res = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (i%3==0) {
                if (i%5==0)
                    res.add("FizzBuzz");
                else
                    res.add("Fizz");
            }
            else {
                if (i%5==0)
                    res.add("Buzz");
                else
                    res.add(String.valueOf(i));
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(Arrays.asList("1","2","Fizz"), fizzBuzz(3));
        assertEquals(Arrays.asList("1","2","Fizz","4","Buzz"), fizzBuzz(5));
        assertEquals(Arrays.asList("1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"),
                fizzBuzz(15));
    }
}
