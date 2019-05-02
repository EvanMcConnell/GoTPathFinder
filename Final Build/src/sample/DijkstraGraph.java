package sample;

import java.util.*;

public class DijkstraGraph{
    private Graph graph;

    //takes in a graph to be used
    public DijkstraGraph(Graph graph){
        this.graph = graph;
    }

    //getter for the map
    public Graph getGraph(){
        return graph;
    }

    //sets up a map to store the previous node travelled to in order to reach said node
    private Map<mapNode, mapNode> getPreviousNodeMapping(){
        Map<mapNode, mapNode> mappings = new HashMap<>();
        for(mapNode n : getGraph().getNodes()){
            mappings.put(n, null);
        }
        return mappings;
    }

    //finds the lowest distance node in a  given set
    private mapNode getLowestUnsettledNode(Set<mapNode> unsettled, Map<mapNode, Integer> distanceMapping){
        Iterator<mapNode> iter = unsettled.iterator();
        if(!iter.hasNext()){
            return null;
        }
        mapNode selected = iter.next();
        while(iter.hasNext()){
            mapNode n = iter.next();
            if(distanceMapping.get(n) < distanceMapping.get(selected)){
                selected = n;
            }
        }
        return selected;
    }

    //sets up the map to store the distance to each node from a given node
    private Map<mapNode, Integer> getNodeDistanceMapping(mapNode from){
        Map<mapNode, Integer> mappings = new HashMap<mapNode, Integer>();

        //sets every node bsr the starting node to have an infinite initial distance
        for(mapNode n : getGraph().getNodes()){
            mappings.put(n, Integer.MAX_VALUE);
        }
        //the starting node starts with a distance of 0
        mappings.put(from, 0);
        return mappings;
    }

    //takes in two nodes and returns an array of the path of nodes taken to reach the second
    public ArrayList findPath(mapNode start, mapNode destination){

        //creates a new distance map to store the distance to every node
        Map<mapNode, Integer> nodeDistanceMapping = getNodeDistanceMapping(start);

        // create a new map to store the previous node
        // to be travelled to in order to reach said node
        Map<mapNode,mapNode> previousNodeMapping = getPreviousNodeMapping();

        //creates an empty set to store the nodes
        //the starting node is added to this by default
        Set<mapNode> unsettled = new HashSet<>();
        unsettled.add(start);

        Set<mapNode> settled = new HashSet<>();

        //checks every node starting with the start node
        while (unsettled.size() != 0){
            //on every loop sets currentNode to be lowest distance unchecked node
            mapNode currentNode = getLowestUnsettledNode(unsettled, nodeDistanceMapping);

            //creates an in equal to the distance to the currentNode
            int currentDistance = nodeDistanceMapping.get(currentNode);

            //removes the currentNode from the list of unchecked nodes
            unsettled.remove(currentNode);

            //used in error checking so it can print out how many edges it's checked and where the edge goes
            int edgeCheckCount = 0;

            //cycles through every edge connected to the currentNode
            for(final Edge e: currentNode.getEdges()){
                //prints out how many nodes it's checked and where the current edge goes
                System.out.println(" edges checked: " + edgeCheckCount + " " + e.getTo().getName());
                edgeCheckCount++;

                //stores the distance to the node connected to the current next node
                int currentNeighbourDistance = nodeDistanceMapping.get(e.getTo());

                //stores how far it would be from the start node to the next node
                //going through the currentNode
                int newNeighbourDistance = currentDistance + e.getWeight();

                //if the next node hasn't already been searched from and the distance
                //from the start node to it is less if you go through the currentNode rather than
                //the current previousNodeMapping result...
                //note: if this value is yet to be touched this if statemment will go through by default
                //since any value is less than MAX_VALUE
                if(!settled.contains(e.getTo()) && newNeighbourDistance < currentNeighbourDistance){
                    //sets the distance to the neighbour node equal to the dstance to currentNode + the weight of the edge
                    nodeDistanceMapping.put(e.getTo(), newNeighbourDistance);

                    //sets the current node to be the previuosNodeMapping entry for the neighbour node
                    previousNodeMapping.put(e.getTo(), currentNode);

                    //adds the neighbour node to the list of nodes to be considered in the next loop
                    unsettled.add(e.getTo());
                }
            }
            //once all edges have been checked, add the currentNode to the list of settled nodes
            settled.add(currentNode);
        }

        //creates a list to store the nodes in the path
        List<mapNode> path = new ArrayList<>();

        //using the previousNodeMapping map, this for loop works backwards
        //from the destination to the start.
        for(mapNode n = destination; n != null; n = previousNodeMapping.get(n)){
            System.out.println(n.getName()+ " added to path");
            path.add(n);
        }

        //reverses the path so it reads from start to destination
        Collections.reverse(path);

        //prints out the path (used in error checking)
        for(mapNode n : path){
            System.out.println(n.getName() + "  ");
        }

        //returns the path as an ArrayList
        return (ArrayList) path;
    }
}
