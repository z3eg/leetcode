package com.company;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/number-of-provinces/
public class _547_NumberOfProvinces {

    Set<Integer> provinceIds;
    Map<Integer, Node> nodes;

    class Node {
        int id;
        int provinceId;
        List<Node> neighbours;

        public Node(int id, int provinceId) {
            this.id = id;
            this.provinceId = provinceId;
            this.neighbours = new LinkedList<>();
        }
    }

    public int findCircleNum(int[][] isConnected) {
        provinceIds = new HashSet<>();
        int curProvinceId = 0;
        nodes = new HashMap<>();
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j]==1) {
                    Node node1 = nodes.get(i);
                    if (node1==null) {
                        node1 = new Node(i, curProvinceId);
                        provinceIds.add(curProvinceId);
                        curProvinceId++;
                        nodes.put(i, node1);
                    }
                    Node node2 = nodes.get(j);
                    if (node2==null) {
                        node2 = new Node(j, curProvinceId);
                        provinceIds.add(curProvinceId);
                        curProvinceId++;
                        nodes.put(i, node2);
                    }
                    consume(node2, node1);
                    node1.neighbours.add(node2);
                    node2.neighbours.add(node1);
                }
            }
        }
        return provinceIds.size();
    }

    public void consume(Node predator, Node prey) {
        if (predator.provinceId!= prey.provinceId) {
            provinceIds.remove(prey.provinceId);
            prey.provinceId=predator.provinceId;
            for (Node neighbour : prey.neighbours) {
                consume(predator, neighbour);
            }
        }
    }

    @Test
    public void test() {
         assertEquals(2, findCircleNum(new int[][]{{1,1,0},
                                                            {1,1,0},
                                                            {0,0,1}}));
        assertEquals(3, findCircleNum(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));
    }
}
