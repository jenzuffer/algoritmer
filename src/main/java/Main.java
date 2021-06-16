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


        FileReaderImpl fileReader = new FileReaderImpl();
        String path = "src\\main\\resources\\aircrafts.csv";
        List<Aircraft> aircraftList = fileReader.getAircrafts(path);
        path = "src\\main\\resources\\airlines.csv";
        List<Airline> airlines = fileReader.getAirlines(path);
        path = "src\\main\\resources\\airports.csv";
        List<Airport> airports = fileReader.getAirports(path);
        path = "src\\main\\resources\\routes.csv";
        List<Route> routes = fileReader.getRoutes(path);


        //GraphFactoryImplFly.java (28l) //if (!airline_code.equals(airline)) continue; decides if one airline or many
        String airline = "W9";

        GraphRoute graphRoute = new GraphFactoryImplFly().readFromObjects(aircraftList, airlines, airports, routes, airline);


        String destinationAirport = "PBU";
        String departAirport = "AKY";

        System.out.println("from " + departAirport + " to " + destinationAirport);
        Dijkstra dijkstra = new Dijkstra(graphRoute, departAirport, destinationAirport);
        if (dijkstra.isReachedTargetAirpor()) {
            dijkstra.displayShortestRoute(departAirport, destinationAirport);
        } else {
            System.out.println("no connecting flights");
        }
        System.out.println(dijkstra.toString());

        departAirport = "SCO";
        destinationAirport = "SZA";
        System.out.println("from " + departAirport + " to " + destinationAirport);
        dijkstra = new Dijkstra(graphRoute, departAirport, destinationAirport);
        if (dijkstra.isReachedTargetAirpor()) {
            dijkstra.displayShortestRoute(departAirport, destinationAirport);
        } else {
            System.out.println("no connecting flights");
        }
        System.out.println(dijkstra.toString());


        System.out.println("astar: ");
        //ManhattanGraph manhattanGraph = new MazeMapFromFile();
        var maze = new MazeMapFromFile("src/main/resources/simpleMaze.txt");
        //MazeMapFromFile mazeMapFromFile = new MazeMapFromFile("src/main/resources/problemB.txt");
        AStarProblem problem = new ManhattanProblem(maze);
        var ser = new AStarAlgorithm(problem);
        //System.out.println(ser.toString());
        System.out.println(ser);

        System.out.println("DFS from " + departAirport + " to " + destinationAirport);
        new DFS(graphRoute, departAirport, destinationAirport);
        System.out.println("\n\n\n\n\n\n\n\nBFS from " + departAirport + " to " + destinationAirport);
        new BFS(graphRoute, departAirport, destinationAirport);
    }
}
