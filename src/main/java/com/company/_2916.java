package com.company;

public class _2916 {

    /*Time Limit Exceeded
537 / 542 testcases passed*/
    class Solution {
        public int sumCounts(int[] nums) {
            int l = 0;
            int r = 0;
            long sum = 0;
            int[] freqMap = new int[100001];
            freqMap[nums[0]]++;
            boolean goingLeft = false;
            int uqNums = 1;
            sum = 1;
            while (r-l<nums.length-1) {
                if (!goingLeft) {
                    if (r==nums.length-1)
                    {
                        goingLeft = true;
                        l--;
                        uqNums = add(l, nums, freqMap, uqNums);
                        sum+=uqNums*uqNums;
                    }
                    else {
                        r++;
                        uqNums = add(r, nums, freqMap, uqNums);
                        uqNums = remove(l, nums, freqMap, uqNums);
                        l++;
                        sum+=uqNums*uqNums;
                    }
                }
                else {
                    if (l==0) {
                        goingLeft = false;
                        r++;
                        uqNums = add(r, nums, freqMap, uqNums);
                        sum+=uqNums*uqNums;
                    }
                    else {
                        l--;
                        uqNums = add(l,nums,freqMap,uqNums);
                        uqNums = remove(r,nums,freqMap,uqNums);
                        r--;
                        sum+=uqNums*uqNums;
                    }
                }
            }
            return (int) (sum%1000000007);
        }

        int add(int idx, int[] nums, int[] freqMap, int uqNums) {
            freqMap[nums[idx]]++;
            //new unique element in the window
            if (freqMap[nums[idx]]==1)
                uqNums++;
            return uqNums;
        }

        int remove(int idx, int[] nums, int[] freqMap, int uqNums) {
            freqMap[nums[idx]]--;
            //unique element left the window
            if (freqMap[nums[idx]]==0)
                uqNums--;
            return uqNums;
        }
    }
}
