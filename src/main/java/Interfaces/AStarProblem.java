package Interfaces;

public interface AStarProblem {
    Graph getGraph();
    int getStartNode();
    int getTargetNode();
    Heuristic getHeuristic();
}
