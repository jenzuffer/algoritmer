import Algoritmer.*;
import Implementation.*;
import Implementation.edges.EdgeImpl;
import Implementation.utilities.FileReaderImpl;
import Interfaces.AStarProblem;
import Interfaces.Edge;
import Interfaces.Graph;
import Interfaces.GraphBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        Graph graph1 = new GraphFactoryImpl().readFromFile("src/main/resources/graph2.txt");


        var ls3 = new PrimMST(graph1);
        System.out.println(ls3.edges() + " " + ls3.weight());

        var ls2 = new KruskalMST(graph1);
        System.out.println(ls2.edges() + " " + ls2.weight());


        // LazyPrimMST lazyPrimMST = new LazyPrimMST(graph1);
        //KruskalMST kruskalMST = new KruskalMST(graph1);
        //Dijkstra dijkstra = new Dijkstra(graph1, 0);
        //System.out.println(dijkstra);



        FileReaderImpl fileReader = new FileReaderImpl();
        String path = "src\\main\\resources\\aircrafts.csv";
        List<Aircraft> aircraftList = fileReader.getAircrafts(path);
        path = "src\\main\\resources\\airlines.csv";
        List<Airline> airlines = fileReader.getAirlines(path);
        path = "src\\main\\resources\\airports.csv";
        List<Airport> airports = fileReader.getAirports(path);
        path = "src\\main\\resources\\routes.csv";
        List<Route> routes = fileReader.getRoutes(path);

        String departAirport = "HFN";
        String destinationAirport = "HGU";
        String airline = "W9";


        BFS bfs = new BFS(graph1, 0);
        DFS dfs = new DFS(graph1, 0);
        new GraphFactory().readFromObjects(aircraftList, airlines, airports, routes);


        /*
        System.out.println("aircrafts");
        for (Aircraft aircraft : aircraftList) {
            System.out.println(aircraft);
        }
        System.out.println("airlines");
        for (Airline airline : airlines) {
            System.out.println(airline);
        }
        System.out.println("airports");
        for (Airport airport : airports) {
            System.out.println(airport);
        }
        System.out.println("routes");
        for (Route route : routes) {
            System.out.println(route);
        }
        */
        /*
        System.out.println("Manhatten Astar \n");
        ExampleManhattenGraph exampleManhattenGraph = new ExampleManhattenGraph();
        ManhattanProblem manhattanProblem = new ManhattanProblem(exampleManhattenGraph);
        AStarAlgorithm aStarAlgorithm = new AStarAlgorithm(manhattanProblem);
        System.out.println(aStarAlgorithm);
        */


        // UnionFinder unionFinder = new UnionFinder(10);
/*
        for (Edge edge1 : lazyPrimMST.edges()) {
            System.out.println(edge1);
        }
        for (Edge edge : kruskalMST.edges()) {
            System.out.println(edge);
        }

*/

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
