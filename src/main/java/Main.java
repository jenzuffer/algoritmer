import Algoritmer.*;
import Implementation.*;
import Implementation.dto.Aircraft;
import Implementation.dto.Airline;
import Implementation.dto.Airport;
import Implementation.utilities.FileReaderImpl;
import Interfaces.*;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        /*
        Graph graph1 = new GraphFactoryImpl().readFromFile("src/main/resources/graph2.txt");


        var ls3 = new PrimMST(graph1);
        System.out.println(ls3.edges() + " " + ls3.weight());

        var ls2 = new KruskalMST(graph1);
        System.out.println(ls2.edges() + " " + ls2.weight());
        */

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

        String departAirport = "HEH";
        String destinationAirport = "MYT";
        String airline = "W9";

        GraphRoute graphRoute = new GraphFactoryImplFly().readFromObjects(aircraftList, airlines, airports, routes, airline);
        System.out.println("BFS:");
        BFS bfs = new BFS(graphRoute, departAirport, destinationAirport);
        System.out.println("next");
        destinationAirport = "PBU";
        departAirport = "AKY";
        bfs = new BFS(graphRoute, departAirport, destinationAirport);


        System.out.println("DFS:");
        departAirport = "HEH";
        destinationAirport = "MYT";
        DFS dfs = new DFS(graphRoute, departAirport, destinationAirport);
        System.out.println("\n\n\nnext\n\n\n");
        destinationAirport = "PBU";
        departAirport = "AKY";
        dfs = new DFS(graphRoute, departAirport, destinationAirport);

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
