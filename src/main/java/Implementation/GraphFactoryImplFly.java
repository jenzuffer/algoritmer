package Implementation;

import Implementation.dto.Aircraft;
import Implementation.dto.Airline;
import Implementation.dto.Airport;
import Interfaces.Graph;
import Interfaces.GraphBuilderRoute;
import Interfaces.GraphFactoryFly;
import Interfaces.GraphRoute;

import java.util.HashMap;
import java.util.List;

public class GraphFactoryImplFly implements GraphFactoryFly {

    @Override
    public GraphRoute readFromObjects(List<Aircraft> aircrafts, List<Airline> airlines, List<Airport> airports, List<Route> routes) {
        GraphBuilderRoute builder = getNewBuilder(airports.size());
        HashMap<String, Airport> airportHashMap = new HashMap<>();
        for (Airport airport : airports){
            airportHashMap.put(airport.getCode(), airport);
        }
        for (Route route : routes) {
            String source_code = route.getSource_code();
            String destination_code = route.getDestination_code();
            Airport airport_source = airportHashMap.get(source_code);
            Airport airport_destination = airportHashMap.get(destination_code);
            double distance = route.getDistance();
            String airline_code = route.getAirline_code();
            builder.addEdge(airport_source, airport_destination, distance, airline_code);
        }
        return builder.build();
    }

    @Override
    public GraphBuilderRoute getNewBuilder(int verticeCount) {
        return new GraphImplFly(verticeCount);
    }
}
