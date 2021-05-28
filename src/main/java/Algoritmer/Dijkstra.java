package Algoritmer;



import Interfaces.EdgeFly;

import Interfaces.GraphRoute;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dijkstra {
    //private int[] pathArray;
    private LinkedHashMap<String, Float> bestWeight;
    //private float[] bestWeight;
    private LinkedHashMap<String, String> pathArray;
    private HashMap<String, Boolean> marked;
    private PriorityQueue pq;
    private boolean reachedTargetAirpor;
    private LinkedHashMap<String, Float> shortestPathMap;

    public boolean isReachedTargetAirpor() {
        return reachedTargetAirpor;
    }

    public Dijkstra(GraphRoute g, String departAirport, String targetAirport) {

        pathArray = new LinkedHashMap(g.getVertiesCount());
        shortestPathMap = new LinkedHashMap<>(g.getVertiesCount());
        bestWeight = new LinkedHashMap(g.getVertiesCount());
        reachedTargetAirpor = false;
        this.marked = new HashMap<>(g.getVertiesCount());
        marked.put(departAirport, true);
        String currentAirport = departAirport;

        pathArray.put(departAirport, departAirport);
        bestWeight.put(currentAirport, (float) 0);
        pq = new PriorityQueue();
        pq.add(departAirport);

        while (!pq.isEmpty()) {
            //pq.remove(currentAirport);
            currentAirport = (String) pq.poll();
            float currentCost = bestWeight.get(currentAirport);
            //System.out.println("currentAirport: " + currentAirport);
            for (EdgeFly edgeFly : g.adj(currentAirport)) {
                float cost = (float) (currentCost + edgeFly.getDistance());
                String destinationAirport = edgeFly.getDestinationAirport().getCode();
                float aFloat = bestWeight.getOrDefault(destinationAirport, Float.MAX_VALUE);
                if (cost < aFloat) {
                    /*System.out.println(" destinationAirport: " + destinationAirport + " with cost: " + cost +
                            " aFloat: " + aFloat);*/
                    bestWeight.put(destinationAirport, cost);
                    pathArray.put(destinationAirport, currentAirport);
                }
                /*
                if (!pq.contains(destinationAirport))
                    pq.add(destinationAirport);
                */
                if (marked.get(destinationAirport) == null || !marked.get(destinationAirport)) {
                    //System.out.println("marked: " + destinationAirport);
                    pq.add(destinationAirport);
                    marked.put(destinationAirport, true);
                }
            }


            if (targetAirport.equals(currentAirport)) {
                System.out.println("Reached target airport \n \n");
                shortestPathMap.put(currentAirport, bestWeight.get(currentAirport));
                String previousAirport = pathArray.get(currentAirport);
                while (!previousAirport.equals(departAirport)){
                    shortestPathMap.put(previousAirport, bestWeight.get(previousAirport));
                    previousAirport = pathArray.get(previousAirport);
                }
                shortestPathMap.put(departAirport, bestWeight.get(departAirport));
                reachedTargetAirpor = true;
            }
        }

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

    public void displayShortestRoute(String departAirport, String destinationAirport) {
        int iterator = shortestPathMap.size();
        for (Map.Entry<String, Float> stringFloatEntry : shortestPathMap.entrySet()) {
            System.out.println(iterator + ": " + stringFloatEntry.getKey() + ": " + stringFloatEntry.getValue());
            iterator--;
        }
    }
}
