package Implementation;

import Algoritmer.ExampleManhattenGraph;
import Algoritmer.ManhattanProblem;
import Interfaces.AStarProblem;
import Interfaces.Graph;
import Interfaces.Heuristic;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        ExampleManhattenGraph exampleManhattenGraph = new ExampleManhattenGraph();

        var maze = new MazeMapFromFile("src/main/resources/astarfile.txt");

        /*
        AStarProblem problem = new ManhattanProblem(exampleManhattenGraph);
        int startNode = problem.getStartNode();
        Heuristic heuristic = problem.getHeuristic();
        Graph g = problem.getGraph();
        System.out.println(g.toString());
    */
    }

}
