package sample;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.w3c.dom.NodeList;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;

import static java.awt.image.BufferedImage.TYPE_BYTE_BINARY;

public class Main extends Application {
    mapNode start, destination;
    private Graph graph;
    private DijkstraGraph djGraph;
    private List<mapNode> nodeList;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scanner input = new Scanner(System.in);
        Lists lists = new Lists();
        nodeList = lists.populateNodeList(nodeList);
        graph = lists.populateGraph(graph, nodeList);
        djGraph = lists.populateDJGraph(graph, djGraph);

        System.out.println("Node 1:");
        int nodeNumber1 = input.nextInt();
        System.out.println("Node 2:");
        int nodeNumber2 = input.nextInt();

        for(mapNode n : nodeList){
            System.out.print(n.getName() + " ");
        }
        ArrayList<mapNode> pathList = djGraph.findPath(nodeList.get(nodeNumber1), nodeList.get(nodeNumber2));
        System.out.print("Final path: ");
        for(mapNode n : pathList){ System.out.print(n.getName() + " "); }

        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(null);
        //BufferedImage bf = new BufferedImage(595, 715, TYPE_BYTE_BINARY);
        BufferedImage bf = ImageIO.read(file);

        int x = 0;
            for(int y = 1; y < pathList.size()-1; y++) {
                int x1 = pathList.get(x).getX();
                int y1 = pathList.get(x).getY();

                int x2 = pathList.get(y).getX();
                int y2 = pathList.get(y).getY();

                bf.getGraphics().drawLine(x1, y1, x2, y2);
                x++;
            }




        VBox vb = new VBox();

        ImageView iv = new ImageView(SwingFXUtils.toFXImage(bf, null));

        vb.getChildren().add(iv);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(vb, 595, 715));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
