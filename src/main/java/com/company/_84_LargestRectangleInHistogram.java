package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
//https://leetcode.com/problems/largest-rectangle-in-histogram/
public class _84_LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int biggestSquare = 0;
        int curHeight = heights[0];
        int square = curHeight;
        //go right
        int j = 1;
        while (j < heights.length && heights[j] >= curHeight) {
            square+=curHeight;
            j++;
        }
        if (square > biggestSquare) {
            biggestSquare = square;
        }
        for (int i = 1; i < heights.length; i++) {
            if (heights[i]!=heights[i-1]) {
                curHeight = heights[i];
                square = curHeight;
                //go left
                j = i-1;
                while (j >= 0 && heights[j] >= curHeight) {
                    square+=curHeight;
                    j--;
                }
                //go right
                j = i+1;
                while (j < heights.length && heights[j] >= curHeight) {
                    square+=curHeight;
                    j++;
                }
                if (square > biggestSquare) {
                    biggestSquare = square;
                }
            }
        }
        return biggestSquare;
    }

    /*public int largestRectangleArea(int[] heights) {
        Map<Integer, Rectange> rectanges = new HashMap<>();
        int biggestSquare = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = 1; j <= heights[i]; j++) {
                if (i == 0 && rectanges.get(j)==null) {
                    rectanges.put(j, new Rectange(j, 0));
                }
                if (i > 0 && heights[i] != heights[i-1] && rectanges.get(j)==null) {
                    rectanges.put(j, new Rectange(j, 0));
                }
            }
            Iterator<Map.Entry<Integer, Rectange>> iterator = rectanges.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Rectange> entry = iterator.next();
                Rectange curRect = entry.getValue();
                if (curRect.height > heights[i]) {
                    if (curRect.square > biggestSquare) {
                        biggestSquare = curRect.square;
                    }
                    iterator.remove();
                } else {
                    curRect.square += curRect.height;
                    if (i == heights.length - 1) {
                        if (curRect.square > biggestSquare) {
                            biggestSquare = curRect.square;
                        }
                    }
                }
            }

        }
        return biggestSquare;
    }*/

    @Test
    public void test() {
        assertEquals(10, largestRectangleArea(new int[]{2,1,5,6,2,3}));
        assertEquals(4, largestRectangleArea(new int[]{2,4}));
        assertEquals(2, largestRectangleArea(new int[]{1,1}));
        assertEquals(4, largestRectangleArea(new int[]{4,2}));
        assertEquals(3, largestRectangleArea(new int[]{2,1,2}));
    }
}
