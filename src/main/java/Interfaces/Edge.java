package Interfaces;

public interface Edge extends Comparable<Edge> {
    int from();
    int to();
    float getWeight();
}
