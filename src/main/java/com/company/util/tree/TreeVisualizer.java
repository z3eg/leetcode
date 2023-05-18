package com.company.util.tree;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.view.Viewer;
import org.junit.Test;

import static com.company.util.ColorUtils.increaseAccent;
import static com.company.util.tree.TreeBuilder.convert;

public class TreeVisualizer {

    private static int curIndex;
    private static Graph graph;
    private static int accent;

    public static void draw(TreeNode root) throws InterruptedException {
        System.setProperty("org.graphstream.ui", "swing");
        graph = new MultiGraph("Graph");
        Viewer viewer = graph.display();
        curIndex = 1;
        accent = 11;
        visualize(root,null,false,500,500, 150);
        viewer.getDefaultView().enableMouseOptions();
        viewer.disableAutoLayout();
//        viewer.enableAutoLayout();
        Thread.sleep(999999999);
    }

    public static void visualize(TreeNode root, String parIndex, boolean isLeft, int x, int y, int xDiff) {
        String rootVal = String.valueOf(root.val);
        String curIndexS = String.valueOf(curIndex);
        graph.addNode(curIndexS);
        curIndex++;
        Node node = graph.getNode(curIndexS);
        node.setAttribute("ui.style", "shape:circle;fill-color: #" +(isLeft?accent+"00":"00"+accent)+"00; text-color: white; size: 30px; text-alignment: center; text-size: 36;");
        accent = increaseAccent(accent);
        node.setAttribute("ui.label", rootVal);
        node.setAttribute("x", x);
        node.setAttribute("y", y);
        if (parIndex!=null) {
            graph.addEdge(curIndexS, parIndex, curIndexS, true);
            Edge edge = graph.getEdge(curIndexS);
            edge.setAttribute("ui.style", "text-size: 18; fill-color: #"+(isLeft?"9900":"0099")+"00;");
//            edge.setAttribute("ui.label", isLeft?"less":"more");
            curIndex++;
        }
        if (root.left!=null)
            visualize(root.left, curIndexS, true, x-xDiff, y-50, xDiff/2);
        if (root.right!=null)
            visualize(root.right, curIndexS, false, x+xDiff, y-50, xDiff/2);
    }

    @Test
    public void test() throws InterruptedException {
//        TreeNode treeNode = generateSampleTree();
//        TreeNode treeNode = convert("[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]");
        TreeNode treeNode = convert("[4,1,6,0,2,5,7,3,8,4,1,6,0,2,5,7,8,4,1,6,0,2,5,7,3,8,4,1,6,0,2,5,7,8,4,1,6,0,2,5,7,3,8,4,1,6,0,2,5,7,8,4,1,6,0,2,5,7,3,8,4,1,6,0,2,5,7,8,4,1,6,0,2,5,7,3,8,4,1,6,0,2,5,7,8,4,1,6,0,2,5,7,3,8,4,1,6,0,2,5,7,8]");
//        TreeNode treeNode = convert("[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]");
        draw(treeNode);
    }


}
