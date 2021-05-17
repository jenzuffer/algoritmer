package Implementation.edges;

import Implementation.Airport;
import Implementation.Route;
import Interfaces.Edge;
import Interfaces.EdgeFly;

public class FlyRouteEdge implements EdgeFly {
    private Airport source;
    private Airport destination;
    private double distance;
    private String airlines_codes;

    public FlyRouteEdge(Airport source, Airport destination, double distance, String airlines_codes) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.airlines_codes = airlines_codes;
    }

    @Override
    public String airlineCode() {
        return this.airlines_codes;
    }

    @Override
    public double getDistance() {
        return distance;
    }

    @Override
    public Airport getDepartedAirport() {
        return source;
    }

    @Override
    public Airport getDestinationAirport() {
        return destination;
    }

    @Override
    public int compareTo(EdgeFly o) {
        return 0;
    }
}
