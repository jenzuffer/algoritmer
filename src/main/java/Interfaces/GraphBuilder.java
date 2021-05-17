package Interfaces;

import Implementation.Airport;
import Interfaces.Graph;

public interface GraphBuilder {
    void addEdge(int v1, int v2, float weight);
    Graph build();
}
