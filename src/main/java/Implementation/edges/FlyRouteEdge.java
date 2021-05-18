package Implementation.edges;

import Implementation.dto.Airport;
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

    public FlyRouteEdge(EdgeFly edgeFly) {
        this.source = edgeFly.getDepartedAirport();
        this.destination = edgeFly.getDestinationAirport();
        this.distance = edgeFly.getDistance();
        this.airlines_codes = edgeFly.airlineCode();
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
        if (this.distance < o.getDistance()) return -1;
        else if (this.distance > o.getDistance()) return +1;
        else return 0;
    }
}
