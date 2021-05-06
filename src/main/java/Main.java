import Algoritmer.*;
import Implementation.GraphFactoryImpl;
import Implementation.edges.EdgeImpl;
import Interfaces.Edge;
import Interfaces.Graph;
import Interfaces.GraphBuilder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        EdgeImpl edgeimpl = new EdgeImpl(0, 5, 14);
        GraphBuilder newBuilder = new GraphFactoryImpl().getNewBuilder(8);
        Graph build = newBuilder.build();

        Graph graph1 = new GraphFactoryImpl().readFromFile("notes.txt");
        LazyPrimMST lazyPrimMST = new LazyPrimMST(graph1);
        KruskalMST kruskalMST = new KruskalMST(graph1);
        Dijkstra dijkstra = new Dijkstra(graph1, 0);
        ExampleManhattenGraph exampleManhattenGraph = new ExampleManhattenGraph();
        ManhattanProblem manhattanProblem = new ManhattanProblem(exampleManhattenGraph);
        UnionFinder unionFinder = new UnionFinder(10);

        for (Edge edge1 : lazyPrimMST.edges()) {
            System.out.println(edge1);
        }
        for (Edge edge : kruskalMST.edges()) {
            System.out.println(edge);
        }



/*
        EdgeWeightedDigraph factory = new EdgeWeightedDigraph(edgeWeightedGraph);
        Dijkstra2 dijkstra2 = new Dijkstra2(factory, 0);

        System.out.println(dijkstra2);


        Heuristicclass heuristicclass = new Heuristicclass();
        Graph graph = new GraphImplementation();

        AstarProblem aproblem = new Aproblem(graph, 0, 5, heuristicclass);

        AStarAlgorithm aStarAlgorithm = new AStarAlgorithm(aproblem);

    }

 */
    }
}
