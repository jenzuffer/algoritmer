package Implementation;

import Algoritmer.AStarAlgorithm;
import Algoritmer.ExampleManhattenGraph;
import Algoritmer.ManhattanProblem;
import Interfaces.AStarProblem;
import Interfaces.Graph;
import Interfaces.Heuristic;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        // ExampleManhattenGraph exampleManhattenGraph = new ExampleManhattenGraph();

        var maze = new MazeMapFromFile("src/main/resources/simpleMaze.txt");


        AStarProblem problem = new ManhattanProblem(maze);
        var ser  =new AStarAlgorithm(problem);
        System.out.println(ser);


    }

}
