package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

public class _88 {
    /*0ms
    Beats 100.00%of users with Java*/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n==0)
            return;
        if (m==0) {
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        for (int n2 : nums2) {
            m = insert(nums1, n2, m);
        }
    }

    private int insert(int[] nums, int num2, int m) {
        int posToInsert = bs(nums, num2, 0, m);
        for (int i = m-1; i >= posToInsert && i < nums.length-1; i--) {
            nums[i+1] = nums[i];
        }
        nums[posToInsert] = num2;
        return ++m;
    }

    int bs(int[] nums, int n, int l, int r) {
        if (n < nums[l])
            return l;
        if ((r-l)<=1)
            return r;
        int mid = (l+r)/2;
        if (nums[mid]==n)
            return mid;
        if (n < nums[mid])
            return bs(nums, n, l, mid);
        if (n > nums[mid])
            return bs(nums, n, mid, r);
        return -1;
    }


    @Test
    public void test() {

        int[] nums1;

        nums1 = new int[]{4,0,0,0,0,0};
        merge(nums1, 1, new int[]{1,2,3,5,6}, 5);
        assertArrayEquals(new int[]{1,2,3,4,5,6}, nums1);

        nums1 = new int[]{4,5,6,0,0,0};
        merge(nums1, 3, new int[]{1,2,3}, 3);
        assertArrayEquals(new int[]{1,2,3,4,5,6}, nums1);

        nums1 = new int[]{2,0};
        merge(nums1, 1, new int[]{1}, 1);
        assertArrayEquals(new int[]{1,2}, nums1);

        nums1 = new int[]{1,2,3,0,0,0};
        merge(nums1, 3, new int[]{2,5,6}, 3);
        assertArrayEquals(new int[]{1,2,2,3,5,6}, nums1);
        nums1 = new int[]{1};
        merge(nums1, 1, new int[]{}, 0);
        assertArrayEquals(new int[]{1}, nums1);
        nums1 = new int[1];
        merge(nums1, 0, new int[]{1}, 1);
        assertArrayEquals(new int[]{1}, nums1);


    }
}
