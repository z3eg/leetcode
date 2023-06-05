package com.company.util.graph;

import org.graphstream.graph.Edge;
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
        Edge edge = graph.getEdge("34_67");
        for (int i = 0; i < graphArr.length; i++) {
            String iString = String.valueOf(i);
            if (graphArr[i].length>0)
                addNodeToAGraph(iString);
            for (int j = 0; j < graphArr[i].length; j++) {
                String jString = String.valueOf(graphArr[i][j]);
                addNodeToAGraph(jString);
                if (graph.getEdge(j+"_"+i)==null && graph.getEdge(i+"_"+j)==null)
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
            if (iString.equals("68"))
                node.setAttribute("ui.style", "shape:circle;fill-color: #" + accent + "00ff; text-color: white; size: 30px; text-alignment: center; text-size: 36;");
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

    @Test
    public void drawGraph80From785() throws InterruptedException {
        draw(new int[][]{{51,58,98},{81,85},{50,62,63,85,94},{52,90,91,97,99},{63,74,97},{63,64,68,82},{50,61,89},{56,58,60,79,96},{57,65,82,92},{59,68,96},{89},{50,56,86,97},{65,71},{},{96,98},{61},{56,78},{59,61,74,92},{51,76},{56,71,77},{73},{76,87,89},{51,69,78},{57,68,74,93},{64,66,79},{53,59},{66},{53,72,80,97},{56,98},{73,83,91,94,95},{55,65,66,87},{52,69,76},{71,92},{74,82},{74,78,85,87,98},{87,99},{52,62,78},{66,68,83,97},{},{52,56,69,77,80},{55,73,77,86},{53,57,71,92},{82},{53,54,56,65,74,79},{99},{56,71,90},{},{57,85},{60,61},{50,57,59,77,78},{2,6,11,49},{0,18,22},{3,31,36,39},{25,27,41,43},{43},{30,40},{7,11,16,19,28,39,43,45},{8,23,41,47,49},{0,7},{9,17,25,49},{7,48},{6,15,17,48},{2,36},{2,4,5},{5,24},{8,12,30,43},{24,26,30,37},{},{5,9,23,37},{22,31,39},{},{12,19,32,41,45},{27},{20,29,40},{4,17,23,33,34,43},{},{18,21,31},{19,39,40,49},{16,22,34,36,49},{7,24,43},{27,39},{1},{5,8,33,42},{29,37},{},{1,2,34,47},{11,40},{21,30,34,35},{},{6,10,21},{3,45},{3,29},{8,17,32,41},{23},{2,29},{29},{7,9,14},{3,4,11,27,37},{0,14,28,34},{3,35,44}});
    }



}
