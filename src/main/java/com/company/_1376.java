package com.company;

import org.graphstream.graph.Graph;
import org.junit.Test;

import static com.company.util.ColorUtils.increaseAccent;
import static org.junit.Assert.assertEquals;

/*1376. Time Needed to Inform All Employees
        https://leetcode.com/problems/time-needed-to-inform-all-employees/*/
public class _1376 {

    private static Graph graph;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        return addSubs(n, headID, manager, informTime, 0, 0);
    }

    private int addSubs(int n, int index, int[] manager, int[] informTime, int informTimeForThis, int maxTime) {
        if (informTime[index]==0) {
            maxTime = Math.max(maxTime,informTimeForThis);
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] == index) {
                maxTime = addSubs(n, i, manager, informTime, informTimeForThis+informTime[index], maxTime);
            }
        }
        return maxTime;
    }

    /*private void draw(Node root) throws InterruptedException {
        System.setProperty("org.graphstream.ui", "swing");
        graph = new MultiGraph("Graph");
        Viewer viewer = graph.display();
        visualize(root);
        viewer.getDefaultView().enableMouseOptions();
//        viewer.disableAutoLayout();
//        viewer.enableAutoLayout();
        Thread.sleep(999999999);
    }*/

    /*public static void visualize(Node root) {
        org.graphstream.graph.Node node;
        String rootId = String.valueOf(root.id);
        node = graph.getNode(rootId);
        if (node == null) {
            graph.addNode(rootId);
        }
        node = graph.getNode(rootId);
        node.setAttribute("ui.style", "shape:circle;fill-color: #" +"000000; text-color: white; size: 30px; text-alignment: center; text-size: 36;");
        node.setAttribute("ui.label", rootId);
        for (Node sub : root.subs) {
            String subIndex = String.valueOf(sub.id);
            graph.addNode(subIndex);
            graph.addEdge(subIndex, rootId, subIndex, true);
            Edge edge = graph.getEdge(subIndex);
            edge.setAttribute("ui.style", "text-size: 18; fill-color: #990000;");
            edge.setAttribute("ui.label", root.informTime);
            visualize(sub);
        }
    }*/

    @Test
    public void test() throws InterruptedException {
        assertEquals(612, numOfMinutes(8, 0, new int[]{-1,5,0,6,7,0,0,0}, new int[]{89,0,0,0,0,523,241,519}));
        assertEquals(3, numOfMinutes(15, 0, new int[]{-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6}, new int[]{1,1,1,1,1,1,1,0,0,0,0,0,0,0,0}));
        assertEquals(1, numOfMinutes(6, 2, new int[]{2,2,-1,2,2,2}, new int[]{0,0,1,0,0,0}));
        assertEquals(0, numOfMinutes(1, 0, new int[]{-1}, new int[]{0}));
    }
}
