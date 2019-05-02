package sample;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

public class Controller {
    private static RouteFilter rFilter = new RouteFilter();
    @FXML
    private ImageView myImageView;
    @FXML
    private ChoiceBox<String> to;
    @FXML
    private ChoiceBox<String> from;
    @FXML
    private ChoiceBox<String> waypoint;

    mapNode startNode;
    mapNode endNode;
    mapNode waypointNode;
    private Graph graph;
    DijkstraGraph djGraph;
    List<mapNode> nodeList;
    List<mapNode> pathList;
    BufferedImage bufferedImage;
    Image image;
    Lists lists = new Lists();

    public Controller() {
    }

    @FXML
    public void initialize() throws Exception {
        File file = new File("res/cropamp.png");
        this.bufferedImage = ImageIO.read(file);
        BufferedImage image = rFilter.applyToImage(this.bufferedImage);
        Graphics buffImage = this.bufferedImage.getGraphics();
        buffImage.dispose();
        Image newImage = SwingFXUtils.toFXImage(bufferedImage, null);
        this.myImageView.setImage(newImage);
        this.nodeList = this.lists.populateNodeList(this.nodeList);
        this.graph = this.lists.populateGraph(this.graph, this.nodeList);


        this.waypoint.getItems().add("none");
        for (mapNode n : nodeList) {
            this.to.getItems().add(n.getName());
            this.waypoint.getItems().add((n.getName()));
            this.from.getItems().add(n.getName());
        }
    }

    public void routeFinder(ActionEvent event) throws Exception {
        File file = new File("res/cropamp.png");
        this.bufferedImage = ImageIO.read(file);

        for (mapNode n :nodeList) {
            System.out.println(n.getName() + " name checked");
            if (n.getName() == this.from.getValue()) {
                this.startNode = n;
                System.out.println(n.getName() + " set as from Node");
            }

            if (n.getName() == this.waypoint.getValue()) {
                this.waypointNode = n;
                System.out.println(n.getName() + " set as waypoint Node");
            }

            if (n.getName() == this.to.getValue()) {
                this.endNode = n;
                System.out.println(n.getName() + " set as to Node");
            }
        }

        this.djGraph = this.lists.populateDJGraph(this.graph, this.djGraph);


        if (waypoint.getValue() == null || waypoint.getValue() == "none") {
            pathList = this.djGraph.findPath(this.startNode, this.endNode);
        } else {
            pathList = this.djGraph.findPath(this.startNode, this.waypointNode);
            pathList.addAll(this.djGraph.findPath(this.waypointNode, this.endNode));
        }

        Graphics bf = this.bufferedImage.getGraphics();

        for(int y = 0; y < pathList.size()-1; ++y) {
            int x1 = (pathList.get(y + 1)).getX();
            int y1 = (pathList.get(y + 1)).getY();
            int x2 = (pathList.get(y)).getX();
            int y2 = (pathList.get(y)).getY();
            bf.drawLine(x1, y1, x2, y2);
        }

        bf.dispose();
        Image newImage = SwingFXUtils.toFXImage(this.bufferedImage, null);
        this.myImageView.setImage(newImage);
    }
}
