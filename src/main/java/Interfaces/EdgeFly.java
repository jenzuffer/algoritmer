package Interfaces;

import Implementation.Airport;

public interface EdgeFly extends Comparable<EdgeFly>{
    String aircraftCode();
    double getDistance();
    Airport getDepartedAirport();
    Airport getDestinationAirport();
}
