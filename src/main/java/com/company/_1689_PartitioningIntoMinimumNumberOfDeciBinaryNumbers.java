package com.company;

//https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
public class _1689_PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

    public int minPartitions(String n) {
        int nLen = n.length();
        char max = '0';
        for (int i = 0; i < nLen; i++) {
            char c = n.charAt(i);
            if (c>max)
                max = c;
            if (c=='9')
                return 9;
        }
        return max-'0';
    }

    /*public int minPartitions(String n) {
        char[] chars = n.toCharArray();
        char max = '0';
        for (char c : chars) {
            if (c>max)
                max = c;
            if (c=='9')
                return 9;
        }
        return max-'0';
    }*/

    /*public int minPartitions(String n) {
        for (int i = 9; i > 1; i--) {
            if (n.contains(Integer.toString(i)))
                return i;
        }
        return 1;
    }*/

    //too slow
    /*public int minPartitions(String n) {
        char[] chars = n.toCharArray();
        int maxDig = 1;
        for (char c : chars) {
            int dig = c - '0';
            maxDig = Math.max(dig, maxDig);
            if (maxDig==9)
                return 9;
        }
        return maxDig;
    }*/
}
