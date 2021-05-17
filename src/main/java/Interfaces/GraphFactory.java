package Interfaces;

import Implementation.Aircraft;
import Implementation.Airline;
import Implementation.Airport;
import Implementation.Route;

import java.io.IOException;
import java.util.List;

public interface GraphFactory
{
	GraphBuilder getNewBuilder(int verticeCount);
	Graph readFromFile(String fileName) throws IOException;
	Graph readFromObjects(List<Aircraft> aircrafts, List<Airline> airlines, List<Airport> airports, List<Route> routes);
}
