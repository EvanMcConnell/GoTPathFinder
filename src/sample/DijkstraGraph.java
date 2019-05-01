package sample;

import java.util.*;

public class DijkstraGraph{
    private Graph graph;

    public DijkstraGraph(Graph graph){
        this.graph = graph;
    }

    public Graph getGraph(){
        return graph;
    }

    private Map<mapNode, mapNode> getPreviousNodeMapping(){
        Map<mapNode, mapNode> mappings = new HashMap<>();
        for(mapNode n : getGraph().getNodes()){
            mappings.put(n, null);
        }
        return mappings;
    }

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

    private Map<mapNode, Integer> getNodeDistanceMapping(mapNode from){
        Map<mapNode, Integer> mappings = new HashMap<mapNode, Integer>();
        for(mapNode n : getGraph().getNodes()){
            mappings.put(n, Integer.MAX_VALUE);
        }
        mappings.put(from, 0);
        return mappings;
    }

    public ArrayList findPath(mapNode start, mapNode destination){
        /*List<Node> Output = new ArrayList<>();

        Set<Node> unsettled;
        for(Node n : nodeList){
            unsettled.add(n);
        }

        while(unsettled.size() != 0){
            getLowestUnsettledNode(unsettled, getNodeDistanceMapping())
        }*/

        Map<mapNode, Integer> nodeDisranceMapping = getNodeDistanceMapping(start);

        Map<mapNode,mapNode> previousNodeMapping = getPreviousNodeMapping();

        Set<mapNode> unsettled = new HashSet<>();
        unsettled.add(start);

        Set<mapNode> settled = new HashSet<>();

        while (unsettled.size() != 0){
            mapNode currentNode = getLowestUnsettledNode(unsettled, nodeDisranceMapping);

            int currentDistance = nodeDisranceMapping.get(currentNode);
            unsettled.remove(currentNode);

            int edgeCheckCount = 0;
            for(final Edge e: currentNode.getEdges()){
                System.out.println(" edges checked: " + edgeCheckCount + " " + e.getTo().getName());
                edgeCheckCount++;

                int currentNeighbourDistance = nodeDisranceMapping.get(e.getTo());
                int newNeighbourDistance = currentDistance + e.getWeight();
                if(!settled.contains(e.getTo()) && newNeighbourDistance < currentNeighbourDistance){
                    nodeDisranceMapping.put(e.getTo(), newNeighbourDistance);
                    previousNodeMapping.put(e.getTo(), currentNode);
                    unsettled.add(e.getTo());
                }
            }
            settled.add(currentNode);
        }

        List<mapNode> path = new ArrayList<>();
        for(mapNode n = destination; n != null; n = previousNodeMapping.get(n)){
            System.out.println(n.getName()+ " added to path");
            path.add(n);
        }
        Collections.reverse(path);
        for(mapNode n : path){
            System.out.println(n.getName() + "  ");
        }
        return (ArrayList) path;
    }
}
