package Implementation;

import Implementation.GraphImpl;
import Implementation.edges.FlyRouteEdge;
import Interfaces.Graph;
import Interfaces.GraphBuilder;
import Interfaces.GraphFactory;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class GraphFactoryImpl implements GraphFactory {
    @Override
    public GraphBuilder getNewBuilder(int verticeCount) {
        return new GraphImpl(verticeCount);
    }

    @Override
    public Graph readFromFile(String fileName) throws IOException {
        InputStream in = new FileInputStream(fileName);
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(in))) {
            String line = br.readLine();
            int v = Integer.parseInt(line);
            GraphBuilder builder = getNewBuilder(v);
            line = br.readLine();
            int e = Integer.parseInt(line);
            for (int i = 0; i < e; ++i) {
                line = br.readLine();
                if (line == null) break;
                String[] vs = line.split(" ");
                int v1 = Integer.parseInt(vs[0]);
                int v2 = Integer.parseInt(vs[1]);
                float w = Float.parseFloat(vs[2]);
                builder.addEdge(v1, v2, w);
            }
            return builder.build();
        }
    }

    //airports = nodes
    //routes = edges

    @Override
    public Graph readFromObjects(List<Aircraft> aircrafts, List<Airline> airlines, List<Airport> airports, List<Route> routes) {
        GraphBuilder builder = getNewBuilder(airports.size());
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


        }

    }

}
