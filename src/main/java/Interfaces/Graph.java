package Interfaces;

public interface Graph {
    int getVertiesCount();
    int getEgdeCount();
    Iterable<Edge> adj(int v);
    Iterable<Edge> edges();
}
