package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/*6450. Determine the Minimum Sum of a k-avoiding Array
        https://leetcode.com/contest/weekly-contest-359/problems/determine-the-minimum-sum-of-a-k-avoiding-array/*/
public class _W_359_2 {
    public int minimumSum(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        if (isKAvodiding(arr, k))
            return sum(arr);
        Queue<int[]> queue = new LinkedList<>();
        return kAvoidingSum(arr, k, queue);
    }

    int kAvoidingSum(int[] arr, int k, Queue<int[]> queue) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        for (int i = arr.length-1; i >= 0; i--) {
            copy[i] ++;
            if (isKAvodiding(copy, k))
                return sum(copy);
            else
                queue.add(Arrays.copyOf(copy,copy.length));
        }
        return kAvoidingSum(queue.peek(), k, queue);
    }

    boolean isKAvodiding(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k || arr[i] == arr[j])
                    return false;
            }
        }
        return true;
    }

    int sum(int[] arr) {
        int sum = 0;
        for (int n : arr)
            sum+= n;
        return sum;
    }

    @Test
    public void test() {
        assertEquals(18, minimumSum(4,5));
        assertEquals(18, minimumSum(5,4));
        assertEquals(3, minimumSum(2,6));
    }
}
