package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class DijkstraGraphTest {
    DijkstraGraph djGraph;
    Graph graph;
    mapNode start, destination;
    List<mapNode> nodeList;

    @BeforeEach
    public void listsTest(){
        Lists lists = new Lists();
        nodeList = lists.populateNodeList(nodeList);
        assert(nodeList.size() != 0);

        graph = lists.populateGraph(graph, nodeList);
        assert(graph.getNodes().size() != 0);

        djGraph = lists.populateDJGraph(graph, djGraph);
        assert(djGraph.getGraph().getNodes().size() != 0);
    }

    @Test
    public void starToDestination(){
        ArrayList<mapNode> pathList = djGraph.findPath(nodeList.get(0), nodeList.get(39));
        System.out.print("Final path: ");
        for(mapNode n : pathList){ System.out.print(n.getName() + " "); }

        assert(pathList.size() == 10);

        System.out.println("-----------------------------------startToDestinationTest finshed---------------------------------");
    }

    /*@Test
    public void waypointForLoopTest(){

    }*/
}