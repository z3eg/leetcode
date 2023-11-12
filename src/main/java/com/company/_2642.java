package com.company;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class _2642 {
   /* Time Limit Exceeded
33 / 36 testcases passed*/
    class Graph {

        int[][] adjMat;
        int[][] closestMatrix;
        Map<Integer, List<Integer>> map;

        int edgesAdded;
        int[][] calculatedOnEdgesAdded;

        public Graph(int n, int[][] edges) {
            edgesAdded = 0;
            calculatedOnEdgesAdded = new int[n][n];
            adjMat = new int[n][n];
            closestMatrix = new int[n][n];
            map = new HashMap<>();
            for (int[] edge : edges) {
                adjMat[edge[0]][edge[1]] = edge[2];
                List<Integer> list = map.get(edge[0]);
                if (list == null) {
                    list = new LinkedList<>();
                }
                list.add(edge[1]);
                map.put(edge[0], list);
            }
        }

        public void addEdge(int[] edge) {
            adjMat[edge[0]][edge[1]] = edge[2];
            List<Integer> list = map.get(edge[0]);
            if (list == null) {
                list = new LinkedList<>();
            }
            list.add(edge[1]);
            map.put(edge[0], list);
            edgesAdded++;
        }

        private List<Integer> adjNodes(int node) {
            return map.get(node);
        }

        public int shortestPath(int node1, int node2) {
            if (node1==node2)
                return 0;
            if (calculatedOnEdgesAdded[node1][node2] == edgesAdded && closestMatrix[node1][node2]!=0 && closestMatrix[node1][node2]!=-1)
                return closestMatrix[node1][node2];
            //dijkstra here?
            int minDist = Integer.MAX_VALUE;
            Map<Integer, Integer> visitedNodes = new HashMap<>();
            Queue<int[]> nodesToVisit = new LinkedList<>();
            List<Integer> adjNodes = adjNodes(node1);
            if (adjNodes!=null) {
                for (Integer node : adjNodes) {
                    nodesToVisit.add(new int[]{node,adjMat[node1][node]});
                }
            }
            visitedNodes.put(node1, 0);
            while (!nodesToVisit.isEmpty()) {
                int[] curNode = nodesToVisit.poll();
                if (curNode[0] == node2) {
                    minDist = Math.min(minDist, curNode[1]);
                }
                else if (calculatedOnEdgesAdded[curNode[0]][node2] == edgesAdded
                        && closestMatrix[curNode[0]][node2]!=0
                        && closestMatrix[curNode[0]][node2]!=-1) {
                    minDist = Math.min(minDist, curNode[1] + closestMatrix[curNode[0]][node2]);
                }
                else {
                    adjNodes = adjNodes(curNode[0]);
                    if (adjNodes != null) {
                        for (Integer node : adjNodes) {
                            Integer minDistToNode = visitedNodes.get(node);
                            int newDist = curNode[1] + adjMat[curNode[0]][node];
                            if (minDistToNode == null || minDistToNode > newDist) {
                                nodesToVisit.add(new int[]{node, newDist});
                                visitedNodes.put(node, newDist);
                            }
                        }
                    }
                }
                visitedNodes.put(curNode[0], curNode[1]);
            }
            int res = (minDist == Integer.MAX_VALUE ? -1 : minDist);
            closestMatrix[node1][node2] = res;
            calculatedOnEdgesAdded[node1][node2] = edgesAdded;
            return res;
        }
    }

    @Test
    public void test() {
        Graph graph = new Graph(4, new int[][]{{0, 2, 5}, {0, 1, 2}, {1, 2, 1}, {3, 0, 3}});
        assertEquals(6, graph.shortestPath(3,2));
        assertEquals(-1, graph.shortestPath(0,3));
        graph.addEdge(new int[]{1, 3, 4});
        assertEquals(6, graph.shortestPath(0,3));

    }
}
