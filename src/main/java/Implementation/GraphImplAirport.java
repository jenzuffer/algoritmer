package Implementation;

import Interfaces.*;

import java.util.ArrayList;

public class GraphImplAirport implements GraphRoute, GraphBuilderRoute {
    private static final ArrayList<EdgeFly> emptylist = new ArrayList<>(0);
    private ArrayList<EdgeFly>[] array;
    private ArrayList<EdgeFly> allEdges;

    public GraphImplAirport(int verticeCount) {
        this.array = new ArrayList[verticeCount];
        allEdges = new ArrayList<>();
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

    @Override
    public GraphRoute build() {
        return this;
    }

    @Override
    public void addEdge(Airport departure, Airport destination, double distance, String airlines_codes) {

    }
}
