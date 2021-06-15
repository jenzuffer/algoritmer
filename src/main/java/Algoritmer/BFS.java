package Algoritmer;

import Implementation.dto.Airport;
import Implementation.queue.Queue;
import Interfaces.EdgeFly;
import Interfaces.GraphRoute;

import java.util.HashMap;

public class BFS {

    private HashMap<String, Boolean> marked;
    private Queue pq;

    public BFS(GraphRoute graphRoute, String departure_code, String destination_code) {
        this.marked = new HashMap<>(graphRoute.getVertiesCount());
        marked.put(departure_code, true);
        pq = new Queue();
        pq.enqueue(departure_code);

        while (!pq.isEmpty()) {
            String dequeue = (String) pq.dequeue();
            //System.out.println("\n\nDequeue: " + dequeue);
            for (EdgeFly edgeFly : graphRoute.adj(dequeue)) {
                double distance = edgeFly.getDistance();
                String airline_code = edgeFly.airlineCode();
                Airport destinationAirport = edgeFly.getDestinationAirport();
                String code = destinationAirport.getCode();
                if (marked.get(code) == null || !marked.get(code)) {
                    marked.put(code, true);
                    pq.enqueue(code);
                    System.out.println("BFS from " + dequeue + " to " + code + " distance " + distance);
                    /*System.out.println("code: " + code);
                    System.out.println("distance: " + distance + " airline_code: " + airline_code);
                    System.out.println("edgeFly.getDepartedAirport().getCode(): " + edgeFly.getDepartedAirport().getCode());*/
                    //if (code.equals(destination_code)) return;
                }
            }
        }
    }
}
