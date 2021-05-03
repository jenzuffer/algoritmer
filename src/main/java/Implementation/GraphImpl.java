package Implementation;

import Interfaces.Edge;
import Interfaces.Graph;
import Interfaces.GraphBuilder;

import java.util.ArrayList;

public class GraphImpl implements Graph, GraphBuilder {
    private static final ArrayList<Edge> emptylist = new ArrayList<>(0);
    private ArrayList<Edge>[] array;
    private ArrayList<Edge> allEdges;

    public GraphImpl(int verticeCount){
        this.array = new ArrayList[verticeCount];
        allEdges = new ArrayList<>();
    }

    @Override
    public int V() {
        return array.length;
    }

    @Override
    public int E() {
        return allEdges.size();
    }

    @Override
    public Iterable<Edge> adj(int v) {
         ArrayList<Edge> adjlist = array[v];
         if (adjlist == null) return emptylist;
         return adjlist;
    }

    @Override
    public Iterable<Edge> edges() {
        return allEdges;
    }

    @Override
    public void addEdge(int v1, int v2, float weight) {

    }

    @Override
    public Graph build() {
        return null;
    }
}
