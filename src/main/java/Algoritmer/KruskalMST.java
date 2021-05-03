package Algoritmer;

import Implementation.queue.Queue;
import Interfaces.Edge;
import Interfaces.Graph;

import java.util.Arrays;

public class KruskalMST {

    private static final double FLOATING_POINT_EPSILON = 1E-12;
    private double weight;                        // weight of MST
    private Queue<Edge> mst = new Queue<Edge>();  // edges in MST

    /**
     * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
     *
     * @param G the edge-weighted graph
     */
    public KruskalMST(Graph G) {

        // create array of edges, sorted by weight
        Edge[] edges = new Edge[G.getEgdeCount()];
        int t = 0;
        for (Edge e : G.edges()) {
            edges[t++] = e;
        }
        Arrays.sort(edges);

        // run greedy algorithm
        UnionFinder unionFinder = new UnionFinder(G.getVertiesCount());
        for (int i = 0; i < G.getEgdeCount() && mst.size() < G.getVertiesCount() - 1; i++) {
            Edge e = edges[i];
            int v = e.from();
            int w = e.to();

            // v-w does not create a cycle
            if (unionFinder.find(v) != unionFinder.find(w)) {
                unionFinder.union(v, w);     // merge v and w components
                mst.enqueue(e);     // add edge e to mst
                weight += e.getWeight();
            }
        }

        // check optimality conditions
        assert check(G);
    }

    /**
     * Returns the edges in a minimum spanning tree (or forest).
     *
     * @return the edges in a minimum spanning tree (or forest) as
     * an iterable of edges
     */
    public Iterable<Edge> edges() {
        return mst;
    }

    /**
     * Returns the sum of the edge weights in a minimum spanning tree (or forest).
     *
     * @return the sum of the edge weights in a minimum spanning tree (or forest)
     */
    public double weight() {
        return weight;
    }

    // check optimality conditions (takes time proportional to E V lg* V)
    private boolean check(Graph G) {

        // check total weight
        double total = 0.0;
        for (Edge e : edges()) {
            total += e.getWeight();
        }
        if (Math.abs(total - weight()) > FLOATING_POINT_EPSILON) {
            System.err.printf("Weight of edges does not equal weight(): %f vs. %f\n", total, weight());
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


    /**

     public static void main(String[] args) {
     In in = new In(args[0]);
     EdgeWeightedGraph2 G = new EdgeWeightedGraph2(in);
     KruskalMST mst = new KruskalMST(G);
     for (EdgeImpl2 e : mst.edges()) {
     StdOut.println(e);
     }
     StdOut.printf("%.5f\n", mst.weight());
     }
     */
}
