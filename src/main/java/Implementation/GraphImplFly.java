package Implementation;

import Implementation.edges.DirectedEdge;
import Implementation.edges.FlyRouteEdge;
import Interfaces.Edge;
import Interfaces.EdgeFly;
import Interfaces.GraphBuilderRoute;
import Interfaces.GraphRoute;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphImplFly implements GraphRoute, GraphBuilderRoute {

    private static final ArrayList<EdgeFly> emptylist = new ArrayList<>(0);
    private HashMap<String, EdgeFly> array;
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
    public void addEdge(Airport departure, Airport destination, double distance, String airlines_codes) {
        EdgeFly edgeFly = new FlyRouteEdge(departure, destination, distance, airlines_codes);
        allEdges.add(edgeFly);
        helpaddtolist(departure.getCode(), edgeFly);
    }

    private void helpaddtolist(String code, EdgeFly e) {
        EdgeFly edgeFly = array.get(code);
        if (edgeFly == null) {
            edgeFly = new FlyRouteEdge(e.getDepartedAirport(), e.getDestinationAirport(), );
            array[v] = list;
        }
        list.add(e);
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
    public Iterable<EdgeFly> adj(int v) {
        ArrayList<EdgeFly> adjlist = array[v];
        if (adjlist == null) return emptylist;
        return array[v];
    }

    @Override
    public Iterable<EdgeFly> edges() {
        return allEdges;
    }
}
