package Algoritmer;

import Interfaces.AStarProblem;
import Interfaces.Graph;
import Interfaces.Heuristic;

import java.util.PriorityQueue;

public class AStarAlgorithm {
    private Graph graph;
    private int startNode;
    private int targetNode;
    private Heuristic heuristic;


    int[] pathArray;
    float[] bestWeight;
    private PriorityQueue pq;



    public AStarAlgorithm(AStarProblem props) {
        this.graph = props.getGraph();
        this.startNode =props.getStartNode();
        this.targetNode = props.getTargetNode();
        this.heuristic = props.getHeuristic();


    }


}
