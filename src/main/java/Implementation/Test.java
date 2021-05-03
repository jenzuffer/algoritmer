package Implementation;

import Algoritmer.ExampleManhattenGraph;
import Algoritmer.ManhattanProblem;
import Interfaces.AStarProblem;
import Interfaces.Graph;

public class Test {
    public static void main(String[] args)
    {
        AStarProblem problem = new ManhattanProblem(new ExampleManhattenGraph());
        Graph g = problem.getGraph();
        System.out.println(g);
    }
}
