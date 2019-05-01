package sample;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;


public class Controller {
    private static FileChooser fileChooser = new FileChooser();
    private static RouteFilter rFilter = new RouteFilter();

    @FXML private ImageView myImageView;
    @FXML private ChoiceBox<mapNode> to;
    @FXML private ChoiceBox<mapNode> from;

    mapNode startNode;
    mapNode endNode;

    private Graph graph;

    ArrayList<mapNode> nodeList;
    BufferedImage bufferedImage;
    Image image;


    @FXML
    public void initialize()  throws Exception{

        File file = new File("C:\\Users\\Jake\\Pictures\\croptest.png");
        bufferedImage = ImageIO.read(file);
       //BufferedImage image = rFilter.applyToImage(bufferedImage);
        Graphics buffImage = bufferedImage.getGraphics();
        buffImage.dispose();
        Image newImage = SwingFXUtils.toFXImage(bufferedImage, null);
        myImageView.setImage(newImage);


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

        nodeList = new ArrayList<mapNode>();

        nodeList.addAll(Arrays.asList(node1, node2 , node3, node4, node5, node6, node7 , node8, node9, node10
                                , node11, node12 ,node14, node15 , node16, node17, node18, node19, node20,
                                    node21, node22, node23, node24, node25, node26, node27, node28, node29
                                 , node30, node31, node32, node33, node34, node35, node36, node37, node38, node39, node40));
        graph = new Graph(nodeList);


        to.getItems().addAll(nodeList.get(0), nodeList.get(1), nodeList.get(2), nodeList.get(3), nodeList.get(4), nodeList.get(5), nodeList.get(6), nodeList.get(7), nodeList.get(8), nodeList.get(9), nodeList.get(10)
                , nodeList.get(11), nodeList.get(12), nodeList.get(13), nodeList.get(14), nodeList.get(15), nodeList.get(16), nodeList.get(17), nodeList.get(18), nodeList.get(19), nodeList.get(20)
                , nodeList.get(21), nodeList.get(22), nodeList.get(23), nodeList.get(24), nodeList.get(25), nodeList.get(26), nodeList.get(27), nodeList.get(28), nodeList.get(29), nodeList.get(30)
                , nodeList.get(31), nodeList.get(32), nodeList.get(33), nodeList.get(34), nodeList.get(35), nodeList.get(36), nodeList.get(37), nodeList.get(38)
        );

        from.getItems().addAll(nodeList.get(0), nodeList.get(1), nodeList.get(2), nodeList.get(3), nodeList.get(4), nodeList.get(5), nodeList.get(6), nodeList.get(7), nodeList.get(8), nodeList.get(9), nodeList.get(10)
                , nodeList.get(11), nodeList.get(12), nodeList.get(13), nodeList.get(14), nodeList.get(15), nodeList.get(16), nodeList.get(17), nodeList.get(18), nodeList.get(19), nodeList.get(20)
                , nodeList.get(21), nodeList.get(22), nodeList.get(23), nodeList.get(24), nodeList.get(25), nodeList.get(26), nodeList.get(27), nodeList.get(28), nodeList.get(29), nodeList.get(30)
                , nodeList.get(31), nodeList.get(32), nodeList.get(33), nodeList.get(34), nodeList.get(35), nodeList.get(36), nodeList.get(37), nodeList.get(38)
                );
    }


    public void routeFinder(ActionEvent event) throws Exception {

        File file = new File("C:\\Users\\Jake\\Pictures\\croptest.png");
        bufferedImage = ImageIO.read(file);

        startNode = from.getValue();
        endNode = to.getValue();

        DijkstraGraph djGraph = new DijkstraGraph(graph);
        List<mapNode> pathList = djGraph.findPath(startNode, endNode);

        Graphics bf = bufferedImage.getGraphics();
        int x = 0;
        for(int y = 1; y < pathList.size(); y++) {
            int x1 = pathList.get(x).getX();
            int y1 = pathList.get(x).getY();

            int x2 = pathList.get(y).getX();
            int y2 = pathList.get(y).getY();

            bf.drawLine(x1, y1, x2, y2);
            x++;
        }

        bf.dispose();
        Image newImage = SwingFXUtils.toFXImage(bufferedImage, null);
        myImageView.setImage(newImage);
    }
}