package Algoritmer;

import Implementation.queue.IndexMinPQ;
import Implementation.queue.Queue;
import Interfaces.Edge;
import Interfaces.Graph;


//copy from the book and sligthy modified to fit our code
public class PrimMST {
    private static final Float FLOATING_POINT_EPSILON = 1E-12f;

    private Edge[] edgeTo;        // edgeTo[v] = shortest edge from tree vertex to non-tree vertex
    private float[] distTo;      // distTo[v] = weight of shortest such edge
    private boolean[] marked;     // marked[v] = true if v on tree, false otherwise
    private IndexMinPQ<Float> pq;

    /**
     * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
     * @param graph the edge-weighted graph
     */
    public PrimMST(Graph graph) {
        edgeTo = new Edge[graph.getVertiesCount()];
        distTo = new float[graph.getVertiesCount()];
        marked = new boolean[graph.getVertiesCount()];
        pq = new IndexMinPQ<Float>(graph.getEgdeCount());
        for (int v = 0; v < graph.getVertiesCount(); v++)
            distTo[v] = Float.POSITIVE_INFINITY;

        for (int v = 0; v < graph.getVertiesCount(); v++)      // run from each vertex to find
            if (!marked[v]) prim(graph, v);      // minimum spanning forest

        // check optimality conditions
        assert check(graph);
    }

    // run Prim's algorithm in graph G, starting from vertex s
    private void prim(Graph G, int s) {
        distTo[s] = 0.0f;
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            scan(G, v);
        }
    }

    // scan vertex v
    private void scan(Graph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.to();
            if (marked[w]) continue;         // v-w is obsolete edge
            if (e.getWeight() < distTo[w]) {
                distTo[w] = e.getWeight();
                edgeTo[w] = e;
                if (pq.contains(w)) pq.decreaseKey(w, distTo[w]);
                else                pq.insert(w, distTo[w]);
            }
        }
    }

    /**
     * Returns the edges in a minimum spanning tree (or forest).
     * @return the edges in a minimum spanning tree (or forest) as
     *    an iterable of edges
     */
    public Iterable<Edge> edges() {
        Queue<Edge> mst = new Queue<Edge>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if (e != null) {
                mst.enqueue(e);
            }
        }
        return mst;
    }

    /**
     * Returns the sum of the edge weights in a minimum spanning tree (or forest).
     * @return the sum of the edge weights in a minimum spanning tree (or forest)
     */
    public double weight() {
        double weight = 0.0;
        for (Edge e : edges())
            weight += e.getWeight();
        return weight;
    }


    // check optimality conditions (takes time proportional to E V lg* V)
    private boolean check(Graph G) {

        // check weight
        double totalWeight = 0.0;
        for (Edge e : edges()) {
            totalWeight += e.getWeight();
        }
        if (Math.abs(totalWeight - weight()) > FLOATING_POINT_EPSILON) {
            System.err.printf("Weight of edges does not equal weight(): %f vs. %f\n", totalWeight, weight());
            return false;
        }

        // check that it is acyclic
        UnionFinder uf = new UnionFinder(G.getVertiesCount());
        for (Edge e : edges()) {
            int v = e.from(), w = e.to();
            if (uf.find(v) == uf.find(w)) {
                System.err.println("Not a forest");
                return false;
            }
            uf.union(v, w);
        }

        // check that it is a spanning forest
        for (Edge e : G.edges()) {
            int v = e.from(), w = e.to();
            if (uf.find(v) != uf.find(w)) {
                System.err.println("Not a spanning forest");
                return false;
            }
        }

        // check that it is a minimal spanning forest (cut optimality conditions)
        for (Edge e : edges()) {

            // all edges in MST except e
            uf = new UnionFinder(G.getVertiesCount());
            for (Edge f : edges()) {
                int x = f.from(), y = f.to();
                if (f != e) uf.union(x, y);
            }

            // check that e is min weight edge in crossing cut
            for (Edge f : G.edges()) {
                int x = f.from(), y = f.to();
                if (uf.find(x) != uf.find(y)) {
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
