package Algoritmer;


import Implementation.queue.Queue;
import Interfaces.Edge;
import Interfaces.Graph;

import java.util.*;

public class Dijkstra {
    int[] pathArray;
    float[] bestWeight;
    boolean[] marked;
    private Queue pq;

    public Dijkstra(Graph g, int startNode) {

        pathArray = new int[g.getVertiesCount()];
        for (int i = 0; i < pathArray.length; i++) {
            pathArray[i] = -1;
        }

        bestWeight = new float[g.getVertiesCount()];
        for (int i = 0; i < bestWeight.length; i++) {
            bestWeight[i] = Float.MAX_VALUE;
        }
        marked = new boolean[g.getVertiesCount()];
        for (int i = 0; i < marked.length; i++) {
            marked[i] = false;
        }
        int curNode = startNode;
        marked[startNode] = true;
        pathArray[startNode] = -1;
        bestWeight[curNode] = 0;
        pq = new Queue();
        pq.enqueue(startNode);

        while (!pq.isEmpty()) {
            float currentCost = bestWeight[curNode];
            //if (startNode == curNode) pq.dequeue();
            //System.out.println("curNode: " + curNode);
            for (Edge e : g.adj(curNode)) {
                float cost = currentCost + e.getWeight();
                int toNode = e.to();
                if (cost < bestWeight[toNode]) {
                    //System.out.println("cost: " + cost + " toNode: " + toNode);
                    bestWeight[toNode] = cost;
                    pathArray[toNode] = curNode;
                }
                if (!marked[toNode]) {
                    pq.enqueue(toNode);
                    marked[toNode] = true;
                }
            }

            //dequeue skal altid retunere lavest score
            //curNode = (int) pq.dequeue();
            curNode = extractMinScore();
            int dequeue = (int) pq.dequeue();
            if (curNode != dequeue) curNode = dequeue;
        }
    }

    private int extractMinScore() {
        int result = 0;
        float minWeight = Float.MAX_VALUE;
        for (Object i : pq) {
            int toNode = (int) i;
            if (bestWeight[toNode] < minWeight) {
                result = toNode;
                minWeight = bestWeight[toNode];
            }
        }
        return result;
    }


    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("best weights:\n");
        for (int i = 0; i < bestWeight.length; i++) {
            res.append(i);
            res.append(": ");
            res.append(bestWeight[i]);
            res.append("\n");
        }

        res.append("path parents:\n");
        for (int i = 0; i < pathArray.length; i++) {
            res.append(i);
            res.append(": ");
            res.append(pathArray[i]);
            res.append("\n");
        }

        return res.toString();
    }
}
