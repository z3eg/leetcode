package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class _787 {

    class Node {
        int id;
        int curPrice;
        int curLen;

        public Node(int id, int curPrice, int curLen) {
            this.id = id;
            this.curPrice = curPrice;
            this.curLen = curLen;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] prices = new int[n][n];
        int[] cumPrices = new int[flights.length];
        for (int[] flight : flights) {
            prices[flight[0]][flight[1]] = flight[2];
            prices[flight[1]][flight[0]] = flight[2];
        }
        Queue<Node> q = new LinkedList<>();
        int minPrice = Integer.MAX_VALUE;
        q.add(new Node(src, 0,0));
        while (!q.isEmpty()) {
            Node curNode = q.poll();
            if (curNode.id == dst)
                minPrice = Math.min(minPrice, curNode.curPrice);
            else {
                for (int i = 0; i < flights.length; i++) {
                    if (prices[curNode.id][i]!=0) {
                        if (cumPrices[i] != 0)
                            return 0; //THIS PROBLEM LOST ME HERE
//                            cumPrices[i]= Math.min()
                    }

                }
            }
        }
        return minPrice == Integer.MAX_VALUE?-1:minPrice;

    }

    @Test
    public void test() {
        assertEquals(700, findCheapestPrice(4, new int[][]{{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}}, 0,3,1));
        assertEquals(200, findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0,2,1));
        assertEquals(500, findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0,2,0));
    }
}
