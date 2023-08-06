package com.company;

import org.junit.jupiter.api.Test;
import scala.Int;
import scala.util.parsing.combinator.PackratParsers;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*6956. Minimum Seconds to Equalize a Circular Array
        https://leetcode.com/contest/biweekly-contest-110/problems/minimum-seconds-to-equalize-a-circular-array/*/
public class _BW110_3 {
    public int minimumSeconds(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer integer = map.get(num);
            if (integer==null)
                integer = 0;
            map.put(num, integer +1);
        }
        int newNAme = Integer.MIN_VALUE;
        int maxNumber = 0; //highest frequency
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (newNAme < entry.getValue()) {
                newNAme = entry.getValue();
                maxNumber = entry.getKey();
            }
        }
        List<Integer> maxVals = new LinkedList<>(); //most represented numbers (having equal maximum presence in the list)
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (newNAme == entry.getValue()) {
                maxVals.add(entry.getKey());
            }
        }
        if (newNAme == 1)
            return nums.size()/2;
        List<Integer> positions = new LinkedList<>();
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i)==maxNumber)
                positions.add(i);
        }
        int[][] pointers = new int[positions.size()][2];
        for (int i = 0; i < positions.size(); i++) {
            pointers[i][0] = positions.get(i);
            pointers[i][1] = positions.get(i);
        }
        int n = nums.size();
        int counter = 0;
        while (!equalized(nums)) {
            for (int[] LRpair : pointers) {
                LRpair[0]--;
                LRpair[1]++;
                nums.set((LRpair[0]+n)%n,maxNumber);
                nums.set((LRpair[1])%n,maxNumber);
            }
            counter++;
        }
        return counter;
    }

    boolean equalized(List<Integer> list) {
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i)!= list.get(i+1))
                return false;
        }
        return true;
    }

    @Test
    public void test() {
        assertEquals(1, minimumSeconds(Arrays.asList(8,8,9,10,9)));
        assertEquals(1, minimumSeconds(Arrays.asList(8,13,3,3)));
        assertEquals(1, minimumSeconds(Arrays.asList(17,13,9)));
        assertEquals(1, minimumSeconds(Arrays.asList(17,15)));
        assertEquals(1, minimumSeconds(Arrays.asList(4,18)));
        assertEquals(1, minimumSeconds(Arrays.asList(1,2,1,2)));
        assertEquals(2, minimumSeconds(Arrays.asList(2,1,3,3,2)));
        assertEquals(0, minimumSeconds(Arrays.asList(5,5,5,5)));
    }

    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n * 2];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[n+i] = nums[i];
        }
        return ans;
    }

}
