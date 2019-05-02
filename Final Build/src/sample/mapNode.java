package sample;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class mapNode {
    private  String name;
    private int x, y;
    private List<Edge> edges;

    public mapNode(String name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
        this.edges = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public int getX(){ return x; }
    public int getY(){ return y; }

    public List<Edge> getEdges(){
        return edges;
    }

    public void addOneWayNeighbor(mapNode neighbor, int weight){
        weight = (int) sqrt(pow((this.getX()-neighbor.getX()), 2)+pow((this.getY()-neighbor.getY()), 2));
        this.edges.add(new Edge(this, neighbor, weight));
    }

    public void addTwoWayNeighbor(mapNode neighbor, int weight){
        weight = (int) sqrt(pow((this.getX()-neighbor.getX()), 2)+pow((this.getY()-neighbor.getY()), 2));
        addOneWayNeighbor(neighbor, weight);
        neighbor.addOneWayNeighbor(this, weight);
    }



}
