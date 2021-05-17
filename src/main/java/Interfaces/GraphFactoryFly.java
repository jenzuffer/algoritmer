package Interfaces;

import Implementation.Aircraft;
import Implementation.Airline;
import Implementation.Airport;
import Implementation.Route;

import java.util.List;

public interface GraphFactoryFly {
    Graph readFromObjects(List<Aircraft> aircrafts, List<Airline> airlines, List<Airport> airports, List<Route> routes);
    GraphBuilder getNewBuilder(int verticeCount);
}
