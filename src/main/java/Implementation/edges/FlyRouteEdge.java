package Implementation.edges;

import Implementation.Airport;
import Implementation.Route;
import Interfaces.Edge;
import Interfaces.EdgeFly;

public class FlyRouteEdge implements EdgeFly {
    private Airport source;
    private Airport destination;
    private double distance;
    private String aircraftcode;

    public FlyRouteEdge(Airport source, Airport destination, double distance, String aircraftcode) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.aircraftcode = aircraftcode;
    }

    @Override
    public String aircraftCode() {
        return this.aircraftcode;
    }

    @Override
    public double getDistance() {
        return 0;
    }

    @Override
    public Airport getDepartedAirport() {
        return null;
    }

    @Override
    public Airport getDestinationAirport() {
        return null;
    }

    @Override
    public int compareTo(EdgeFly o) {
        return 0;
    }
}
