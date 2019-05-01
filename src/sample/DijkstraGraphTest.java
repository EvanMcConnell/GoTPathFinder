package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static java.awt.image.BufferedImage.TYPE_BYTE_BINARY;
import static javafx.application.Application.launch;

class DijkstraGraphTest {
    DijkstraGraph djGraph;
    Graph graph;
    mapNode start, destination;
    List<mapNode> nodeList;


    @Test
    public void finalDataSet(){
        nodeList = new ArrayList<>();

        mapNode node1 = new mapNode("1", 265, 24);
        mapNode node2 = new mapNode("2", 472, 49);
        mapNode node3 = new mapNode("3", 390, 94);
        mapNode node4 = new mapNode("4", 514, 90);
        mapNode node5 = new mapNode("5", 250, 104);
        mapNode node6 = new mapNode("6", 536, 144);
        mapNode node7 = new mapNode("7", 127, 170);
        mapNode node8 = new mapNode("8", 250, 192);
        mapNode node9 = new mapNode("9", 472, 215);
        mapNode node10 = new mapNode("10", 347, 223);
        mapNode node11 = new mapNode("11", 140, 251);
        mapNode node12 = new mapNode("12", 48, 286);
        mapNode node13 = new mapNode("13", 178, 308);
        mapNode node14 = new mapNode("14", 463, 253);
        mapNode node15 = new mapNode("15", 405, 313);
        mapNode node16 = new mapNode("16", 513, 311);
        mapNode node17 = new mapNode("17", 321, 410);
        mapNode node18 = new mapNode("18", 68, 353);
        mapNode node19 = new mapNode("19", 131, 373);
        mapNode node20 = new mapNode("20", 90, 413);
        mapNode node21 = new mapNode("21", 462, 390);
        mapNode node22 = new mapNode("22", 459, 452);
        mapNode node23 = new mapNode("23", 172, 475);
        mapNode node24 = new mapNode("24", 263, 529);
        mapNode node25 = new mapNode("25", 354, 517);
        mapNode node26 = new mapNode("26", 412, 496);
        mapNode node27 = new mapNode("27", 533, 471);
        mapNode node28 = new mapNode("28", 486, 525);
        mapNode node29 = new mapNode("29", 66, 510);
        mapNode node30 = new mapNode("30", 61, 579);
        mapNode node31 = new mapNode("31", 336, 573);
        mapNode node32 = new mapNode("32", 130, 636);
        mapNode node33 = new mapNode("33", 182, 600);
        mapNode node34 = new mapNode("34", 238, 634);
        mapNode node35 = new mapNode("35", 293, 635);
        mapNode node36 = new mapNode("36", 376, 636);
        mapNode node37 = new mapNode("37", 422, 593);
        mapNode node38 = new mapNode("38", 427, 661);
        mapNode node39 = new mapNode("39", 500, 650);
        mapNode node40 = new mapNode("40", 507, 593);

        nodeList.add(node1);
        nodeList.add(node2);
        nodeList.add(node3);
        nodeList.add(node4);
        nodeList.add(node5);
        nodeList.add(node6);
        nodeList.add(node7);
        nodeList.add(node8);
        nodeList.add(node9);
        nodeList.add(node10);
        nodeList.add(node11);
        nodeList.add(node12);
        nodeList.add(node13);
        nodeList.add(node14);
        nodeList.add(node15);
        nodeList.add(node16);
        nodeList.add(node17);
        nodeList.add(node18);
        nodeList.add(node19);
        nodeList.add(node20);
        nodeList.add(node21);
        nodeList.add(node22);
        nodeList.add(node23);
        nodeList.add(node24);
        nodeList.add(node25);
        nodeList.add(node26);
        nodeList.add(node27);
        nodeList.add(node28);
        nodeList.add(node29);
        nodeList.add(node30);
        nodeList.add(node31);
        nodeList.add(node32);
        nodeList.add(node33);
        nodeList.add(node34);
        nodeList.add(node35);
        nodeList.add(node36);
        nodeList.add(node37);
        nodeList.add(node38);
        nodeList.add(node39);
        nodeList.add(node40);

        node1.addTwoWayNeighbor(node5, 0);
        node1.addTwoWayNeighbor(node3, 0);
        node3.addTwoWayNeighbor(node2, 0);
        node3.addTwoWayNeighbor(node4, 0);
        node3.addTwoWayNeighbor(node9, 0);
        node3.addTwoWayNeighbor(node8, 0);
        node5.addTwoWayNeighbor(node8, 0);
        node7.addTwoWayNeighbor(node8, 0);
        node7.addTwoWayNeighbor(node11, 0);
        node9.addTwoWayNeighbor(node6, 0);
        node9.addTwoWayNeighbor(node10, 0);
        node8.addTwoWayNeighbor(node10, 0);
        node8.addTwoWayNeighbor(node13, 0);
        node11.addTwoWayNeighbor(node12, 0);
        node11.addTwoWayNeighbor(node13, 0);
        node14.addTwoWayNeighbor(node10, 0);
        node14.addTwoWayNeighbor(node15, 0);
        node15.addTwoWayNeighbor(node13, 0);
        node15.addTwoWayNeighbor(node17, 0);
        node15.addTwoWayNeighbor(node21, 0);
        node21.addTwoWayNeighbor(node16, 0);
        node21.addTwoWayNeighbor(node17, 0);
        node21.addTwoWayNeighbor(node22, 0);
        node17.addTwoWayNeighbor(node13, 0);
        node17.addTwoWayNeighbor(node23, 0);
        node17.addTwoWayNeighbor(node25, 0);
        node25.addTwoWayNeighbor(node26, 0);
        node25.addTwoWayNeighbor(node34, 0);
        node22.addTwoWayNeighbor(node26, 0);
        node22.addTwoWayNeighbor(node27, 0);
        node28.addTwoWayNeighbor(node26, 0);
        node28.addTwoWayNeighbor(node27, 0);
        node15.addTwoWayNeighbor(node13, 0);
        node15.addTwoWayNeighbor(node18, 0);
        node15.addTwoWayNeighbor(node20, 0);
        node15.addTwoWayNeighbor(node23, 0);
        node18.addTwoWayNeighbor(node20, 0);
        node23.addTwoWayNeighbor(node29, 0);
        node23.addTwoWayNeighbor(node24, 0);
        node24.addTwoWayNeighbor(node30, 0);
        node24.addTwoWayNeighbor(node33, 0);
        node24.addTwoWayNeighbor(node31, 0);
        node30.addTwoWayNeighbor(node29, 0);
        node30.addTwoWayNeighbor(node32, 0);
        node33.addTwoWayNeighbor(node32, 0);
        node33.addTwoWayNeighbor(node34, 0);
        node35.addTwoWayNeighbor(node34, 0);
        node35.addTwoWayNeighbor(node31, 0);
        node36.addTwoWayNeighbor(node31, 0);
        node36.addTwoWayNeighbor(node35, 0);
        node39.addTwoWayNeighbor(node40, 0);
        node39.addTwoWayNeighbor(node35, 0);
        node37.addTwoWayNeighbor(node31, 0);
        node37.addTwoWayNeighbor(node40, 0);

        graph = new Graph(nodeList);

        djGraph = new DijkstraGraph(graph);

        ArrayList<mapNode> pathList = djGraph.findPath(node1, node40);
        System.out.print("Final path: ");
        for(mapNode n : pathList){ System.out.print(n.getName() + " "); }


        BufferedImage bf = new BufferedImage(595, 715, TYPE_BYTE_BINARY);
        for(int x = 0; x < pathList.size()-1; x++){
            for(int y = 1; y < pathList.size()-1; y++) {
                int x1 = pathList.get(x).getX();
                int y1 = pathList.get(x).getY();

                int x2 = pathList.get(y).getX();
                int y2 = pathList.get(y).getY();

                bf.getGraphics().drawLine(x1, y1, x2, y2);
            }
        }

        FileChooser fc = new FileChooser();
        //File file = fc.showOpenDialog(null);


        VBox vb = new VBox();

        ImageView iv = new ImageView(SwingFXUtils.toFXImage(bf, null));

        vb.getChildren().add(iv);

        /*primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(vb, 595, 715));
        primaryStage.show();*/
    }
}