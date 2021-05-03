package Algoritmer;

import Interfaces.AStarProblem;
import Interfaces.Graph;
import Interfaces.Heuristic;
import Interfaces.ManhattanGraph;

public class ManhattanProblem implements AStarProblem, Heuristic {
    private ManhattanGraph mg;
    private Graph graph;
    private Node[] nodes;
    private int startNode;
    private int targetNode;

    public ManhattanProblem(ManhattanGraph mg)
    {
        Map<Node, Integer> nodeMap = new HashMap<>();
        this.mg = mg;
        int nodeCount = 0;
        startNode = -1;
        targetNode = -1;
        for (int y = 0; y < mg.height(); ++y)
        {
            for (int x = 0; x < mg.width(); ++x)
            {
                switch (mg.get(x, y))
                {
                    case ManhattanGraph.EMPTY:
                        ++nodeCount;
                        break;
                    case ManhattanGraph.GOAL:
                        if (startNode != -1)
                        {
                            throw new RuntimeException("There can be only one startNode node!");
                        }
                        startNode = nodeCount++;
                        break;
                    case ManhattanGraph.TARGET:
                        if (targetNode != -1)
                        {
                            throw new RuntimeException("There can be only one targetNode node!");
                        }
                        targetNode = nodeCount++;
                        break;
                    case ManhattanGraph.WALL:
                        break;
                    default:
                        throw new RuntimeException("Unknown value: " + mg.get(x, y));
                }

            }
        }
        if (startNode == -1)
        {
            throw new RuntimeException("There is no startNode node");
        }
        if (targetNode == -1)
        {
            throw new RuntimeException("There is no targetNode node");
        }
        nodes = new Node[nodeCount];
        nodeCount = 0;
        for (int y = 0; y < mg.height(); ++y)
        {
            for (int x = 0; x < mg.width(); ++x)
            {
                switch (mg.get(x, y))
                {
                    case ManhattanGraph.EMPTY:
                    case ManhattanGraph.GOAL:
                    case ManhattanGraph.TARGET:
                        nodes[nodeCount] = new Node(x, y);
                        nodeMap.put(nodes[nodeCount],nodeCount);
                        ++nodeCount;
                        break;
                }

            }
        }

        //Build the graph
        GraphBuilder gb = new GraphFactoryImpl().getNewBuilder(nodes.length);
        for (int y = 0; y < mg.height(); ++y)
        {
            for (int x = 0; x < mg.width(); ++x)
            {
                if (mg.get(x, y) != ManhattanGraph.WALL)
                {
                    int v1 = nodeMap.get(new Node(x, y));
                    //Left
                    if (x > 0 && mg.get(x - 1, y) != ManhattanGraph.WALL)
                    {
                        int v2 = nodeMap.get(new Node(x - 1, y));
                        gb.addEdge(v1, v2, 1.0f);
                    }
                    //Right
                    if (x < mg.width()-1 && mg.get(x + 1, y) != ManhattanGraph.WALL)
}
