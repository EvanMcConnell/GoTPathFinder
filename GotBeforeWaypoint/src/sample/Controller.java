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
    @FXML private ChoiceBox<String> to;
    @FXML private ChoiceBox<String> from;

    mapNode startNode;
    mapNode endNode;

    private Graph graph;

    DijkstraGraph djGraph;
    List<mapNode> nodeList;
    BufferedImage bufferedImage;
    Image image;
    Lists lists = new Lists();


    @FXML
    public void initialize()  throws Exception{

        File file = new File("C:\\Users\\Jake\\Pictures\\croptest.png");
        bufferedImage = ImageIO.read(file);
       //BufferedImage image = rFilter.applyToImage(bufferedImage);
        Graphics buffImage = bufferedImage.getGraphics();
        buffImage.dispose();
        Image newImage = SwingFXUtils.toFXImage(bufferedImage, null);
        myImageView.setImage(newImage);


        nodeList = lists.populateNodeList(nodeList);
        graph = lists.populateGraph(graph, nodeList);

        /*for(int x=0;x<nodeList.size();x++){
            to.getItems().add(x);
            from.getItems().add(x);
        }*/
        for(mapNode n : nodeList){
            to.getItems().add(n.getName());
            from.getItems().add(n.getName());
        }
    }


    public void routeFinder(ActionEvent event) throws Exception {

        File file = new File("C:\\Users\\Jake\\Pictures\\croptest.png");
        bufferedImage = ImageIO.read(file);

        /*startNode = nodeList.get(from.getValue());
        endNode = nodeList.get(to.getValue());*/

        for(mapNode n : nodeList){
            System.out.println(n.getName() + " name checked");
            if(n.getName() == from.getValue()){ startNode = n; System.out.println(n.getName() + " set as from Node");}
            if(n.getName() == to.getValue()){ endNode = n; System.out.println(n.getName() + " set as to Node");}
        }

        djGraph = lists.populateDJGraph(graph, djGraph);

        
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