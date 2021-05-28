package Algoritmer;



import Interfaces.EdgeFly;

import Interfaces.GraphRoute;

import java.util.*;

public class Dijkstra {
    //private int[] pathArray;
    private LinkedHashMap<String, Float> bestWeight;
    //private float[] bestWeight;
    private LinkedHashMap<String, String> pathArray;
    private HashMap<String, Boolean> marked;
    private PriorityQueue pq;

    public Dijkstra(GraphRoute g, String departAirport, String targetAirport) {

        pathArray = new LinkedHashMap(g.getVertiesCount());

        bestWeight = new LinkedHashMap(g.getVertiesCount());

        this.marked = new HashMap<>(g.getVertiesCount());
        marked.put(departAirport, true);
        String currentAirport = departAirport;

        pathArray.put(departAirport, departAirport);
        bestWeight.put(currentAirport, (float) 0);
        pq = new PriorityQueue();
        pq.add(departAirport);

        while (!pq.isEmpty()) {
            pq.remove(currentAirport);
            Float currentCost = bestWeight.get(currentAirport);
            //if (startNode == curNode) pq.dequeue();
            //System.out.println("curNode: " + curNode);
            for (EdgeFly edgeFly : g.adj(currentAirport)) {
                float cost = (float) (currentCost + edgeFly.getDistance());
                String destinationAirport = edgeFly.getDestinationAirport().getCode();
                Float aFloat = bestWeight.get(destinationAirport);
                if (aFloat == null) aFloat = Float.MAX_VALUE;
                if (cost < aFloat) {
                    System.out.println("adding destinationAirport: " + destinationAirport + " with cost: " + cost +
                            " aFloat: " + aFloat);
                    bestWeight.put(destinationAirport, cost);
                    pathArray.put(destinationAirport, currentAirport);
                }
                /*
                if (!pq.contains(destinationAirport))
                    pq.add(destinationAirport);
                */
                if (marked.get(destinationAirport) == null || !marked.get(destinationAirport)) {
                    pq.add(destinationAirport);
                    marked.put(destinationAirport, true);
                }
            }

            //dequeue skal altid retunere lavest score
            //curNode = extractMinScore();
            currentAirport = (String) pq.poll();
            //if (curNode != dequeue) curNode = dequeue;
        }

        //skal ændres eller fjernes?

    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("best weights:\n");
        int iterator = 0;
        for (Map.Entry<String, Float> stringFloatEntry : bestWeight.entrySet()) {
            res.append(iterator);
            iterator++;
            res.append(": ");
            res.append(stringFloatEntry.getKey() + ": " + stringFloatEntry.getValue());
            res.append("\n");
        }

        res.append("path parents:\n");
        iterator = 0;
        for (Map.Entry<String, String> stringStringEntry : pathArray.entrySet()) {
            res.append(iterator);
            iterator++;
            res.append(": ");
            res.append(stringStringEntry.getKey());
            res.append("\n");
        }

        return res.toString();
    }
}
