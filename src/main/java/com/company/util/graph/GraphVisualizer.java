package com.company.util.graph;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.view.Viewer;
import org.junit.Test;

import static com.company.util.ColorUtils.decreaseAccent;
import static com.company.util.ColorUtils.increaseAccent;

public class GraphVisualizer {

    private static Graph graph;
    private static int accent;

    //example of graphArr: [[1,2],[3],[3],[]] (https://leetcode.com/problems/all-paths-from-source-to-target/)
    public static void draw(int[][] graphArr) throws InterruptedException {
        System.setProperty("org.graphstream.ui", "swing");
        graph = new MultiGraph("Graph");
        Viewer viewer = graph.display();
        accent = 11;
        visualize(graphArr);
        viewer.getDefaultView().enableMouseOptions();
        viewer.disableAutoLayout();
        viewer.enableAutoLayout();
        Thread.sleep(999999999);
    }

    public static void visualize(int[][] graphArr) {
        for (int i = 0; i < graphArr.length; i++) {
            String iString = String.valueOf(i);
            addNodeToAGraph(iString);
            for (int j = 0; j < graphArr[i].length; j++) {
                String jString = String.valueOf(graphArr[i][j]);
                addNodeToAGraph(jString);
                graph.addEdge(i+"_"+j, iString, jString, true);
                accent = increaseAccent(accent, 33);
            }
        }
    }

    private static void addNodeToAGraph(String iString) {
        if (graph.getNode(iString)==null) {
            graph.addNode(iString);
            Node node = graph.getNode(iString);
            node.setAttribute("ui.label", iString);
            node.setAttribute("ui.style", "shape:circle;fill-color: #" + accent + "0000; text-color: white; size: 30px; text-alignment: center; text-size: 36;");
        }
    }

    @Test
    public void test() throws InterruptedException {
        draw(new int[][]{{1,2},{3},{3},{}});
    }

    @Test
    public void test2() throws InterruptedException {
        draw(new int[][]{{4,3,1},{3,2,4},{3},{4},{}});
    }



}
