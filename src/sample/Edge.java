package sample;

public class Edge{
private mapNode from;
private mapNode to;
private int weight;

public Edge(mapNode from, mapNode to, int weight){
    this.from = from;
    this.to = to;
    this.weight = weight;
}

public mapNode getTo(){
    return to;
}

public int getWeight(){
    return weight;
}
}
