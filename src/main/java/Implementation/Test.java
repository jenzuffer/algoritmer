package Implementation;

import Algoritmer.ExampleManhattenGraph;
import Algoritmer.ManhattanProblem;
import Interfaces.AStarProblem;
import Interfaces.Graph;
import Interfaces.Heuristic;

public class Test {
    public static void main(String[] args)
    {
        ExampleManhattenGraph exampleManhattenGraph = new ExampleManhattenGraph();
        AStarProblem problem = new ManhattanProblem(exampleManhattenGraph);
        int startNode = problem.getStartNode();
        Heuristic heuristic = problem.getHeuristic();
        Graph g = problem.getGraph();
        System.out.println(g.toString());
    }
}
