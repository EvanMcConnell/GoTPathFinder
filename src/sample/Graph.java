package sample;

import sample.Main;

import java.util.List;

public class Graph {
    private List<mapNode> nodes;

    public Graph(List<mapNode> nodes){
        this.nodes = nodes;
    }

    public List<mapNode> getNodes(){
        return nodes;
    }
}
