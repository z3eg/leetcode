package com.company.util.graph;

import com.company.util.TreeNode;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.view.Viewer;
import org.junit.Test;

import static com.company.util.ArrayToGraphConverter.generateSampleTree;

public class TreeVisualizer {

    private static char curIndex;
    private static Graph graph;
    private static int accent;

    public static void draw(TreeNode root, TreeNode parent) throws InterruptedException {
        System.setProperty("org.graphstream.ui", "swing");
        graph = new MultiGraph("Graph");
        Viewer viewer = graph.display();
        curIndex = 'A';
        accent = 11;
        visualize(root,parent,false);
        viewer.getDefaultView().enableMouseOptions();
        /*viewer.disableAutoLayout();
        viewer.enableAutoLayout();*/
        Thread.sleep(999999999);
    }

    public static void visualize(TreeNode root, TreeNode parent, boolean isLeft) {
        String rootVal = String.valueOf(root.val);
        graph.addNode(rootVal);
        Node node = graph.getNode(rootVal);
        node.setAttribute("ui.style", "shape:circle;fill-color: #" +(isLeft?accent+"00":"00"+accent)+"00; text-color: white; size: 30px; text-alignment: center; text-size: 36;");
        increaseAccent();
        node.setAttribute("ui.label", rootVal);
        if (parent!=null) {
            graph.addEdge(String.valueOf(curIndex), String.valueOf(parent.val), rootVal, true);
            Edge edge = graph.getEdge(String.valueOf(curIndex));
            edge.setAttribute("ui.style", "text-size: 18; fill-color: #"+(isLeft?"9900":"0099")+"00;");
            edge.setAttribute("ui.label", isLeft?"less":"more");
            curIndex++;
        }
        if (root.left!=null)
            visualize(root.left, root, true);
        if (root.right!=null)
            visualize(root.right, root, false);
    }

    @Test
    public void test() throws InterruptedException {
        /*TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(8);*/
        TreeNode treeNode = generateSampleTree();
        draw(treeNode, null);
    }

    private static void decreaseAccent() {
        if (accent >=11)
            accent -=11;
    }

    private static void increaseAccent() {
        if (accent <=88)
            accent +=11;
    }
}
