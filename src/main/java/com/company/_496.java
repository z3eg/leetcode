package com.company;

import java.util.HashMap;

public class _496 {

    /*4
    ms
            Beats
55.18%
    of users with Java*/
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            int n = nums1[i];
            Integer pos = map.get(n);
            int replacement = -1;
            for (int j = pos; j < nums2.length; j++) {
                if (n < nums2[j]) {
                    replacement = nums2[j];
                    break;
                }
            }
            nums1[i] = replacement;
        }
        return nums1;
    }

}
