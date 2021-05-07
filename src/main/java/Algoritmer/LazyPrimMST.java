package Algoritmer;


import Implementation.queue.MinPQ;
import Implementation.queue.Queue;
import Interfaces.Edge;
import Interfaces.Graph;

//https://algs4.cs.princeton.edu/43mst/
public class LazyPrimMST {

    private static final Float FLOATING_POINT_EPSILON = 1E-12f;

    private float weight;       // total weight of MST
    private Queue<Edge> mst;     // edges in the MST
    private boolean[] marked;    // marked[v] = true iff v on tree
    private MinPQ<Edge> pq;      // edges with one endpoint in tree

    /**
     * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
     *
     * @param G the edge-weighted graph
     */
    public LazyPrimMST(Graph G) {
        mst = new Queue<Edge>();
        pq = new MinPQ<Edge>();
        marked = new boolean[G.getVertiesCount()];
        for (int v = 0; v < G.getVertiesCount(); v++)     // run Prim from all vertices to
            if (!marked[v]) prim(G, v);     // get a minimum spanning forest

        // check optimality conditions
        assert check(G);
    }

    // run Prim's algorithm
    private void prim(Graph G, int s) {
        scan(G, s);
        while (!pq.isEmpty()) {                        // better to stop when mst has V-1 edges
            Edge e = pq.delMin();                      // smallest edge on pq
            int v = e.from(), w = e.to();               // two endpoints
            assert marked[v] || marked[w];
            if (marked[v] && marked[w]) continue;      // lazy, both v and w already scanned
            mst.enqueue(e);                            // add e to MST
            weight += e.getWeight();
            if (!marked[v]) scan(G, v);               // v becomes part of tree
            if (!marked[w]) scan(G, w);               // w becomes part of tree
        }
    }

    // add all edges e incident to v onto pq if the other endpoint has not yet been scanned
    private void scan(Graph G, int v) {
        assert !marked[v];
        marked[v] = true;
        for (Edge e : G.adj(v))
            if (!marked[e.to()]) pq.insert(e);
    }


    public Iterable<Edge> edges() {
        return mst;
    }


    public float weight() {
        return weight;
    }


    private boolean check(Graph G) {

        float totalWeight = 0.0f;
        for (Edge e : edges()) {
            totalWeight += e.getWeight();
        }
        if (Math.abs(totalWeight - weight()) > FLOATING_POINT_EPSILON) {
            System.err.printf("Weight of edges does not equal weight(): %f vs. %f\n", totalWeight, weight());
            return false;
        }

        // check that it is acyclic
        UnionFinder unionFinder = new UnionFinder(G.getVertiesCount());
        for (Edge e : edges()) {
            int v = e.from(), w = e.to();
            if (unionFinder.find(v) == unionFinder.find(w)) {
                System.err.println("Not a forest");
                return false;
            }
            unionFinder.union(v, w);
        }

        // check that it is a spanning forest
        for (Edge e : G.edges()) {
            int v = e.from(), w = e.to();
            if (unionFinder.find(v) != unionFinder.find(w)) {
                System.err.println("Not a spanning forest");
                return false;
            }
        }

        // check that it is a minimal spanning forest (cut optimality conditions)
        for (Edge e : edges()) {

            // all edges in MST except e
            unionFinder = new UnionFinder(G.getVertiesCount());
            for (Edge f : mst) {
                int x = f.from(), y = f.to();
                if (f != e) unionFinder.union(x, y);
            }

            // check that e is min weight edge in crossing cut
            for (Edge f : G.edges()) {
                int x = f.from(), y = f.to();
                if (unionFinder.find(x) != unionFinder.find(y)) {
                    if (f.getWeight() < e.getWeight()) {
                        System.err.println("Edge " + f + " violates cut optimality conditions");
                        return false;
                    }
                }
            }

        }

        return true;
    }

}
