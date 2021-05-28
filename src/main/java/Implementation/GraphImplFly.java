package Implementation;

import Implementation.dto.Airport;
import Implementation.edges.FlyRouteEdge;
import Interfaces.EdgeFly;
import Interfaces.GraphBuilderRoute;
import Interfaces.GraphRoute;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphImplFly implements GraphRoute, GraphBuilderRoute {

    private static final ArrayList<EdgeFly> emptylist = new ArrayList<>(0);
    private HashMap<String, ArrayList<EdgeFly>> array;
    private ArrayList<EdgeFly> allEdges;

    public GraphImplFly(int verticeCount) {
        this.array = new HashMap(verticeCount);
        allEdges = new ArrayList<>();
    }

    @Override
    public GraphRoute build() {
        return this;
    }

    @Override
    public void addEdge(Airport departure, Airport destination, double distance, String airlines_codes, float time) {
        EdgeFly edgeFly = new FlyRouteEdge(departure, destination, distance, airlines_codes, time);
        allEdges.add(edgeFly);
        helpaddtolist(departure.getCode(), edgeFly);
        //addEdge departure.getCode(): THL destination.getCode(): HEH
        //addEdge departure.getCode(): HEH destination.getCode(): MDL
        //addEdge departure.getCode(): MDL destination.getCode(): MYT
    }

    private void helpaddtolist(String code, EdgeFly e) {
        ArrayList<EdgeFly> edgeFlies = array.get(code);
        if (edgeFlies == null) {
            edgeFlies = new ArrayList<>();
        }
        edgeFlies.add(e);
        array.put(code, edgeFlies);
    }

    @Override
    public int getVertiesCount() {
        return array.size();
    }

    @Override
    public int getEgdeCount() {
        return allEdges.size();
    }

    @Override
    public Iterable<EdgeFly> adj(String code) {
        ArrayList<EdgeFly> adjlist = array.get(code);
        if (adjlist == null) return emptylist;
        //System.out.println("called adj in graphimpfly with code: " + code + " adjlist size: " + adjlist.size());
        for (EdgeFly edgefly : adjlist) {
            //System.out.println("going to " + edgefly.getDestinationAirport().getCode());
        }
        return adjlist;
    }

    @Override
    public Iterable<EdgeFly> edges() {
        return allEdges;
    }
}
