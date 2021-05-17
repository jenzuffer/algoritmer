package Interfaces;

import Implementation.dto.Airport;

public interface EdgeFly extends Comparable<EdgeFly>{
    String airlineCode();
    double getDistance();
    Airport getDepartedAirport();
    Airport getDestinationAirport();
}
