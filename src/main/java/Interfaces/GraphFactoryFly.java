package Interfaces;

import Implementation.dto.Aircraft;
import Implementation.dto.Airline;
import Implementation.dto.Airport;
import Implementation.Route;

import java.util.List;

public interface GraphFactoryFly {
    GraphRoute readFromObjects(List<Aircraft> aircrafts, List<Airline> airlines, List<Airport> airports, List<Route> routes);
    GraphBuilderRoute getNewBuilder(int verticeCount);
}
