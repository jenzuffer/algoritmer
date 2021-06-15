package Algoritmer;


import Interfaces.EdgeFly;

import Interfaces.GraphRoute;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dijkstra {
    //private int[] pathArray;
    private LinkedHashMap<String, Float> bestWeight;
    private LinkedHashMap<String, Float> bestWeightTime;
    //get(), put(), contains() = O(1)
    private LinkedHashMap<String, String> pathArray;
    private LinkedHashMap<String, String> pathArrayTime;
    private HashMap<String, Boolean> marked;
    private PriorityQueue pq;
    private boolean reachedTargetAirpor;
    private LinkedHashMap<String, Float> shortestPathMap;
    private LinkedHashMap<String, Float> shortestPathMapTime;
    private String depature;

    public boolean isReachedTargetAirpor() {
        return reachedTargetAirpor;
    }

    public Dijkstra(GraphRoute g, String departAirport, String targetAirport) {
        depature = departAirport;
        pathArray = new LinkedHashMap(g.getVertiesCount());
        pathArrayTime = new LinkedHashMap<>(g.getVertiesCount());
        shortestPathMap = new LinkedHashMap<>(g.getVertiesCount());
        shortestPathMapTime = new LinkedHashMap<>(g.getVertiesCount());
        bestWeight = new LinkedHashMap(g.getVertiesCount());
        bestWeightTime = new LinkedHashMap<>(g.getVertiesCount());
        reachedTargetAirpor = false;
        this.marked = new HashMap<>(g.getVertiesCount());
        marked.put(departAirport, true);
        String currentAirport = departAirport;

        pathArrayTime.put(departAirport, departAirport);
        pathArray.put(departAirport, departAirport);
        bestWeight.put(currentAirport, (float) 0);
        bestWeightTime.put(currentAirport, 0.0f);
        pq = new PriorityQueue();
        pq.add(departAirport);

        while (!pq.isEmpty()) {
            //pq.remove(currentAirport);
            currentAirport = (String) pq.poll();
            float currentCost = bestWeight.get(currentAirport);
            Float currenotCostTime = bestWeightTime.get(currentAirport);
            //System.out.println("currentAirport: " + currentAirport);
            for (EdgeFly edgeFly : g.adj(currentAirport)) {
                float cost = (float) (currentCost + edgeFly.getDistance());
                String destinationAirport = edgeFly.getDestinationAirport().getCode();
                float costtime = currenotCostTime + edgeFly.getTime();
                float aFloat = bestWeight.getOrDefault(destinationAirport, Float.MAX_VALUE);
                Float aFloat1 = bestWeightTime.getOrDefault(destinationAirport, Float.MAX_VALUE);
                if (cost < aFloat) {
                    bestWeight.put(destinationAirport, cost);
                    pathArray.put(destinationAirport, currentAirport);
                }
                if (costtime < aFloat1) {
                    bestWeightTime.put(destinationAirport, costtime);
                    pathArrayTime.put(destinationAirport, currentAirport);
                }

                if (marked.get(destinationAirport) == null || !marked.get(destinationAirport)) {
                    pq.add(destinationAirport);
                    marked.put(destinationAirport, true);
                }
            }
            if (targetAirport.equals(currentAirport)) {
                System.out.println("Reached target airport \n");
                //placer ind i linked hashmap (key = endAirport, value = bedste float værdi fra bestWeight til reaching airport)
                shortestPathMap.put(currentAirport, bestWeight.get(currentAirport));
                shortestPathMapTime.put(currentAirport, bestWeightTime.get(currentAirport));
                String previousAirport = pathArray.get(currentAirport);
                String previousAirportTime = pathArrayTime.get(currentAirport);
                //bestWeight && bestWeightTime opdateres hver gang hvis der findes en bedre værdi på lufthavnene
                while (!previousAirport.equals(departAirport)) {
                    shortestPathMap.put(previousAirport, bestWeight.get(previousAirport));
                    previousAirport = pathArray.get(previousAirport);
                }
                while (!previousAirportTime.equals(departAirport)) {
                    shortestPathMapTime.put(previousAirportTime, bestWeightTime.get(previousAirportTime));
                    previousAirportTime = pathArrayTime.get(previousAirportTime); //departAirport
                }


                shortestPathMap.put(departAirport, bestWeight.get(departAirport));
                shortestPathMapTime.put(departAirport, bestWeightTime.get(departAirport));
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
            res.append(" route: " + stringFloatEntry.getKey());
            String s = stringFloatEntry.getKey();
            while (!s.equals(depature)) {
                s = pathArray.get(s);
                res.append(" <- " + s);
            }
            res.append(" distance: " + stringFloatEntry.getValue());
            res.append("\n");
        }

        return res.toString();
    }

    public void displayShortestRoute(String departAirport, String destinationAirport) {
        int iterator = shortestPathMap.size();
        System.out.println("shortest route by Distance");
        for (Map.Entry<String, Float> stringFloatEntry : shortestPathMap.entrySet()) {
            System.out.println(iterator + ": " + stringFloatEntry.getKey() + ": " + stringFloatEntry.getValue());
            iterator--;
        }

        iterator = shortestPathMapTime.size();
        System.out.println("shortest route by time");
        for (Map.Entry<String, Float> stringFloatEntry : shortestPathMapTime.entrySet()) {
            System.out.println(iterator + ": " + stringFloatEntry.getKey() + ": " + stringFloatEntry.getValue());
            iterator--;
        }
    }
}
