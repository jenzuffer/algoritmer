package Interfaces;

import Implementation.Airport;

public interface GraphBuilderRoute {
    GraphRoute build();
    void addEdge(Airport departure, Airport destination, double distance, String airlines_codes);
}
