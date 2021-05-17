package Interfaces;

public interface GraphRoute {
    int getVertiesCount();
    int getEgdeCount();
    Iterable<EdgeFly> adj(String code);
    Iterable<EdgeFly> edges();
}
