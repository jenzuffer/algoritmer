package Algoritmer;

import Implementation.dto.Airport;
import Implementation.queue.Queue;

import Interfaces.EdgeFly;

import Interfaces.GraphRoute;

import java.util.HashMap;

public class DFS {

    private HashMap<String, Boolean> marked;
    private Queue pq;

    public DFS(GraphRoute graphRoute, String departure_code, String destination_code) {
        this.marked = new HashMap<>(graphRoute.getVertiesCount());
        marked.put(departure_code, true);
        pq = new Queue();
        pq.enqueue(departure_code);
        while (!pq.isEmpty()) {
            String dequeue = (String) pq.dequeue();
            //System.out.println("\n\nDequeue: " + dequeue);
            fillDFS(graphRoute, dequeue, destination_code);
        }
    }

    public void fillDFS(GraphRoute graph, String dequeue, String destination_code) {
        for (EdgeFly edgeFly : graph.adj(dequeue)) {
            Airport destinationAirport = edgeFly.getDestinationAirport();
            double distance = edgeFly.getDistance();
            String airline_code = edgeFly.airlineCode();
            String code = destinationAirport.getCode();
            if (marked.get(code) == null || !marked.get(code)) {
                marked.put(code, true);
                pq.enqueue(code);
                //System.out.println("code: " + code);
                //pq.dequeue();
                //System.out.println("distance: " + distance + " airline_code: " + airline_code);
                //System.out.println("edgeFly.getDepartedAirport().getCode(): " + edgeFly.getDepartedAirport().getCode());
                fillDFS(graph, code, destination_code);
            }
        }
    }
}
