package com.company;

import java.util.*;

/*229. Majority Element II
        https://leetcode.com/problems/majority-element-ii/description/?envType=daily-question&envId=2023-10-05*/
public class _229 {

    /*10ms
    Beats 49.32%of users with Java*/
    /*11ms
    Beats 40.97%of users with Java*/
    /*public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer val = map.get(num);
            if (val==null)
                val=0;
            val++;
            map.put(num,val);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > nums.length/3)
                res.add(e.getKey());
        }
        return res;
    }*/


    /*13ms
    Beats 21.73%of users with Java*/
    /*public List<Integer> majorityElement(int[] nums) {
        Set<Integer> res = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer val = map.get(num);
            if (val==null)
                val=0;
            val++;
            map.put(num,val);
            if (val > nums.length/3)
                res.add(num);
        }
        return new LinkedList<>(res);
    }*/

    /*2ms
    Beats 98.52%of users with Java*/
    /*3ms
    Beats 68.13%of users with Java*/
    public List<Integer> majorityElement(int[] nums) {
        boolean[] checked = new boolean[nums.length];
        int[] max = new int[2];
        int[] secondMax = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (!checked[i]) {
                int curNum = nums[i];
                int cur = 0;
                for (int j = i; j < nums.length; j++) {
                    if (!checked[j] && nums[j] == curNum) {
                        cur++;
                        checked[j] = true;
                    }
                }
                if (max[0] <= cur) {
                    secondMax[0] = max[0];
                    secondMax[1] = max[1];
                    max[0] = cur;
                    max[1] = curNum;
                }
                else if (secondMax[0] < cur) {
                    secondMax[0] = cur;
                    secondMax[1] = curNum;
                }
            }
        }
        List<Integer> res = new LinkedList<>();
        if (max[0] > nums.length/3)
            res.add(max[1]);
        if (secondMax[0] > nums.length/3)
            res.add(secondMax[1]);
        return res;
    }
}
