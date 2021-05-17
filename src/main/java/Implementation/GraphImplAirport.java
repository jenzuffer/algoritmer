package Implementation;

import Implementation.dto.Aircraft;
import Implementation.dto.Airline;
import Implementation.dto.Airport;
import Implementation.edges.FlyRouteEdge;
import Interfaces.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphImplAirport implements GraphRoute, GraphBuilderRoute {
    private static final ArrayList<EdgeFly> emptylist = new ArrayList<>(0);
    private ArrayList<EdgeFly>[] array;
    private ArrayList<EdgeFly> allEdges;

    public GraphImplAirport(int verticeCount) {
        this.array = new ArrayList[verticeCount];
        allEdges = new ArrayList<>();
    }

    @Override
    public GraphRoute build() {
        return null;
    }

    @Override
    public void addEdge(Airport departure, Airport destination, double distance, String airlines_codes) {

    }

    @Override
    public int getVertiesCount() {
        return 0;
    }

    @Override
    public int getEgdeCount() {
        return 0;
    }

    @Override
    public Iterable<EdgeFly> adj(String code) {
        return null;
    }

    @Override
    public Iterable<EdgeFly> edges() {
        return null;
    }

    //airports = nodes
    //routes = edges

    /*
    @Override
    public GraphImplAirport readFromObjects(List<Aircraft> aircrafts, List<Airline> airlines, List<Airport> airports, List<Route> routes) {
        GraphBuilder builder = getNewBuilder(airports.size());
        HashMap<String, Airport> airportHashMap = new HashMap<>();
        for (Airport airport : airports){
            airportHashMap.put(airport.getCode(), airport);
        }
        for (Route route : routes) {
            String source_code = route.getSource_code();
            String destination_code = route.getDestination_code();
            Airport airport_source = airportHashMap.get(source_code);
            Airport airport_destination = airportHashMap.get(destination_code);
            double distance = route.getDistance();
            String airline_code = route.getAirline_code();


        }

    }

    @Override
    public int getVertiesCount() {
        return array.length;
    }

    @Override
    public int getEgdeCount() {
        return allEdges.size();
    }

    @Override
    public Iterable<EdgeFly> adj(String code) {
        ArrayList<EdgeFly> adjlist = array.;
        if (adjlist == null) return emptylist;
        return array[v];
    }

    @Override
    public Iterable<EdgeFly> edges() {
        return allEdges;
    }

    @Override
    public GraphRoute build() {
        return this;
    }

    @Override
    public void addEdge(Airport departure, Airport destination, double distance, String airlines_codes) {
        EdgeFly edgeFly = new FlyRouteEdge(departure, destination, distance, airlines_codes);
        allEdges.add(edgeFly);

    }

    private void helpaddtolist(int v, EdgeFly e) {
        ArrayList<EdgeFly> list = array[v];
        if (list == null) {
            list = new ArrayList<>();
            array[v] = list;
        }
        list.add(e);
    }

     */
}
