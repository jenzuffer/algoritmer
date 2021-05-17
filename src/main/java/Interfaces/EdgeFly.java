package Interfaces;

import Implementation.Airport;

public interface EdgeFly extends Comparable<EdgeFly>{
    String airlineCode();
    double getDistance();
    Airport getDepartedAirport();
    Airport getDestinationAirport();
}
