package Interfaces;

public interface GraphRoute {
    int getVertiesCount();
    int getEgdeCount();
    Iterable<EdgeFly> adj(int v);
    Iterable<EdgeFly> edges();
}
