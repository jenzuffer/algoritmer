package Implementation;

import Interfaces.Graph;
import Interfaces.GraphBuilderRoute;
import Interfaces.GraphFactoryFly;

import java.util.List;

public class GraphFactoryImplFly implements GraphFactoryFly {

    @Override
    public Graph readFromObjects(List<Aircraft> aircrafts, List<Airline> airlines, List<Airport> airports, List<Route> routes) {
        return null;
    }

    @Override
    public GraphBuilderRoute getNewBuilder(int verticeCount) {
        return new GraphImplFly(verticeCount);
    }
}
