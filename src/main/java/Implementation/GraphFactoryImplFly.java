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
    public GraphRoute readFromObjects(List<Aircraft> aircrafts, List<Airline> airlines, List<Airport> airports,
                                      List<Route> routes, String airline) {
        GraphBuilderRoute builder = getNewBuilder(airports.size());
        HashMap<String, Airport> airportHashMap = new HashMap<>();
        for (Airport airport : airports) {
                airportHashMap.put(airport.getCode(), airport);
        }
        //System.out.println("airportHashMap size: " + airportHashMap.size() + " routes size: " + routes.size());
        for (Route route : routes) {
            String airline_code = route.getAirline_code();
            //using only a single airline company from start to finish
            //if (!airline_code.equals(airline)) continue;
            String source_code = route.getSource_code();
            String destination_code = route.getDestination_code();
            Airport airport_source = airportHashMap.get(source_code);
            Airport airport_destination = airportHashMap.get(destination_code);
            double distance = route.getDistance();
            float time = route.getTime();
            builder.addEdge(airport_source, airport_destination, distance, airline_code, time);
        }

        return builder.build();
    }

    @Override
    public GraphBuilderRoute getNewBuilder(int verticeCount) {
        return new GraphImplFly(verticeCount);
    }
}
