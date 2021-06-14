package Algoritmer;

import Interfaces.AStarProblem;
import Interfaces.Edge;
import Interfaces.Graph;
import Interfaces.Heuristic;
import org.apache.commons.lang3.tuple.Pair;


import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;


public class AStarAlgorithm {
    private Graph graph;
    private int startNode;
    private int targetNode;
    private Heuristic heuristic;
    private boolean[] marked;
    float[] bestWeight;
    private PriorityQueue<Pair<Integer, Float>> pQueue = new PriorityQueue<Pair<Integer, Float>>();
    int[] fromNodes;
    float[] travelcosts;

    public AStarAlgorithm(AStarProblem props) {
        this.graph = props.getGraph();
        this.startNode = props.getStartNode();
        this.targetNode = props.getTargetNode();
        this.heuristic = props.getHeuristic();
        fromNodes = new int[graph.getVertiesCount()];
        travelcosts = new float[graph.getVertiesCount()];

        bestWeight = new float[graph.getVertiesCount()];

        for (int i = 0; i < graph.getVertiesCount(); i++) {
            bestWeight[i] = Float.MAX_VALUE;
            fromNodes[i] = -1;
        }


        marked = new boolean[graph.getVertiesCount()];

        marked[startNode] = true;


        float bestWeigth = this.heuristic.h(this.startNode, this.targetNode);
        bestWeight[startNode] = bestWeigth;
        pQueue.add(Pair.of(startNode, bestWeight[startNode]));
        while (!pQueue.isEmpty()) {
            var currentNode = (int) pQueue.poll().getKey();
            for (Edge edge : graph.adj(currentNode)) {
                int toNode = edge.to();
                if (marked[toNode])
                    continue;
                if (toNode == targetNode)
                    return;
                marked[toNode] = true;
                fromNodes[toNode] = currentNode;
                var bestPossibleCostAfterToNode = this.heuristic.h(toNode, this.targetNode);
                travelcosts[toNode] = travelcosts[currentNode] + edge.getWeight();
                bestWeight[toNode] = travelcosts[toNode] + bestPossibleCostAfterToNode;
                pQueue.add(Pair.of(toNode, bestWeight[toNode]));
            }
        }

    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int node : fromNodes) {
            if (node != -1) {
                System.out.println(" node: " + node);
            }
        }


        return res.toString();
    }

    class com implements Comparator<Pair<Integer, Float>> {

        @Override
        public int compare(Pair<Integer, Float> o1, Pair<Integer, Float> o2) {
            float Value01 = o1.getValue();
            float Value02 = o2.getValue();
            if (Value01 > Value02) {
                return 1;
            } else if (Value01 < Value02) {
                return -1;
            }
            return 0;
        }
    }

}