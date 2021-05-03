package Interfaces;

public interface Graph {
    int V();
    int E();
    Iterable<Edge> adj(int v);
    Iterable<Edge> edges();
}
