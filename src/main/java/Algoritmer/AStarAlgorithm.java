package Algoritmer;

import Implementation.queue.Queue;
import Interfaces.AStarProblem;
import Interfaces.Edge;
import Interfaces.Graph;
import Interfaces.Heuristic;

import java.util.PriorityQueue;

public class AStarAlgorithm {
    private Graph graph;
    private int startNode;
    private int targetNode;
    private Heuristic heuristic;
    private boolean[] marked;
    int[] pathArray;
    float[] bestWeight;
    private Queue pq;

    public AStarAlgorithm(AStarProblem props) {
        this.graph = props.getGraph();
        this.startNode = props.getStartNode();
        this.targetNode = props.getTargetNode();
        this.heuristic = props.getHeuristic();
        pathArray = new int[graph.getVertiesCount()];

        for (int i = 0; i < pathArray.length; i++) {
            pathArray[i] = -1;
        }

        bestWeight = new float[graph.getVertiesCount()];
        for (int i = 0; i < bestWeight.length; i++) {
            bestWeight[i] = Float.MAX_VALUE;
        }

        marked = new boolean[graph.getVertiesCount()];
        for (int i = 0; i < marked.length; i++) {
            marked[i] = false;
        }
        int curNode = startNode;
        marked[startNode] = true;
        bestWeight[curNode] = 0;
        pq = new Queue();
        pq.enqueue(startNode);

        float bestWeigth =  this.heuristic.h(this.startNode, this.targetNode);

        while (!pq.isEmpty()) {
            var h = this.heuristic.h(curNode, this.targetNode);
            while(!pq.isEmpty()) pq.dequeue();

 //           System.out.println(curNode + " : currentnode" );
            for (Edge e : graph.adj(curNode )) {
                float cost = bestWeight[curNode] + e.getWeight();
                int toNode = e.to();
                if (cost < bestWeight[toNode]  ) {
                    System.out.println("cost: " + cost + " toNode: " + toNode);
                    bestWeight[toNode] = cost;
                    pathArray[toNode] = curNode;
                }
                if (!marked[toNode]) {
                    pq.enqueue(toNode);
                    marked[toNode] = true;
                }
            }
            curNode = (int) pq.dequeue();
        }
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
            res.append(" current node: ");
            res.append(pathArray[i]);
            res.append("\n");
        }

        return res.toString();
    }

}
