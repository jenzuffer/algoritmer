package Implementation;

import Implementation.edges.DirectedEdge;
import Implementation.edges.FlyRouteEdge;
import Interfaces.Edge;
import Interfaces.Graph;
import Interfaces.GraphBuilder;

import java.util.ArrayList;

public class GraphImpl implements Graph, GraphBuilder {
    private static final ArrayList<Edge> emptylist = new ArrayList<>(0);
    private ArrayList<Edge>[] array;
    private ArrayList<Edge> allEdges;

    public GraphImpl(int verticeCount) {
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
    public Iterable<Edge> adj(int v) {
        ArrayList<Edge> adjlist = array[v];
        if (adjlist == null) return emptylist;
        return array[v];
    }

    @Override
    public Iterable<Edge> edges() {
        return allEdges;
    }

    @Override
    public void addEdge(int v1, int v2, float weight) {
        Edge edge = new DirectedEdge(v1, v2, weight);
        allEdges.add(edge);
        helpaddtolist(v1 , edge);
    }
    private void helpaddtolist(int v, Edge e){
    ArrayList<Edge> list = array[v];
    if (list==null){
        list = new ArrayList<>();
        array[v] = list;
    }
    list.add(e);
    }
    @Override
    public Graph build() {
        return this;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append(getVertiesCount()).append('\n').append(' ').append(getEgdeCount()).append('\n');

        for (var e : edges()) {
            sb.append(e.from());
            sb.append(' ');
            sb.append(e.to());
            sb.append(' ');
            sb.append(e.getWeight());
            sb.append('\n');
        }

        return sb.toString();
    }
}
